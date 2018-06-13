/* B50_2946498Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2946498Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<window title="My First Window" border="normal" width="400px"
				mode="highlighted" closable="true">
				    <zscript>
				        public void errorAll() {
							List wves = new ArrayList();
							wves.add(new WrongValueException(txb1, "error txb1"));
							wves.add(new WrongValueException(ltb, "error on ltb"));
							wves.add(new WrongValueException(txb2, "error txb2"));
							throw new WrongValuesException(wves.toArray(new WrongValueException[1]));							
						}
				    </zscript>
				    <separator spacing="40px" />
				    <vbox>
				        <textbox id="txb1" />
				        <listbox id="ltb" mold="select" />
				        <textbox id="txb2" />
				    </vbox>
				    <separator/>
				    <button id="x" label="Click me first, and than close the window via (X icon)" onClick="errorAll()"/>
				    You should see all of the popup windows with errors are closed.
				</window>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val txb1 = ztl$engine.$f("txb1")
    val ltb = ztl$engine.$f("ltb")
    val txb2 = ztl$engine.$f("txb2")
    val x = ztl$engine.$f("x")
    runZTL(zscript, () => {
      click(x)
      waitResponse()
      verifyEquals(3, jq(".z-errorbox").length())
      click(jq("@window.z-window-highlighted").toWidget().$n("close"))
      waitResponse()
      verifyEquals(0, jq(".z-errorbox").length())
      verifyFalse(jq(".z-errorbox").exists())
    })
  }
}



