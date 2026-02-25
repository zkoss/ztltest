import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1892446TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1892446TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="win" title="Dynamically Change by Model">
	<zscript>
		
		import org.zkoss.zktest.test2.tree.TreeModelA;
		//An ArrayList is created to be the root of tree
		ArrayList mother = new ArrayList();
		
		//Create a branch "child1" and assign children to it
		ArrayList child1 = new ArrayList();
		child1.add("Tommy");
		child1.add("Juile");
		
		//Create a branch "child2" and assign children to it
		ArrayList child2 = new ArrayList();
		child2.add("Gray");
		
		//Create a branch "grandchild" and assign children to it
		ArrayList grandChild = new ArrayList();
		grandChild.add("Paul");
		grandChild.add("Eric");
		
		//Assign branch "grandchild" to be branch "child2"\'s child
		child2.add(grandChild);
		
		//Assign branch "grand2" to be branch "child1"\'s child
		child1.add(child2);
		
		//Assign children to root "mother"
		mother.add("Andy");
		mother.add("Davis");
		mother.add(child1);
		mother.add("Matter");
		mother.add("Kitty");
		
		//TreeModelA class is contructed, only the root "mother" of tree is passed to its constructor.
		TreeModelA tma = new TreeModelA(mother);
		
		ArrayList childnew = new ArrayList();
		childnew.add("Clinton");
		childnew.add("Obama");

		
		public void replace(){
			Object[] data = {childnew};
			tma.set(mother,2,2,data);
		}
		
	</zscript>
		
		<vbox>
			Click on "Replace," if the 3rd item of both tree turns to [Clinton, Obama], it is correct.
			<tree model="\${tma}" id="tree" >
		</tree>
		<hbox>
			
			<button label="Replace" onClick="replace();" />
		</hbox>
		</vbox>
		<zscript>
			Tree t2 = (Tree)tree.clone();
			t2.setId("tree2");
			t2.setParent(win);
		</zscript>
	</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tree")
						.eq(0)
						.find("@treecell")
						.eq(2)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("[Tommy, Juile, [Gray, [Paul, Eric]]]"),
			"",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tree")
						.eq(1)
						.find("@treecell")
						.eq(2)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("[Tommy, Juile, [Gray, [Paul, Eric]]]"),
			"",
		);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tree")
						.eq(0)
						.find("@treecell")
						.eq(2)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("[Clinton, Obama]"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tree")
						.eq(1)
						.find("@treecell")
						.eq(2)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("[Clinton, Obama]"), "");
});
