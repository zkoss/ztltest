/* B50_ZK_488Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_ZK_488Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<html><![CDATA[
				<ol>
				<li>Drag listitem from left to right</li>
				<li>Drag listitem from right to left</li>
				<li>The bug is fixed if do above without any problem.</li>
				</ol>
				]]></html>
				<hbox>
					<listbox id="lb1" droppable="true" width="100px" height="150px">
						<attribute name="onDrop">
							event.getDragged().setParent(self);
							tb.setValue(event.getDragged().getId() + " in " + self.getId());
						</attribute>
						<listitem id="li1" draggable="true">
							<listcell label="list cell 1">
								<div>div</div>
							</listcell>
						</listitem>
					</listbox>
					<separator spacing="20px" />
					<listbox id="lb2" droppable="true" width="100px" height="150px">
						<attribute name="onDrop">
							event.getDragged().setParent(self);
							tb.setValue(event.getDragged().getId() + " in " + self.getId());
						</attribute>
						<listitem id="li2" draggable="true">
							<listcell label="list cell 2">
								<div>div</div>
							</listcell>
						</listitem>
					</listbox>
				</hbox>
				<textbox id="tb" />
			</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lb1 = ztl$engine.$f("lb1")
    val li1 = ztl$engine.$f("li1")
    val lb2 = ztl$engine.$f("lb2")
    val li2 = ztl$engine.$f("li2")
    val tb = ztl$engine.$f("tb")
    runZTL(zscript, () => {
      mouseDownAt(li1, "5,5")
      mouseMoveAt(lb2, "25,25")
      mouseUp(lb2)
      waitResponse()
      verifyEquals("li1 in lb2", tb.$n().get("value"))
      mouseDownAt(li2, "5,5")
      mouseMoveAt(lb1, "25,25")
      mouseUp(lb1)
      waitResponse()
      verifyEquals("li2 in lb1", tb.$n().get("value"))
    })
  }
}



