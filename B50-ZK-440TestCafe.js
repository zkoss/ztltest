import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-440TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-440TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>Click on "Add Item". There should be no javascript error.</div>
				<button id="btn" label="Add Item">
					<attribute name="onClick"><![CDATA[
						Listitem item = new Listitem("item");
						lb.appendChild(item);
						item.setSelected(true);
					]]></attribute>
				</button>
				<bandbox>
					<bandpopup>
						<listbox id="lb" />
					</bandpopup>
				</bandbox>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
