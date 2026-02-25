import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1615919TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1615919TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Click <button id="btn" label="Create" onClick="create2()"/> to open a modal window
				and test if it is draggable.
				<zscript><![CDATA[
				public void create2() {
					final Window win = (Window) Executions.createComponentsDirectly(
					"<window border=\\"normal\\" closable=\\"true\\" width=\\"300px\\" title=\\"modal\\">"
					+"<listbox><listitem label=\\"a1\\"/></listbox></window>", null, null, null);
					win.doModal();
				}
				]]></zscript>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	let left_cafe = await ClientFunction(() => jq("@window").css("left"))();
	let top_cafe = await ClientFunction(() => jq("@window").css("top"))();
	await t.drag(
		Selector(() => zk.Widget.$(jq("@window")).$n("cap")),
		150,
		150,
		{ offsetX: 10, offsetY: 10 },
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@window").css("left"))(),
			),
		)
		.notEql(ztl.normalizeText(left_cafe), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@window").css("top"))(),
			),
		)
		.notEql(ztl.normalizeText(top_cafe), "");
});
