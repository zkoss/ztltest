import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3288779TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3288779TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Click "model1 button".</li>
			<li>Click header twice.</li>
			<li>The Grid shall be sorted well.</li>
			<li>Click "model2 button".</li>
			<li>Click header twice.</li>
			<li>It shall not appear any error, and the Grid shall be sorted well.</li>
		</ol>
	]]></html>
	<zscript><![CDATA[
		import org.zkoss.zul.*;
		import java.util.*;
		public class Person {
			private String name;
	
			public Person(String name) {
				this.name = name;
			}
	
			public void setName(String name) {
				this.name = name;
			}
	
			public String getName() {
				return name;
			}
		}
		List list = new ArrayList();
		list.add(new Person("Jimmy"));
		list.add(new Person("Katrina"));
		ListModel model1 = new ListModelList(list);
		list = new ArrayList();
		list.add(new String[] { "Jimmy" });
		list.add(new String[] { "Katrina" });
		ListModel model2 = new ListModelList(list);
		void model1() {
			grid.model = null;
			col.setSort("auto(name)");
			grid.rowRenderer = new RowRenderer() {
				public void render(Row row, Object data, int index) throws Exception {
					row.appendChild(new Label(((Person) data).getName()));
				}
			};
			grid.model = model1;
		}
		void model2() {
			grid.model = null;
			col.setSort("auto(0)");
			grid.rowRenderer = new RowRenderer() {
				public void render(Row row, Object data, int index) throws Exception {
					row.appendChild(new Label(((String[]) data)[0]));
				}
			};
			grid.model = model2;
		}
	]]></zscript>
	<button label="model1" onClick="model1();" />
	<button label="model2" onClick="model2();" />
	<grid id="grid" width="300px">
		<columns>
			<column id="col" label="column" />
		</columns>
	</grid>
</zk>`,
	);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@column")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@column")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Katrina"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Jimmy"));
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@column")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@column")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Katrina"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Jimmy"));
});
