import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2129667TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2129667TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Live Data" border="normal">
	<html>
		<attribute name="content">
		<ol>
		<li>Click "Change Renderer 1", and you shall see "option 1",
		"option 2", and so on in both list and grid.</li>
		<li>Click "Change Renderer 2", and you shall see "plan 1",
		"plan 2", and so on in both list and grid.</li>
		</ol>
		</attribute>
	</html>
	<zscript><![CDATA[
		String[] data = new String[30];
		for(int j=0; j < data.length; ++j) {
			data[j] = ""+j;
		}
		ListModel strset = new SimpleListModel(data);

		ListitemRenderer renderl1 = new ListitemRenderer() {
			public void render(Listitem item, Object data, int index) {
				item.setLabel("option " + data);
			}
		};
		ListitemRenderer renderl2 = new ListitemRenderer() {
			public void render(Listitem item, Object data, int index) {
				item.setLabel("plan " + data);
			}
		};

		RowRenderer renderr1 = new RowRenderer() {
			public void render(Row row, Object data, int index) {
				row.appendChild(new Label("option " + data));
			}
		};
		RowRenderer renderr2 = new RowRenderer() {
			public void render(Row row, Object data, int index) {
				row.appendChild(new Label("plan " + data));
			}
		};
	]]></zscript>
	<hbox>
	<listbox id="list" width="200px" rows="10" model="\${strset}">
		<listhead>
			<listheader label="Load on Demend" sort="auto"/>
		</listhead>
	</listbox>
	<grid id="grid" width="200px" height="100px" model="\${strset}">
	</grid>
	</hbox>
	<button label="Change Renderer 1"
		onClick="list.setItemRenderer(renderl1); grid.setRowRenderer(renderr1);"/>
	<button label="Change Renderer 2"
		onClick="list.setItemRenderer(renderl2); grid.setRowRenderer(renderr2);"/>
</window>`,
	);
	await t.click(Selector(() => jq('@button[label="Change Renderer 1"]')[0]));
	await ztl.waitResponse(t);
	await t.wait(200);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(2)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(2)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(3)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(3)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(4)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(4)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(5)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(5)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(6)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 6"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(6)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 6"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(7)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 7"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(7)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 7"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(8)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 8"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(8)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 8"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(9)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 9"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(9)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("option 9"));
	await t.click(Selector(() => jq('@button[label="Change Renderer 2"]')[0]));
	await ztl.waitResponse(t);
	await t.wait(200);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(2)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(2)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(3)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(3)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(4)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(4)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(5)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(5)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(6)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 6"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(6)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 6"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(7)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 7"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(7)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 7"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(8)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 8"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(8)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 8"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listitem:eq(9)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 9"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(9)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("plan 9"));
});
