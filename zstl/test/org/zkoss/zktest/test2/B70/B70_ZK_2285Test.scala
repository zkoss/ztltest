package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKTestCase
import org.openqa.selenium.interactions.Actions

@Tags(tags = "B70-ZK-2285.zul")
class B70_ZK_2285Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2285.zul

	Purpose:
		
	Description:
		
	History:
		Wed, May 07, 2014  4:39:18 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
1. Try using "shift" and "arrow" keys to select multiple values.
In IE browsers, after two items were selected, the "two-item" selection shifted to the next two when pressing "down" arrow key.
The selection should expand to include more items.(if not, that's a bug)
2. Click the button of "toggle test8 selection", and the button should work as expected.
</label>
<listbox multiple="true" mold="select">
	<listitem label="test1" />
	<listitem label="test2" />
	<listitem label="test3" />
	<listitem label="test4" />
	<listitem label="test5" />
	<listitem label="test6" />
	<listitem label="test7" />
	<listitem id="c" label="test8" />
	<listitem label="test9" />
</listbox>
<button label="toggle test8 selection" onClick='c.selected = !c.selected'/>
</zk>
"""  
  runZTL(zscript,
    () => {
      // unsupport opera and safari
      val select = jq("@select");
      sendKeys(select, Keys.ARROW_DOWN + "");
      waitResponse();
      sendKeys(select, Keys.SHIFT + "" + Keys.ARROW_DOWN);
      waitResponse();
      sendKeys(select, Keys.SHIFT + "" + Keys.ARROW_DOWN);
      waitResponse();
      
      click(jq("@button"));
      waitResponse();
      
      verifyTrue("4 items in listbox should be selected.", select.toWidget().eval("_selItems.length") == "4");
    })
    
  }
}