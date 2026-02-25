import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3293724TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3293724TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Click on "Hide 1". You should see item 5 left. Otherwise it is a bug.</li>
			<li>Click on "Show 1". You should see all items. Otherwise it is a bug.</li>
			<li>Click on "Hide 2". You should see item 1,4,5 left. Otherwise it is a bug.</li>
			<li>Click on "Show 2". You should see all items again. Otherwise it is a bug.</li>
		</ol>
	]]></html>
	<div>
		<button label="Hide 1" width="70px" onClick="t1.visible = false" />
		<button label="Hide 2" width="70px" onClick="t2.visible = false" />
	</div>
	<div>
		<button label="Show 1" width="70px" onClick="t1.visible = true" />
		<button label="Show 2" width="70px" onClick="t2.visible = true" />
	</div>
	<tree id="tree" rows="12">
		<treechildren>
			<treeitem id="t1">
				<treerow>
					<treecell>
						<label value="item1" />
					</treecell>
				</treerow>
				<treechildren>
					<treeitem id="t2">
						<treerow>
							<treecell>
								<label value="item2" />
							</treecell>
						</treerow>
						<treechildren>
							<treeitem id="t3">
								<treerow>
									<treecell>
										<label value="item3" />
									</treecell>
								</treerow>
							</treeitem>
						</treechildren>
					</treeitem>
					<treeitem id="t4">
						<treerow>
							<treecell>
								<label value="item4" />
							</treecell>
						</treerow>
					</treeitem>
				</treechildren>
			</treeitem>
			<treeitem id="t5">
				<treerow>
					<treecell>
						<label value="item5" />
					</treecell>
				</treerow>
			</treeitem>
		</treechildren>
	</tree>
</zk>`,
	);
	await t.click(Selector(() => jq('@button[label="Hide 1"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-treerow:visible").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("item5"), "");
	await t.click(Selector(() => jq('@button[label="Show 1"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("5"));
	await t.click(Selector(() => jq('@button[label="Hide 2"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-treerow:visible").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("item5"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-treerow:visible").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("item4"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-treerow:visible").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("item1"), "");
	await t.click(Selector(() => jq('@button[label="Show 2"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("5"));
});
