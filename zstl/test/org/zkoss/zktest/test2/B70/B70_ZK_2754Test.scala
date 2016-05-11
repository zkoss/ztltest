package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2754.zul")
class B70_ZK_2754Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """
      <?xml version="1.0" encoding="UTF-8"?>

      <!--
      B70-ZK-2754.zul

      	Purpose:

      	Description:

      	History:
      		Tue, Jun 9, 2015  16:00:29 PM, Created by Jameschu

      Copyright (C)  Potix Corporation. All Rights Reserved.

      -->
      <zk>
      	<label multiline="true">
      		1. click every button.You should see all button work.
      	</label>
      	<div apply="org.zkoss.zktest.test2.B70_ZK_2754_Composer">
      	    <button id="publish1">publish to queue 1</button>
      	    <button id="publish2">publish to queue 2</button>

      	    <iframe src="/test2/B70-ZK-2754-1.zul"/>
      	    <label id="label1"/>
      	    <label id="label2"/>
      	</div>
      </zk>
  """
  runZTL(zscript,
    () => {
      val msg_q1 = "[to queue1]"
      val msg_q2 = "[to queue2]"
      click(jq(".z-div .z-button:eq(0)"))
      waitResponse()
      verifyEquals(msg_q1, jq(".z-label:eq(1)").text().trim)
      click(jq(".z-div .z-button:eq(1)"))
      waitResponse()
      verifyEquals(msg_q2, jq(".z-label:eq(2)").text().trim)
      val jqScript = """
          var btns = $("iframe").contents().find('button');
        """
      executeScript(jqScript + "btns[0].click();")
      waitResponse()
      verifyEquals(msg_q1 + msg_q1, jq(".z-label:eq(1)").text().trim)
      executeScript(jqScript + "btns[1].click();")
      waitResponse()
      verifyEquals(msg_q2 + msg_q2, jq(".z-label:eq(2)").text().trim)
      executeScript(jqScript + "btns[2].click();")
      waitResponse()
      verifyEquals(msg_q1 + msg_q1 + msg_q1, jq(".z-label:eq(1)").text().trim)
      verifyEquals(msg_q2 + msg_q2 + msg_q2, jq(".z-label:eq(2)").text().trim)
    })
  }
}