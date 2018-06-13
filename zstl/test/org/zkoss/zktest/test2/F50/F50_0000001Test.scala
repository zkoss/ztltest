/* F50_0000001Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class F50_0000001Test extends ZTL4ScalaTestCase {
  @Test
  def testFocus() = {
    var zscript =
      """
		<zk>
			<window>
				<vbox>
					<label value="Case 1:" />
					<label value="	1. Click 'doModal', it will pop up a dialog. If the focus is on the 'hide' button of the dialog, it is correct." />
					<label value="	2. Click 'invalidate', the dialog will redraw. If the focus is still on the 'hide' button of the dialog, it is correct." />
					<label value="	3. Click 'hide'." />
				</vbox>
				<window id="w" title="Modal" border="normal" mode="highlighted"
					visible="false" width="200px" closable="true"
					action="show: slideDown; invalidate: slideDown; hide: slideUp">
					Test
					<button id="hideBtn" label="hide" onClick="w.visible = false" />
					<button id="invalidateBtn" label="invalidate" onClick="w.invalidate();" />
				</window>
				<button id="modalBtn" label="doModal" onClick="w.doModal()" />
				<separator bar="true" />
				<vbox>
					<label value="Case 2:" />
					<label value="	Click 'new', it will pop up a dialog. If the focus is on the textbox of the dialog, it is correct." />
				</vbox>
				<button id="newBtn" label="new">
					<attribute name="onClick">
					    Window w2 = new Window();
					    w2.setTitle("New");
					    w2.setMode("highlighted");
					    w2.setClosable(true);
					    w2.setBorder("normal");
					    w2.setWidth("200px");
					    Textbox tb = new Textbox();
					    tb.setId("myTxtbox");
					    w2.appendChild(tb);
					    w2.setAction("show: slideDown; hide: slideUp");
					    self.parent.appendChild(w2);
					</attribute>
				</button>
			</window>
		</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val w = ztl$engine.$f("w")
    val hideBtn = ztl$engine.$f("hideBtn")
    val invalidateBtn = ztl$engine.$f("invalidateBtn")
    val modalBtn = ztl$engine.$f("modalBtn")
    val newBtn = ztl$engine.$f("newBtn")
    val myTxtbox = ztl$engine.$f("myTxtbox")
    runZTL(zscript, () => {
      sleep(200)
      click(modalBtn)
      waitResponse(true)
      verifyTrue(jq("$hideBtn:focus").exists())
      click(invalidateBtn)
      waitResponse(true)
      verifyTrue(jq("$hideBtn:focus").exists())
      click(hideBtn)
      waitResponse(true)
      click(newBtn)
      waitResponse(true)
      click(jq(".z-window-highlighted").toWidget().$n("close"))
      waitResponse(true)
      verifyTrue(jq("$newBtn:focus").exists())
    })
  }
}



