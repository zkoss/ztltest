import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3053311TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3053311TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk>
	<label multiline="true">
		<attribute name="value">
			1. Open the menubar, and see the color in the menu item
			2. Click "Vertical orient" to change menubar\'s orient
			3. Open the menubar again, the color shoule be the same, if it change to black, it\'is wrong.
		</attribute>
	</label>
	<menubar id="menubar" width="100%">
		<menu image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
			<menupopup>
				<menu label="Color Picker" content="#color=#184dc6" />
			</menupopup>
		</menu>
	</menubar>
	<checkbox id="chgOrient" label="Vertical orient">
		<attribute name="onCheck">
			menubar.orient = self.checked ? "vertical" : "horizontal";
		</attribute>
	</checkbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-menu")[0]));
	await ztl.waitResponse(t);
	let color1_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-menu")).$n()).css("backgroundColor"),
	)();
	await t.click(
		Selector(() => jq("@label:eq(0)")[0]),
		{ offsetX: 6, offsetY: 6 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("chgOrient", true).$n("real")),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menu")[0]));
	await ztl.waitResponse(t);
	let color2_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-menu")).$n()).css("backgroundColor"),
	)();
	await t
		.expect(ztl.normalizeText(color2_cafe))
		.eql(ztl.normalizeText(color1_cafe));
});
