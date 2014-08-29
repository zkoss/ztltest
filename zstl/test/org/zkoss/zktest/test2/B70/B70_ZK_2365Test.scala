package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2365.zul")
class B70_ZK_2365Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2365.zul

	Purpose:
		
	Description:
		
	History:
		Thur, Jul 22, 2014  5:33:06 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk xmlns:h="native">
	<div>
		if those 4 empty messages don't appear with central alignment, it's a bug.
	</div>
	<listbox emptyMessage="No items to display." oddRowSclass="z-listbox-odd" rows="20" multiple="true" pagingPosition="bottom" sizedByContent="true" span="true" vflex="true">
        <listhead menupopup="none" sizable="true" visible="true" popup="auto">
            <listheader label="Scope" context="uuid(zb_pageHome_ZTableHeaderPopup_2)" style="text-align:center;" droppable="col" hflex="min" draggable="col"/>
        </listhead>
    </listbox>

    <listbox emptyMessage="No items to display." oddRowSclass="z-listbox-odd" rows="20" multiple="true" pagingPosition="bottom" sizedByContent="true" span="true" vflex="true">
        <listhead menupopup="none" sizable="true" visible="true" popup="auto">
            <listheader label="Subject" context="uuid(zb_pageHome_ZTableHeaderPopup_2)" style="text-align:center;" droppable="col" hflex="min" draggable="col"/>
            <listheader label="Text" context="uuid(zb_pageHome_ZTableHeaderPopup_2)" style="text-align:center;" droppable="col" hflex="min" draggable="col"/>
            <listheader label="Start Time" context="uuid(zb_pageHome_ZTableHeaderPopup_2)" style="text-align:center;" droppable="col" hflex="min" draggable="col"/>
            <listheader label="End Time" context="uuid(zb_pageHome_ZTableHeaderPopup_2)" style="text-align:center;" droppable="col" hflex="min" draggable="col"/>
            <listheader label="Level" context="uuid(zb_pageHome_ZTableHeaderPopup_2)" style="text-align:center;" droppable="col" hflex="min" draggable="col"/>
            <listheader label="Scope" context="uuid(zb_pageHome_ZTableHeaderPopup_2)" style="text-align:center;" droppable="col" hflex="min" draggable="col"/>
        </listhead>
    </listbox>
    
    <grid emptyMessage="no items to display" vflex="true">
    	<columns>
    		<column label="C1"></column>
    		<column label="C2"></column>
    		<column label="C3"></column>
    		<column label="C4"></column>
    		<column label="C5"></column>
    		<column label="C6"></column>
    	</columns>
    </grid>
    
    <grid emptyMessage="no items to display" vflex="true">
    	<columns>
    		<column label="C1"></column>
    	</columns>
    </grid>
</zk>

"""  
  runZTL(zscript,
    () => {
      val w = jq("@listbox").width();
      val iter = jq("td:contains(No items to display.)").iterator();
      while(iter.hasNext()) {
    	  val td = iter.next();
    	  verifyTrue("", td.width() == w && td.css("text-align").equals("center"));
      }
    })
    
  }
}