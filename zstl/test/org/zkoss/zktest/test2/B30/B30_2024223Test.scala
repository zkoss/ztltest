/* B30_2024223Test.java

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


class B30_2024223Test extends ZTL4ScalaTestCase {
  @Test
  def testBinding() = {
    var zscript =
      """
			<window>
			<html><![CDATA[
			<p>
			1. You shall see a button "Click Me!".<br/>
			2. Click the button, and you shall see an error window popup: "arg0/root has to be String, Component, or Page: null".<br/>
			3. Done.<br/>
			</p>
			]]></html>
			<button id="myBtn" label="Click Me!">
				<attribute name="onClick"><![CDATA[
					final Window zulUI= (Window) Executions.createComponents(
							"test2/B30_2024223_1.zul", null, null);
					try 
					{
						zulUI.doModal();
					} 
					catch (SuspendNotAllowedException e) 
					{
						return;
					} 
					catch (InterruptedException e) 
					{
						return;
					}
				]]></attribute>
			</button>
			</window>
		"""
    val ztl$engine = engine()
    val myBtn = ztl$engine.$f("myBtn")
    runZTL(zscript, () => {
      click(myBtn)
      waitResponse()
      verifyTrue(jq(".z-window-modal").exists())
      verifyEquals("arg0/root has to be String, Component, or Page: null", jq(".z-window-modal .z-label").text())
    })
  }
}



