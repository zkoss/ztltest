import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3167027TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3167027TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Click "add node" button.</li>
			<li>A "new item" shall appear.</li>
		</ol>
	]]></html>
	<button label="add node">
		<attribute name="onClick"><![CDATA[
			Treerow tr = new Treerow();
			item.appendChild(tr);
			tr.appendChild(new Treecell("new Item"));
		]]></attribute>
	</button>
	<tree>
		<treechildren>
			<treeitem id="item"/>
		</treechildren>
	</tree>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq("@treecell:eq(0)")[0])())
		.notOk();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq("@treecell:eq(0)")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@treecell:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("new Item"), "");
});
