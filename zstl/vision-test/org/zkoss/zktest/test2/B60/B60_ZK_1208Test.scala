package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B60-ZK-1208.zul")
class B60_ZK_1208Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B60-ZK-1208.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Aug 29, 2012  9:22:30 AM, Created by jumperchen

Copyright (C) 2012 Potix Corporation. All Rights Reserved.

-->
<zk>
Please click the addRow button, and then you should be able to see the "test" label at the end of the list.(Chrome/Safari only)
  <zscript>
    void addRow(){
    Row row = new Row();
row.setStyle("background-color: #F7F7F7");
row.setParent(chatRows);
row.appendChild(new Label("test"));
Clients.scrollIntoView(row);
    }
  </zscript>
  <button label="Add Row" onClick="addRow();"/>
<grid height="150px" id="chatGrid" style="border:0px">
<columns>
<column width="13%" align="center"/>
<column/>
</columns>
<rows id="chatRows">
<row>row</row>
<row>row</row>
<row>row</row>
<row>row</row>
<row>row</row>
<row>row</row>
<row>row</row>
<row>row</row>
<row>row</row>
</rows>
</grid>
</zk>
"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button:eq(0)"))
      waitResponse()
      
      verifyImage()
    })
    
  }
}