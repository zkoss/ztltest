import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F70-ZK-1974TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F70-ZK-1974TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<div>
		1. for each rod or in accordion mold tabbox, all heights of
		tabpanels should be same
	</div>
	<div>
		2. click \'add\', then the height of 4th tabpanel should not be
		same as other\'s height
	</div>
	<hbox>
		<window title="rod" border="normal" height="400px">
			<tabbox id="rod" maximalHeight="true" width="300px">
				<tabs id="tabs0">
					<tab label="Tab1" />
					<tab label="Tab2" />
					<tab label="Tab3" />
				</tabs>
				<tabpanels id="pnls0">
					<tabpanel>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 2</div>
						<div>Tabpanel Content 2</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
					</tabpanel>
				</tabpanels>
			</tabbox>
			<button label="add tab and tabpanel">
				<attribute name="onClick"><![CDATA[
	Tab tab = new Tab("Tab4");
	tab.setParent(tabs0);
	Tabpanel tp = new Tabpanel();
	tp.setHeight("600");

	for (int i = 0; i < 6; i++) {
		Div d = new Div();
		d.appendChild(new Label("Tabpanel Content 4"));
		tp.appendChild(d);
	}
	tp.setParent(pnls0);
]]></attribute>
			</button>

		</window>
		<window title="accordion" border="normal" height="400px">
			<tabbox maximalHeight="true" mold="accordion"
				width="300px">
				<tabs>
					<tab label="Tab1" />
					<tab label="Tab2" />
					<tab label="Tab3" />
				</tabs>
				<tabpanels>
					<tabpanel>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 2</div>
						<div>Tabpanel Content 2</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
					</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
		<window title="non rod" border="normal" height="400px">
			<tabbox width="300px">
				<tabs>
					<tab label="Tab1" />
					<tab label="Tab2" />
					<tab label="Tab3" />
				</tabs>
				<tabpanels>
					<tabpanel>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 2</div>
						<div>Tabpanel Content 2</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
					</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
	</hbox>
</zk>`,
	);
	await t.click(
		Selector(() => jq(".z-tabbox").eq(0).find(".z-tab:eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	await t.wait(500);
	let tph_cafe = await ClientFunction(() =>
		jq(".z-tabbox").eq(0).find(".z-tabpanel-content").eq(0).height(),
	)();
	await t.click(
		Selector(() => jq(".z-tabbox").eq(0).find(".z-tab:eq(1)")[0]),
	);
	await ztl.waitResponse(t);
	await t.wait(500);
	let tphNew_cafe = await ClientFunction(() =>
		jq(".z-tabbox").eq(0).find(".z-tabpanel-content").eq(1).height(),
	)();
	await t
		.expect(ztl.normalizeText(tphNew_cafe))
		.eql(
			ztl.normalizeText(tph_cafe),
			"all heights of tabpanels should be same",
		);
	await t.click(
		Selector(() => jq(".z-tabbox").eq(0).find(".z-tab:eq(2)")[0]),
	);
	await ztl.waitResponse(t);
	await t.wait(500);
	let tphNew_cafet = await ClientFunction(() =>
		jq(".z-tabbox").eq(0).find(".z-tabpanel-content").eq(2).height(),
	)();
	await t
		.expect(ztl.normalizeText(tphNew_cafet))
		.eql(
			ztl.normalizeText(tph_cafe),
			"all heights of tabpanels should be same",
		);
	await t.click(
		Selector(() => jq(".z-tabbox").eq(1).find(".z-tab:eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	await t.wait(500);
	let tph_cafet = await ClientFunction(() =>
		jq(".z-tabbox").eq(1).find(".z-tabpanel-content").eq(0).height(),
	)();
	await t.click(
		Selector(() => jq(".z-tabbox").eq(1).find(".z-tab:eq(1)")[0]),
	);
	await ztl.waitResponse(t);
	await t.wait(500);
	let tphNew_cafett = await ClientFunction(() =>
		jq(".z-tabbox").eq(1).find(".z-tabpanel-content").eq(1).height(),
	)();
	await t
		.expect(ztl.normalizeText(tphNew_cafett))
		.eql(
			ztl.normalizeText(tph_cafet),
			"all heights of tabpanels should be same",
		);
	await t.click(
		Selector(() => jq(".z-tabbox").eq(1).find(".z-tab:eq(2)")[0]),
	);
	await ztl.waitResponse(t);
	await t.wait(500);
	let tphNew_cafettt = await ClientFunction(() =>
		jq(".z-tabbox").eq(1).find(".z-tabpanel-content").eq(2).height(),
	)();
	await t
		.expect(ztl.normalizeText(tphNew_cafettt))
		.eql(
			ztl.normalizeText(tph_cafet),
			"all heights of tabpanels should be same",
		);
	let h_cafe = await ClientFunction(() =>
		jq(".z-tabbox").eq(0).find(".z-tabpanel").eq(2).height(),
	)();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-tabbox").eq(0).find(".z-tab:eq(3)")[0]),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-tabbox").eq(0).find(".z-tabpanel").eq(3).height(),
	)();
	await t
		.expect(h_cafe != verifyVariable_cafe_0_0)
		.ok("the height of 4th tabpanel should not be same as other's height");
});
