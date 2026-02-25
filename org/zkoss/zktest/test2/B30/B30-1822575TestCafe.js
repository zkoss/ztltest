import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1822575TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1822575TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Change window\'s height, component won\'t resize
	<button id="btn1" label="Set window to 30%">
		<attribute name="onClick">win.setHeight("30%");</attribute>
	</button>
	<button id="btn2" label="invalidate Tree" onClick=\'win.getFellow("tree2").invalidate()\'/>
	<window title = "Win" id="win" height="100%" width="90%" border="normal">
		<tree id="tree2" vflex="true">
			<treecols sizable="true">
				<treecol label="Name" />
				<treecol label="Description" />
			</treecols>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 2" />
						<treecell label="Item 2 description" />
					</treerow>
				</treeitem>
				<treeitem label="Item 3" />
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
			</treechildren>
		</tree>
	</window>
</zk>`,
	);
	let winHgh_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win", true).$n("cave")).height(),
	)();
	let treeHgh_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tree2", true)).outerHeight(),
	)();
	await t
		.expect(ztl.normalizeText(winHgh_cafe))
		.eql(ztl.normalizeText(treeHgh_cafe));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	let winHgh2_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win", true).$n("cave")).height(),
	)();
	let treeHgh2_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tree2", true)).outerHeight(),
	)();
	await t
		.expect(ztl.normalizeText(winHgh2_cafe))
		.eql(ztl.normalizeText(treeHgh2_cafe));
	await t.expect(winHgh_cafe * 0.3 >= winHgh2_cafe).ok();
	await t.expect(treeHgh_cafe * 0.3 >= treeHgh2_cafe).ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	winHgh2_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win", true).$n("cave")).height(),
	)();
	treeHgh2_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tree2", true)).outerHeight(),
	)();
	await t
		.expect(ztl.normalizeText(winHgh2_cafe))
		.eql(ztl.normalizeText(treeHgh2_cafe));
	await t.expect(winHgh_cafe * 0.3 >= winHgh2_cafe).ok();
	await t.expect(treeHgh_cafe * 0.3 >= treeHgh2_cafe).ok();
});
