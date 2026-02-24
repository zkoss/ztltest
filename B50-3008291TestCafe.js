import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3008291TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3008291TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<window border="normal" width="200px">
		<button label="Remove" onClick=\'lbx.removeItemAt(0);\' />
		<listbox id="lbx">
			<listhead>
				<listheader label="Label" />
			</listhead>
			<listitem label="3" />
			<listitem label="2" />
			<listitem label="1" />
			<listitem label="-" />
			<listitem label="-" selected="true" focus="true"/>
		</listbox>
	</window>
	</zk>`,
	);
	await t
		.click(Selector(() => jq('@window @listcell[label="-"]:eq(1)')[0]))
		.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lbx", true).$n("cave")).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lbx", true).$n("body")).outerWidth(),
				)(),
			),
		);
});
