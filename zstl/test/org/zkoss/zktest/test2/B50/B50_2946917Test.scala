/* B50_2946917Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2946917Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<window id="main" title="Test of Server-side Validation">
					<html><![CDATA[
					<ul>
						<li>Click the textbox, does nothing, and then click outside of textbox.
						Then, "validate 1" shall be shown.</li>
						<li>Redo the previous step and no more message will be shown</li>
						<li>Click the textbox and type in something, and then click outside of textbox.
						Then, you shall see "validate 2" be shown</li>
					</ul>
					Why the first onblur always trigger validate?
					It is spec (since very old version), such that application can detect it
					if the user moves to a field that shall be filled something up.
					]]></html>
					<zscript>
					int cnt = 0;
					public class MyConstraint implements Constraint {
						public void validate(Component comp, Object value) {
							main.appendChild(new Label("validate "+ ++cnt));
						}
					}
					MyConstraint cst = new MyConstraint();
					</zscript>
					<textbox id="tbx" constraint="${cst}"/>
				</window>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val main = ztl$engine.$f("main")
    val tbx = ztl$engine.$f("tbx")
    runZTL(zscript, () => {
      for (i <- 0 until 3) {
        focus(tbx)
        blur(tbx)
        waitResponse()
        verifyEquals(1, jq(".z-label").length())
      }
      focus(tbx)
      typeKeys(tbx, "a")
      blur(tbx)
      waitResponse()
      verifyEquals(2, jq(".z-label").length())
    })
  }
}



