package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2328.zul")
class B70_ZK_2328Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2328.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jun 16, 2014  4:55:12 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
You should not see the browser scroll to the end of the browser. (if yes, that's a bug)
	<div height="900px"></div>
	<vlayout>
		<listbox checkmark="true" id="listbox">
			<listhead>
				<listheader label="col 1" />
				<listheader label="col 2" />
			</listhead>
			<listgroup label="Listgroup"/>
			<listitem>
				<listcell label="row 1 cell 1" />
				<listcell label="row 1 cell 2" />
			</listitem>
			<listitem selected="true">
				<listcell label="Selected row 2 cell 1" />
				<listcell label="Selected row 2 cell 2" />
			</listitem>
			<listgroupfoot label="Listgroupfoot"/>
		</listbox>
		<button label="Multiple Selection" onClick="listbox.setMultiple(!listbox.isMultiple())" />
	</vlayout>
</zk>

"""  
  runZTL(zscript,
    () => {
      verifyTrue("scrolling shouldn't to be changed.", jq("body").scrollTop() == 0);
    })
    
  }
}