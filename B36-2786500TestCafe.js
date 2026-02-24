import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2786500TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2786500TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<label id="desp" value="Please press both labels, and they should work well." />
				<vbox>
				<label id="label1" value="Click 1" onClick="title.open(title)"
				/>
				<label id="label2" value="Click 2" popup="title" />
				</vbox>
				<menupopup id="title" >
				<menuitem label="test"/>
				</menupopup>
			</zk>`,
	);
	await t.click(Selector(() => jq(zk.Desktop._dt.$f("label1", true))[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@menuitem").is(":visible"))())
		.ok();
	await t.click(
		Selector(() => zk.Desktop._dt.$f("desp", true).$n()),
		{ offsetX: 80, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@menuitem").is(":visible"))())
		.notOk();
	await t.click(Selector(() => jq("@label")[2]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@menuitem").is(":visible"))())
		.ok();
});
