/* B60_ZK_622Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Mar 29 12:18:42 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-622
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-622.zul,B,E,Radio,JQuery,Selector")
class B60_ZK_622Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<window id="w" mode="modal" xmlns:n="http://www.zkoss.org/2005/zk/native" width="500px">
				<n:p>Please click the "female" radio, and then click the "show" button, and then you should see that only "female" is checked and the label "undefined" is shown</n:p>
				<radiogroup id="radiochoice">
					<radio id="male1" label="male" checked="true" />
					<radio id="female" label="female" />
				</radiogroup>
				 <button id="btn" label="show" xmlns:w="client" w:onClick='this.$f("log").setValue(jq("$male1 input").attr("checked")+"");'/>
				 <label id="log"/>
			</window>

    """
    runZTL(zscript,
      () => {
        var male1: Widget = engine.$f("male1");
        var female: Widget = engine.$f("female");
        var btn: Widget = engine.$f("btn");
        var log: Widget = engine.$f("log");

        // skip ie6/7, browser issue
        click(female.$n("real"));
        click(btn);
        waitResponse();
        verifyEquals("mail should not be checked", "false",
          male1.$n("real").attr("checked"))
        verifyContains("label 'undefined' is shown",
          log.$n().attr("innerHTML"), "undefined")
      }
    );
  }
}