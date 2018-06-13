/* B30_1510218Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1510218Test extends ZTL4ScalaTestCase {
  @Test
  def testPopup() = {
    var zscript =
      """
			<zk>
				<window id="win" title="root" border="normal">
					<zscript>
					void popup(){
						Window w=new Window();
						w.setId("inner1");
						w.setTitle("popup");
						w.setBorder("normal");
						w.setHeight("200px");
						w.setWidth("200px");
						w.setSizable(true);
						w.setStyle("overflow:visible;");
						w.setPage(page);
						w.appendChild(btn1);
						w.doPopup();
					}
					void overlapped(){
						Window w=new Window();
						w.setId("inner2");
						w.setTitle("oeverlapped");
						w.setSizable(true);
						w.setStyle("overflow:visible;");
						w.setHeight("200px");
						w.setWidth("200px");
						w.setBorder("normal");
						w.setPage(page);
						w.appendChild(btn2);
						w.doOverlapped();
					}
					</zscript>
					<button id="popup" label="popup" onClick="popup()"/>
					<button id="overlapped" label="overlapped" onClick="overlapped()"/>
					<button id="btn1" label="Btn1" onClick='alert("btn1 OK")'/>
					<button id="btn2" label="Btn2" onClick='alert("btn2 OK")'/>
				</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val popup = ztl$engine.$f("popup")
    val overlapped = ztl$engine.$f("overlapped")
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val inner1 = ztl$engine.$f("inner1")
    val inner2 = ztl$engine.$f("inner2")
    runZTL(zscript, () => {
      // Test Popup
      click(popup)
      waitResponse()
      clickAt(inner1, "5,5")
      verifyTrue(jq(inner1).isVisible())
      click(btn1)
      waitResponse()
      verifyEquals("btn1 OK", jq(".z-messagebox > span").text())
      //here is clicking the alert
      //modify for compatiable event-thread enable/disable
      click(jq(".z-window-highlighted").toWidget().$n("close"))
      verifyFalse(isVisible(inner1))
      waitResponse()
      // Test Overlapped
      click(overlapped)
      waitResponse()
      clickAt(inner2, "5,5")
      verifyTrue(jq(inner2).isVisible())
      click(btn2)
      waitResponse()
      verifyEquals("btn2 OK", jq(".z-messagebox > span").text())
      //here is clicking the alert
      //modify for compatiable event-thread enable/disable
      click(jq(".z-window-highlighted").toWidget().$n("close"))
      verifyTrue(jq(inner2).isVisible())
    })
  }
}



