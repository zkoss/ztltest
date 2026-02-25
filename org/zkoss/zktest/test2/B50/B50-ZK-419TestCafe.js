import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-419TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-419TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<window title="new page title" border="normal">
				1. Please click the "add" button 3~5 times to see if the "new" tab is added one by one, the bug is fixed.
				<separator/>
				2. Click the "invalidate" button, the result is the same as before.
				
					<tabbox mold="accordion" id="tabBoxAdd">
						<tabs id="tabsAdd"></tabs>
						<tabpanels id="tabpanelsAdd"></tabpanels>
					</tabbox>
					<button id="btn1" label="add" onClick=\'add()\'></button>
					<zscript><![CDATA[
						void add() {
							Tab tab = new Tab("new");
							tabsAdd.appendChild(tab);
							Tabpanel tabpanel = new Tabpanel();
							tabpanelsAdd.appendChild(tabpanel);
						}
					]]></zscript>
					<button id="btn2" label="invalidate" onClick="tabBoxAdd.invalidate()"/>
				</window>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@tabpanel").length)(),
			),
		)
		.eql(
			ztl.normalizeText("1"),
			"new tab should added one by one while click add button",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@tabpanel").length)(),
			),
		)
		.eql(
			ztl.normalizeText("2"),
			"new tab should added one by one while click add button",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@tabpanel").length)(),
			),
		)
		.eql(
			ztl.normalizeText("3"),
			"new tab should added one by one while click add button",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@tabpanel").length)(),
			),
		)
		.eql(
			ztl.normalizeText("4"),
			"new tab should added one by one while click add button",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@tabpanel").length)(),
			),
		)
		.eql(
			ztl.normalizeText("5"),
			"new tab should added one by one while click add button",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@tabpanel").length)(),
			),
		)
		.eql(
			ztl.normalizeText("5"),
			"should keep the same after click invalidate button",
		);
});
