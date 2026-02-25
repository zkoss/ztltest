import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1893575TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1893575TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="w" mode="modal" xmlns:n="http://www.zkoss.org/2005/zk/native" width="500px">
    			<n:p>Please click the "female" radio, and then click the "show" button, and then you should see that only "female" is checked. (Only IE)</n:p>
    			<radiogroup id="radiochoice">
    				<radio id="male1" label="male" checked="true" />
    				<radio id="female" label="female" />
    			</radiogroup>
    			<button label="show">
    				<attribute name="onClick">
						new Label("Test").page = w.page;
    				</attribute>
    			</button>
    		</window>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq("$female")).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("$female")).$n("real").checked,
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("$male1")).$n("real").checked,
				)(),
			),
		)
		.notEql(ztl.normalizeText("true"), "");
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("$female")).$n("real").checked,
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("$male1")).$n("real").checked,
				)(),
			),
		)
		.notEql(ztl.normalizeText("true"), "");
});
