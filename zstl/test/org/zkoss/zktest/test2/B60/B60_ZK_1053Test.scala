/* B60_ZK_1053Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Apr 23 12:34:17 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug ZK-1053
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-1053.zul,B,E,Selectbox,Chosenbox")
class B60_ZK_1053Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<div>Click on the selectbox component, you should see the msg become 'msg: Selectbox onFocus'</div>
				<div>Click on the blank outside, you should see the msg become 'msg: Selectbox onBlur'</div>
				<div>Click on the chosenbox component, you should see the msg become 'msg: Chosenbox onFocus'</div>
				<div>Click on the blank outside, you should see the msg become 'msg: Chosenbox onBlur'</div>
				
				<label id="msg" value="msg:" />
				<div></div>
				Selectbox:
				<selectbox id="sbx">
					<attribute name="onFocus">
						msg.setValue("msg: Selectbox onFocus");
					</attribute>
					<attribute name="onBlur">
						msg.setValue("msg: Selectbox onBlur");
					</attribute>
				</selectbox>
				<div></div>
				Chosenbox
				<chosenbox id="cbx">
					<attribute name="onFocus">
						msg.setValue("msg: Chosenbox onFocus");
					</attribute>
					<attribute name="onBlur">
						msg.setValue("msg: Chosenbox onBlur");
					</attribute>
				</chosenbox>
			</zk>

    """
    runZTL(zscript,
      () => {
        var msg: Widget = engine.$f("msg");
        var sbx: Widget = engine.$f("sbx");
        var cbx: Widget = engine.$f("cbx");

        focus(sbx);
        waitResponse();
        verifyContains("You should see the msg become 'msg: Selectbox onFocus'",
          msg.$n().get("innerHTML"), "msg: Selectbox onFocus")
        blur(sbx);
        waitResponse();
        verifyContains("You should see the msg become 'msg: Selectbox onBlur'",
          msg.$n().get("innerHTML"), "msg: Selectbox onBlur")

        focus(cbx.$n("inp"));
        waitResponse();
        verifyContains("You should see the msg become 'msg: Chosenbox onFocus'",
          msg.$n().get("innerHTML"), "msg: Chosenbox onFocus")
        blur(cbx.$n("inp"));
        waitResponse();
        verifyContains("You should see the msg become 'msg: Chosenbox onBlur'",
          msg.$n().get("innerHTML"), "msg: Chosenbox onBlur")
      }
    );
  }
}