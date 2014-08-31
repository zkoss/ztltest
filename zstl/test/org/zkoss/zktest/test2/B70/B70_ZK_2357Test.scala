package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2357.zul")
class B70_ZK_2357Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2357.zul

	Purpose:
		
	Description:
		
	History:
		Wed, AUG 06, 2014 14:22:23 AM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript><![CDATA[
	    //org.zkoss.lang.Library.setProperty("org.zkoss.theme.preferred", "atlantic");
	]]></zscript>
	<div>
		Hover and click on each button in this page should change the style and open a file dialog.
	</div>
	<textbox id="tbox"/>
	<hlayout>
    	<button upload="true" label="click me." onRightClick='tbox.setValue("1")'/>
	</hlayout>
	<div>
		<menubar>
			<menu label="file menu">
				<menupopup>
					<menuitem upload="true" label="click me." onRightClick='tbox.setValue("2")'/>
				</menupopup>
			</menu>
			<menuitem upload="true" label="click me." onRightClick='tbox.setValue("3")'/>
		</menubar>
	</div>
	<div>
	    <toolbar>
	    	<toolbarbutton upload="true" label="click me." onRightClick='tbox.setValue("4")'/>
	    </toolbar>
	</div>
</zk>

"""  
  runZTL(zscript,
    () => {
      val tbox = jq("$tbox");
      contextMenu(jq("@button").eq(0));
      waitResponse();
      verifyTrue("button should be triggered.", tbox.toWidget().get("value").equals("1"));
      clickAt(jq("@menu"), "1,1");
      waitResponse();
      contextMenu(jq("@menuitem").eq(0));
      waitResponse();
      verifyTrue("button should be triggered.", tbox.toWidget().get("value").equals("2"));
      contextMenu(jq("@menuitem").eq(1));
      waitResponse();
      verifyTrue("button should be triggered.", tbox.toWidget().get("value").equals("3"));
      contextMenu(jq("@toolbarbutton"));
      waitResponse();
      verifyTrue("button should be triggered.", tbox.toWidget().get("value").equals("4"));
    })
    
  }
}