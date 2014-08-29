package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2356.zul")
class B70_ZK_2356Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2356.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Jul 16, 2014  3:09:33 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<div>
		if you see the menupopup don't have the same height to the top when clicking on the three menus, that's a bug. 
	</div>
	<menubar>
		<menu label="menu1" >
			<menupopup onOpen="org.zkoss.lang.Threads.sleep(500);">
				<menuitem label="menu11"></menuitem>
				<menuitem label="menu12"></menuitem>
				<menuitem label="menu13"></menuitem>
				<menuitem label="menu14"></menuitem>
			</menupopup>
		</menu>
		<menu label="menu2">
			<menupopup onOpen="">
				<menuitem label="menu21"></menuitem>
				<menuitem label="menu22"></menuitem>
				<menuitem label="menu23"></menuitem>
				<menuitem label="menu24"></menuitem>
			</menupopup>
		</menu>
		<menu label="menu3">
			<menupopup>
				<menuitem label="menu31"></menuitem>
				<menuitem label="menu32"></menuitem>
				<menuitem label="menu33"></menuitem>
				<menuitem label="menu34"></menuitem>
			</menupopup>
		</menu>
	</menubar>
</zk>


"""  
  runZTL(zscript,
    () => {
      val menus = jq("@menu");
      var top = -1;
      clickAt(menus.first(), "1,1");
      waitResponse();
      top = jq("@menupopup").first().scrollTop();
      clickAt(menus.first(), "1,1");
      waitResponse();
      
      clickAt(menus.eq(1), "1,1");
      waitResponse();
      verifyTrue("menupopups should have same height of top.", jq("@menupopup").eq(1).scrollTop() == top);
      clickAt(menus.eq(1), "1,1");
      waitResponse();
      
      clickAt(menus.eq(2), "1,1");
      waitResponse();
      verifyTrue("menupopups should have same height of top.", jq("@menupopup").eq(2).scrollTop() == top);
    })
    
  }
}