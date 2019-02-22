/* F60_ZK_83Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 21 15:57:13 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{JQuery, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-83
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-83.zul,F60,A,E,Messagebox")
class F60_ZK_83Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
				<zscript>
				import org.zkoss.zktest.test2.ZK83Utils;
    			session.setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, new Locale("en_US"));
				</zscript>
				<vlayout>
					<hlayout>
					<button id="btnOne" label="Say Yes" onClick='Messagebox.show("Say Yes", "Yes", Messagebox.YES, Messagebox.INFORMATION)'/>
					shows a message box with a button called Yes
					</hlayout>
					<hlayout>
					<button id="btnTwo" label="Hi, OK" onClick="ZK83Utils.test0(self)"/>
					shows a message box with a button called OK
					</hlayout>
					<hlayout>
					<button id="btnThree" label="Hi, Cancel and OK" onClick="ZK83Utils.test1(self)"/>
					shows a message box with two buttons: Cancel and OK
					</hlayout>
					<hlayout>
					<button id="btnFour" label="Hi, Cancel, OK and No" onClick="ZK83Utils.test2(self)"/>
					shows a message box with two buttons: Cancel, OK and No. And, the focus is OK.
					</hlayout>
				</vlayout>
			</zk>

    """

    runZTL(zscript,
      () => {
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");
        var btnThree: Widget = engine.$f("btnThree");
        var btnFour: Widget = engine.$f("btnFour");
        def clickAndCheck(wgt: Widget, toCheck: Array[String], toClick: Array[String]) {
          click(wgt);
          waitResponse();
          var messagebox = jq(".z-messagebox-window");
          var checkJq =  messagebox.find(".z-button:contains(" + toCheck(0) + ")")
          var oLeft = checkJq.offsetLeft()
          verifyTrue("Button " + toCheck(0) + " exists", checkJq.exists())
          verifyTrue("Button should in correct order", checkJq.offsetLeft() > 0)
          for (i <- 1 until toCheck.length) {
            checkJq = messagebox.find(".z-button:contains(" + toCheck(i) + ")")
            verifyTrue("Button " + toCheck(i) + " exists", checkJq.exists())
            verifyTrue("Button should in correct order", checkJq.offsetLeft() > oLeft)
            oLeft = checkJq.offsetLeft()
          }
          for (j <- 0 until toClick.length) {
            click(messagebox.find(".z-button:contains(" + toClick(j) + ")"));
            waitResponse();
          }
        }

        clickAndCheck(btnOne, Array("Yes"), Array("Yes"));
        clickAndCheck(btnTwo, Array("OK"), Array("OK", "OK"));
        clickAndCheck(btnThree, Array("Cancel", "OK"), Array("OK", "OK"));
        clickAndCheck(btnFour, Array("Cancel", "OK", "No"), Array("OK", "OK"));
      }
    );
  }
}