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
	const windowContent = Selector(() =>
		zk.Desktop._dt.$f("win", true).$n("cave"),
	).addCustomDOMProperties({ height: (cave) => jq(cave).height() });
	const tree = Selector(() =>
		zk.Desktop._dt.$f("tree2", true).$n(),
	).addCustomDOMProperties({ height: (el) => jq(el).outerHeight() });
	const windowHeight = await windowContent.height;
	const treeHeight = await tree.height;
	await t
		.expect(treeHeight)
		.within(
			windowHeight - 1,
			windowHeight + 1,
			"the tree should fill the window",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	let smallWindowHeight = await windowContent.height;
	await t
		.expect(tree.height)
		.within(
			smallWindowHeight - 1,
			smallWindowHeight + 1,
			"the tree should follow the window's height",
		);
	await t
		.expect(smallWindowHeight)
		.lte(windowHeight * 0.3, "the window should shrink to 30%");
	await t
		.expect(tree.height)
		.lte(treeHeight * 0.3, "the tree should shrink with the window");
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	smallWindowHeight = await windowContent.height;
	await t
		.expect(tree.height)
		.within(
			smallWindowHeight - 1,
			smallWindowHeight + 1,
			"the tree should still fill the window after it is redrawn",
		);
	await t
		.expect(smallWindowHeight)
		.lte(windowHeight * 0.3, "the window should stay at 30%");
	await t
		.expect(tree.height)
		.lte(treeHeight * 0.3, "the redrawn tree should stay small");
});
