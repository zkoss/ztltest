package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2341.zul")
class B70_ZK_2341Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2341.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jun 30, 2014  18:12:12 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
1. Click "page 2" button should see "this is page 2-1", not "this is page 2-2"
2. Click "page 3" button should see "this is page 3-1".
</label>
    <vlayout hflex="1" vflex="1">
        <cardlayout id="card" hflex="1" vflex="1">
            <cardlayout hflex="1" vflex="1" style="background-color:red" selectedIndex="0">
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 1-1" />
                </vbox>
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 1-2" />
                </vbox>
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 1-3" />
                </vbox>
            </cardlayout>
            <cardlayout hflex="1" vflex="1" style="background-color:yellow" selectedIndex="0">
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 2-1" />
                </vbox>
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 2-2" />
                </vbox>
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 2-3" />
                </vbox>
            </cardlayout>
            <cardlayout hflex="1" vflex="1" style="background-color:green" selectedIndex="0">
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 3-1" />
                </vbox>
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 3-2" />
                </vbox>
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 3-3" />
                </vbox>
            </cardlayout>
            <cardlayout hflex="1" vflex="1" style="background-color:orange" selectedIndex="0">
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 4-1" />
                </vbox>
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 4-2" />
                </vbox>
                <vbox width="300px" height="300px" align="center" pack="center" style="border:1px solid black;">
                    <label value="this is page 4-3" />
                </vbox>
            </cardlayout>
        </cardlayout>
        <hlayout>
            <button onClick="card.setSelectedIndex(0)">page 1</button>
            <button onClick="card.setSelectedIndex(1)">page 2</button>
            <button onClick="card.setSelectedIndex(2)">page 3</button>
            <button onClick="card.setSelectedIndex(3)">page 4</button>
        </hlayout>
    </vlayout>
</zk>

"""  
  runZTL(zscript,
    () => {
      val left = jq("@cardlayout").offsetLeft();
      
      //clickAt(jq("@button").eq(1), "1,1");
      click(jq("@button").eq(1));
      waitResponse();
      sleep(1000);
      verifyTolerant(jq("span:contains(this is page 2-1)").eval("closest('table').parent().offset().left").toInt, left, 10);
      
      click(jq("@button").eq(2));
      waitResponse();
      sleep(1000);
      verifyTolerant(jq("span:contains(this is page 3-1)").eval("closest('table').parent().offset().left").toInt, left, 10);
      
      click(jq("@button").eq(3));
      waitResponse();
      sleep(1000);
      verifyTolerant(jq("span:contains(this is page 4-1)").eval("closest('table').parent().offset().left").toInt, left, 10);
    })
    
  }
}