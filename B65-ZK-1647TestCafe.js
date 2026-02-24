import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1647TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1647TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	1. Should not see horizontal scrollbar showed.
	2. Pink area should be twice as wide as the blue area.
	</label>
	<separator />
	<hbox width="400px">
		<tree hflex="1">
			<treecols>
				<treecol hflex="1" />
				<treecol hflex="2" />
				<treecol width="50px"/>
			</treecols>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="Item 1" style="background: cyan" />
						<treecell label="Item 1" style="background: pink" />
						<treecell label="Item 1" />
					</treerow>
				</treeitem>
			</treechildren>
		</tree>
	</hbox>
</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-treerow").width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-tree-body").width(),
	)();
	await t
		.expect(verifyVariable_cafe_1_1 >= verifyVariable_cafe_0_0)
		.ok("Should not see horizontal scrollbar showed.");
	let diff_cafe_2 = await ClientFunction(() =>
		jq(".z-treecell[style*=pink]").outerWidth(),
	)();
	let diff_cafe_3 = await ClientFunction(() =>
		jq(".z-treecell[style*=cyan]").outerWidth(),
	)();
	let diff_cafe = diff_cafe_2 - 2 * diff_cafe_3;
	let verifyVariable_cafe_2_4 = await ClientFunction(() =>
		jq(".z-treecell[style*=pink]").outerWidth(),
	)();
	let verifyVariable_cafe_3_5 = await ClientFunction(() =>
		jq(".z-treecell[style*=cyan]").outerWidth(),
	)();
	let verifyVariable_cafe_4_6 = await ClientFunction(() =>
		jq(".z-treecell[style*=pink]").outerWidth(),
	)();
	let verifyVariable_cafe_5_7 = await ClientFunction(() =>
		jq(".z-treecell[style*=cyan]").outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_4),
		ztl.normalizeText(2 * verifyVariable_cafe_5_7),
		ztl.normalizeText("2"),
	);
});
