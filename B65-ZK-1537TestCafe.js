import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1537TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1537TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	Issue : get NPE in CE (not in EE)
	1. you should see last item is selected.
	</label>
	<div width="400px" >
		<listbox id="listbox" mold="paging" pageSize="10">
			<listhead>
				<listheader label="name" />
			</listhead>
			<template name="model" >
				<listitem>
					<listcell label="\${each.name}" />
				</listitem>
			</template>
		</listbox>
	</div>
<zscript><![CDATA[
	class Item {
		String name;
		public Item() {
			
		}
		public Item(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	List itemList = new LinkedList();
	for (int i = 0; i < 10; i++) {
		itemList.add(new Item("item " + i));
	}
	ListModelList listModelList = new ListModelList(itemList);//if use live list
	listbox.setModel(listModelList);
	
	
	Item selected = itemList.get(itemList.size()-1);
	listModelList.addToSelection(selected);
]]>
</zscript>
</zk>`,
	);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-listitem-selected:contains(item 9)")[0],
			)(),
		)
		.ok("you should see last item is selected.");
});
