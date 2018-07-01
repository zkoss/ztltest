package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1867.zul")
class B65_ZK_1867Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1867.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Jul 26, 2013  4:08:40 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1.select on listbox, you will see the grid shows only one row as same as your selection
	2.click add to add more new items.
	3.select on the new item of the listbox, the new added item should be shown on grid
	</label>
	<window border="normal" hflex="1" vflex="1">
	<zscript><![CDATA[
              
		ListModelList model1 = new ListModelList();
		model1.add("A");
		model1.add("B");
		model1.add("C");
		ListModelList model2 = new ListModelList();
		model2.add("A");
		model2.add("B");
		model2.add("C");
		
		void doSelect(int index){
			List children = grid1.getRows().getChildren();
			for(int i=0;i<children.size();i++){
				children.get(i).setVisible(i==index?true:false);
			}
		}
		void doAdd(){
			String str = ""+new Date(); 
			model1.add(str);
			model2.add(str);
		}
	]]></zscript>
		<button label="add" onClick="doAdd()"/>
		<listbox id="listbox1" model="${model1}" onSelect="doSelect(listbox1.getSelectedIndex())"></listbox>
		<grid id="grid1" model="${model2}">
			<template name="model">
				<row visible="false">
					<label value="${each}"></label>
				</row>
			</template>
		</grid>
		
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-listitem:contains(A)"))
        waitResponse()
        val row = jq(".z-row:visible")
        verifyEquals("the grid shows only one row as same as your selection",
          row.length(), 1)
        verifyContains(row.text(), "A")

        click(jq(".z-button:contains(add)"))
        waitResponse()
        val last = jq(".z-listitem:last-child")
        click(last)
        waitResponse()
        verifyEquals("the new added item should be shown on grid",
          last.text(), row.text())

      })

  }
}