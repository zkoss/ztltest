/* B50_ZK_462Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_ZK_462Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
			<html><![CDATA[
			<ol>
			<li>Click 'reset label' button, the label should become 'nothing happened'.</li>
			<li>Click each checkbox twice, the label should not be changed.</li>
			<li>Maximize/Restore window by click the maximize/restore icon on the window, the label should become 'oops, test win maximized'.</li>
			</ol>
			]]></html>
				<div width="800px" height="500px">
					<label id="lb" value="nothing happened" />
					<button id="btn1" label="reset label">
						<attribute name="onClick">
							lb.setValue("nothing happened");
						</attribute>
					</button>
					<checkbox id="cb1" label="maximizable" checked="true" onCheck="win.setMaximizable(self.checked);" />
					<checkbox id="cb2" label="minimizable" onCheck="win.setMinimizable(self.checked);" />
					<checkbox id="cb3" label="closable" onCheck="win.setClosable(self.checked);" />
					<checkbox id="cb4" label="border" checked="true">
						 <attribute name="onCheck">
						 	if (self.checked)
						 		win.setBorder("normal");
						 	else
						 		win.setBorder("none");
						 </attribute>
					</checkbox>
					<window id="win" title="test win" maximizable="true" maximized="true" border="normal">
						<attribute name="onMaximize">
							lb.setValue("oops, test win maximized!");
						</attribute>
					</window>
				</div>
			</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lb = ztl$engine.$f("lb")
    val btn1 = ztl$engine.$f("btn1")
    val cb1 = ztl$engine.$f("cb1")
    val cb2 = ztl$engine.$f("cb2")
    val cb3 = ztl$engine.$f("cb3")
    val cb4 = ztl$engine.$f("cb4")
    val win = ztl$engine.$f("win")
    runZTL(zscript, () => {
      click(btn1)
      waitResponse()
      verifyTrue("nothing happened".equals(lb.$n().get("innerHTML")))
      click(cb1.$n("real"))
      waitResponse()
      click(cb1.$n("real"))
      waitResponse()
      click(cb2.$n("real"))
      waitResponse()
      click(cb2.$n("real"))
      waitResponse()
      click(cb3.$n("real"))
      waitResponse()
      click(cb3.$n("real"))
      waitResponse()
      click(cb4.$n("real"))
      waitResponse()
      click(cb4.$n("real"))
      waitResponse()
      verifyTrue("nothing happened".equals(lb.$n().get("innerHTML")))
      click(win.$n("max"))
      waitResponse()
      verifyTrue("oops, test win maximized!".equals(lb.$n().get("innerHTML")))
      click(btn1)
      waitResponse()
      verifyTrue("nothing happened".equals(lb.$n().get("innerHTML")))
      click(win.$n("max"))
      waitResponse()
      verifyTrue("oops, test win maximized!".equals(lb.$n().get("innerHTML")))
    })
  }
}



