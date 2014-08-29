package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2358.zul")
class B70_ZK_2358Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2358.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Jul 16, 2014  6:09:06 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<style>
		.z-listcell{ border: 1px solid black;}
	
	</style>
	<label multiline="true">
	1. Scroll to right-most position
	2. Column borders shouldn't become mis-aligned to listbox header's border:
	</label>
		<custom-attributes org.zkoss.zul.nativebar="true"/>
<!-- 		<listbox id="listbox" hflex="min" rows="3" > -->
		<listbox id="listbox" width="100%" rows="3" >
			<listhead>
				<listheader width="100px">1111</listheader>
				<listheader width="100px">2222</listheader>
				<listheader width="100px">3333</listheader>
				<listheader width="300px">4444</listheader>
				<listheader width="300px">555</listheader>
				<listheader width="100px">1111</listheader>
				<listheader width="100px">2222</listheader>
				<listheader width="100px">3333</listheader>
				<listheader width="300px">4444</listheader>
				<listheader width="300px">555</listheader>
				<listheader width="100px">1111</listheader>
				<listheader width="100px">2222</listheader>
				<listheader width="100px">3333</listheader>
				<listheader width="300px">4444</listheader>
				<listheader width="300px">555</listheader>				
			</listhead>

			<listitem >
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />								
			</listitem>
			<listitem >
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />				
			</listitem>
			<listitem >
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />				
			</listitem>
			<listitem >
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />				
			</listitem>						
		</listbox>
</zk>

"""  
  runZTL(zscript,
    () => {
      val cell = jq("@listitem").first().find("@listcell").last();
      val header = jq("@listheader").last();
      
      verifyTrue("Column borders shouldn't to be mis-aligned to listbox header's border.", cell.offsetLeft() == header.offsetLeft());
    })
    
  }
}