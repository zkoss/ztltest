import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3099277TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3099277TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				You shall see "value 1" on the right bottom corner after click the button.
				<separator/>
				<listbox name="listbox" mold="select">
					<listitem label="item1" value="value 1"/>
				</listbox>
				<button id="btn" label="click" xmlns:w="client">
					<attribute w:name="onClick"><![CDATA[
						zk.log(this.previousSibling.firstChild.$n().value);
					
					]]></attribute>
				</button>
			</zk>`,
	);
	await t
		.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()))
		.wait(500);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-log").find("textarea")[0].value,
				)(),
			),
		)
		.contains(ztl.normalizeText("value 1"), "");
});
