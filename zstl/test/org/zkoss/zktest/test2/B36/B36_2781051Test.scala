/* B36_2781051Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2781051Test extends ZTL4ScalaTestCase {
  @Test
  def testUI() = {
    var zscript =
      """
			<window id="main">
				After clicking 
				<button label="test">
					<attribute name="onClick">
				Object oldself = self;
				sub.doModal();
				new Label(""+self.equals(oldself)).setParent(main);
					</attribute>
				</button>, you shall see a modal window.
				Then, close the modal window by clicking closee, and
				you shall see "true" shown below
				<separator/>
			
				<window id="sub" title="Correct" visible="false" border="normal" width="200px">
					<button label="show title" onClick="l.value = self.parent.title"/>
					<button label="close" onClick="self.parent.setVisible(false)"/>
					<separator/>
					<label id="l"/>
				</window>
			</window>
		"""
    val ztl$engine = engine()
    val main = ztl$engine.$f("main")
    val sub = ztl$engine.$f("sub")
    val l = ztl$engine.$f("l")
    runZTL(zscript, () => {
      click(jq("@button[label=\"test\"]"))
      waitResponse()
      click(jq("@button[label=\"close\"]"))
      waitResponse()
      verifyEquals("true", jq("$main").find("@label:last").html())
    })
  }
}



