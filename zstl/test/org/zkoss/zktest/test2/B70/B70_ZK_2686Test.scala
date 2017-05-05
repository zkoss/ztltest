package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2686.zul")
class B70_ZK_2686Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2784.zul

  Purpose:

  Description:

  History:
    Fri Jun 12 14:50:20 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
  <custom-attributes org.zkoss.zul.nativebar="false"/>
  <borderlayout height="400px" width="600px">
    <west size="150px">
    </west>
    <center autoscroll="true" id="center">
        <grid id="grid">
          <rows>
            <row>
              <cell>
                <div id="click1" onClick="inc1.setVisible(!inc1.isVisible())">div toggle tree on click</div>
                <div id="inc1" visible="false" height="300px" style="background-color: red"/>
              </cell>
            </row>
            <row>
              <cell>
                <div id="click2" onClick="inc2.setVisible(!inc2.isVisible())">div toggle tree on click</div>
                <div id="inc2" visible="false" height="300px" style="background-color: green"/>
              </cell>
            </row>
            <row>
              <cell>
                <div onClick="inc3.setVisible(!inc3.isVisible())">div toggle tree on click</div>
                <div id="inc3" visible="false" height="300px" style="background-color: red"/>
              </cell>
            </row>
          </rows>
        </grid>
    </center>
    <east size="150px">
    </east>
  </borderlayout>
</zk>
"""  
  runZTL(zscript,
    () => {
      windowResizeTo(1024,768)
      waitResponse()
      click(jq("$click1"))
      waitResponse()
      click(jq("$click2"))
      waitResponse()
      windowResizeTo(1024,760)
      waitResponse()
      verifyTrue(jq(".z-scrollbar-vertical-embed:eq(0)").exists())
      verifyFalse(jq(".z-scrollbar-vertical-embed:eq(1)").exists())
    })
  }
}