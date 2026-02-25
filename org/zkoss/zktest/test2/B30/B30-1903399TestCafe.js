import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1903399TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1903399TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Context Menu and Right Click" border="normal" width="450px">
				<label id="desp" value="Right click at all following labels. It shall bring the context menu." />
				<separator bar="true"/>
				<label id="lb1" value="Direct assign" context="editPopup"/>
				<separator bar="true"/>
				<label id="test" value="setContext(editPopup)" />
				<separator bar="true"/>
				<label id="test2" value="setContext(editPopup.getID())" />
				
				<menupopup id="editPopup">
					<menuitem label="Undo"/>
					<menuitem label="Redo"/>
					<menu label="Sort">
						<menupopup>
							<menuitem label="Sort by Name" autocheck="true"/>
							<menuitem label="Sort by Date" autocheck="true"/>
						</menupopup>
					</menu>
				</menupopup>
				
				<zscript>
					test.setContext( editPopup );
					test2.setContext( editPopup.getId() );
				</zscript>
			</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@menupopup:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.rightClick(Selector(() => jq("$lb1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq("@menupopup:visible")[0])())
		.ok();
	await t.click(
		Selector(() => jq(zk.Widget.$(jq("@window")).$n("cap"))[0]),
		{ offsetX: 10, offsetY: 10 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@menupopup:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.rightClick(Selector(() => jq("$test")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq("@menupopup:visible")[0])())
		.ok();
	await t.click(
		Selector(() => jq(zk.Widget.$(jq("@window")).$n("cap"))[0]),
		{ offsetX: 10, offsetY: 10 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@menupopup:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.rightClick(Selector(() => jq("$test2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq("@menupopup:visible")[0])())
		.ok();
	await t.click(
		Selector(() => jq(zk.Widget.$(jq("@window")).$n("cap"))[0]),
		{ offsetX: 10, offsetY: 10 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@menupopup:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
});
