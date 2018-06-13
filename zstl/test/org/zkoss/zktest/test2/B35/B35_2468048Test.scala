/* B35_2468048Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2468048Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
				<zk>
				<html><![CDATA[  
				<ol>
				<li>You shall see three windows: A window, B window, and C window.</li>
				<li>C window is inside A window</li>
				<li>Press 'show variable x' button inside C window. You shall see popup "A".</li>
				<li>Press 'Move C window with div wrapper from A to B' button.</li>
				<li>You shall see C window is moved to be inside B window.</li>
				<li>Now press 'show variable x' button inside C window again. You shall see popup "B".</li>
				<li>Done</li> 
				</ol>
				]]></html>
				
				<window id="levelA" title="A window" width="500px" border="normal">
				 <custom-attributes x="A"/>
				 <div id="levelC_wrapper">
				 Following is C Window :
				  <window id="levelC" title="C window" width="400px" border="normal">
				   <button id="btn" label="show variable x" onClick='alert(self.getAttribute("x", true))'/>
				  </window>
				 </div>
				</window>
				
				<space spacing="50px" bar="true"/>
				
				<window id="levelB" title="B window" width="500px" border="normal">
				 <variables x="B"/>
				</window>
				
				<space spacing="50px" bar="true"/>
				
				<div>
				<button label="Move C window with div wrapper from A to B">
				 <attribute name="onClick">
				  Component c = Path.getComponent("/levelA/levelC_wrapper");
				   c.setParent(levelB);
				  </attribute>
				</button>
				</div>
				
				</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val levelA = ztl$engine.$f("levelA")
    val levelC_wrapper = ztl$engine.$f("levelC_wrapper")
    val levelC = ztl$engine.$f("levelC")
    val btn = ztl$engine.$f("btn")
    val levelB = ztl$engine.$f("levelB")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyEquals("A", jq(".z-messagebox > span.z-label:eq(0)").text())
      click(jq(".z-messagebox-window @button"))
      waitResponse()
      click(jq("@button.z-button:eq(1)"))
      waitResponse()
      click(btn)
      waitResponse()
      verifyEquals("B", jq(".z-messagebox > span.z-label:eq(0)").text())
    })
  }
}



