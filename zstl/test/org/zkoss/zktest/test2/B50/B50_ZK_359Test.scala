/* B50_ZK_359Test.java

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


class B50_ZK_359Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<window title="Test" mode="modal" border="normal" width="80%">
				<html><![CDATA[
				<ol>
				<li>Check the first listbox. No item shall be selected (i.e., it shall be empty).</li>
				<li>Click embed and check the first listbox. No item shall be selected.</li>
				<li>Click modal and check again.</li>
				<li>Click the drop down of the bandbox. It will slide down and the listbox shown shall has no item being selected.</li>
				</ol>
				]]></html>
			
				<listbox id="lb1" rows="1" mold="select" w:onSelect="zk.log(this)" xmlns:w="client">
				<listitem label="Test"/>
				</listbox>
				<button id="btn1" label="embed" onClick="self.parent.doEmbedded()"/>
				<button id="btn2" label="modal" onClick="self.parent.doModal()"/>
				<bandbox id="bb">
					<bandpopup>
					<listbox id="lb2" rows="1" mold="select" w:onSelect="zk.log(this)" xmlns:w="client">
					<listitem label="Test"/>
					</listbox>
					</bandpopup>
				</bandbox>
			</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lb1 = ztl$engine.$f("lb1")
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val bb = ztl$engine.$f("bb")
    val lb2 = ztl$engine.$f("lb2")
    runZTL(zscript, () => {
      verifyTrue("".equals(lb1.$n().get("value")))
      click(btn1)
      waitResponse()
      verifyTrue("".equals(lb1.$n().get("value")))
      click(btn2)
      waitResponse()
      verifyTrue("".equals(lb1.$n().get("value")))
      click(bb.$n("btn"))
      waitResponse()
      verifyTrue("".equals(lb2.$n().get("value")))
    })
  }
}



