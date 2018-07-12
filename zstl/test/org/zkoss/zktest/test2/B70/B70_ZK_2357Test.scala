package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2357.zul")
class B70_ZK_2357Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

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
        verifyEquals("button should be triggered.", "1", tbox.toWidget().attr("value"));
        click(jq("@menu"));
        waitResponse();
        contextMenu(jq("@menuitem").eq(0));
        waitResponse();
        verifyEquals("button should be triggered.", "2", tbox.toWidget().attr("value"))
        contextMenu(jq("@menuitem").eq(1));
        waitResponse();
        verifyEquals("button should be triggered.", "3", tbox.toWidget().attr("value"))
        contextMenu(jq("@toolbarbutton"));
        waitResponse();
        verifyEquals("button should be triggered.", "4", tbox.toWidget().attr("value"))
      })

  }
}