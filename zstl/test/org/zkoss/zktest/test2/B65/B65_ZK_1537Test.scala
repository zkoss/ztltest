package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1537.zul")
class B65_ZK_1537Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
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
					<listcell label="${each.name}" />
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
</zk>
    """

    runZTL(zscript,
      () => {
        verifyTrue("you should see last item is selected.", jq(".z-listitem-selected:contains(item 9)").exists())
      })

  }
}
