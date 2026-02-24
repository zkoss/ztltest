import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-2080TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-2080TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<zscript><![CDATA[
		public class Item {
			private String name;
		
			public Item(String name) {
				super();
				this.name = name;
			}
		
			public String getName() {
				return name;
			}
		
			public void setName(String name) {
				this.name = name;
			}
		
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((name == null) ? 0 : name.hashCode());
				return result;
			}
		
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Item other = (Item) obj;
				if (name == null) {
					if (other.name != null)
						return false;
				} else if (!name.equals(other.name))
					return false;
				return true;
			}
			
			//public String toString() { return this.name; }
		}
		List l2 = Arrays.asList(new Item[]{
				new Item("AA"), new Item("BB"), new Item("CC"), new Item("DD"), new Item("EE")});
                ListModelList model1 = new ListModelList(l2);
		ListSubModel smodel2 = (ListSubModel) ListModels.toListSubModel(new ListModelList(l2));
	]]></zscript>
	<label multiline="true">
	Type A in the input, should see popup with "AA" option showed.
	</label>
	ListSubModel
	<chosenbox id="box2" width="200px" model="\${smodel2}" >
		<template name="model">
			<label value="\${each.name}"/>
		</template>
	</chosenbox>
</zk>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-chosenbox")).$n("inp"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-chosenbox")).$n("inp")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("A");
	await ztl.waitResponse(t);
	await t.wait(200);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-chosenbox-option:contains(AA)")[0],
			)(),
		)
		.ok("should see popup with 'AA' option showed.");
});
