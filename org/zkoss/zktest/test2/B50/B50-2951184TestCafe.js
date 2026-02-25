import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2951184TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2951184TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
					<html><![CDATA[
					<ol>
						<li>Click the arrow icon and the tree item shall be opened</li>
						<li>Click "1" and a dialog shall be shown</li>
					</ol>
					]]></html>
				    <tree>
				        <treechildren>
				            <treeitem open="false">
				                <treerow onClick=\'alert("row clicked")\'>
				                    <treecell label="1"/>
				                </treerow>
				                <treechildren>
				                    <treeitem>
				                        <treerow>
				                            <treecell label="a"/>
				                        </treerow>
				                    </treeitem>
				                </treechildren>
				            </treeitem>
				        </treechildren>
				    </tree>
				</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.click(Selector(() => zk.Widget.$(jq(".z-treerow")).$n("icon")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.click(Selector(() => jq(".z-treecell")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-window-highlighted")).is(":visible"),
			)(),
		)
		.ok();
});
