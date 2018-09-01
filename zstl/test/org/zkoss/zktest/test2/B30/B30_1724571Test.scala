/* B30_1724571Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1724571Test extends ZTL4ScalaTestCase {
  @Test
  def testConstraint() = {
    var zscript =
      """
			<window title="My First Window" border="normal" width="800px">
				<vbox>1.Type something in textbox.</vbox>
				<vbox>2.click "validate by set", you should see an error message box appear:Fail validation!!</vbox>
				<vbox>3.click "Throw exception directly", you should see "Failed!!!" message box.</vbox>
				<vbox>4.click "Show Error Message", then you should see a error message window. close it.</vbox>
				<vbox>5.click on :"clean up" you should see no errors anymore.</vbox>
				<vbox>6.click on "validate by set" and then click "cleanup" then you should see errors being cleaned up.</vbox>
				<vbox>7.click on "validate by set" again, then click "retrieve and cleanup", you should see error message cleaned up and displayed at bottom of this window.</vbox>
				<vbox>8.click on "cleanup by update" and you should see errors cleaned up and textbox appear 'ab'.</vbox>
				
				<vbox>
					<textbox id="box" constraint="no empty:Fail validation!!" />
					<button id="btn1" onClick="box.getValue()" label="Validate by get (it shall fail if error is not cleaned up)"/>
					<button id="btn2" onClick="box.setValue(&quot;&quot;)" label="Validate by set (it shall fail)"/>
					<button id="btn3" onClick="fail()" label="Throw exception directly"/>
					<button id="btn4" onClick="alert(box.getErrorMessage())" label="Show Error Message"/>
					<button id="btn5" onClick="cleanup()" label="Cleanup"/>
					<button id="btn6" onClick="cleanup2()" label="Retrieve and Cleanup"/>
					<button id="btn7" onClick="box.setValue(&quot;ab&quot;)" label='Cleanup by update (textbox will appear "ab")'/>
					<label id="info"/>
				</vbox>
				<zscript>
					public void cleanup() {
						box.clearErrorMessage();
					}
					public void cleanup2() {
						info.value = box.getErrorMessage();
						cleanup();
					}
					public void fail() {
						throw new WrongValueException(box, "Failed!!!");
					}
				</zscript>
			</window>
		"""
    val ztl$engine = engine()
    val box = ztl$engine.$f("box")
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val btn3 = ztl$engine.$f("btn3")
    val btn4 = ztl$engine.$f("btn4")
    val btn5 = ztl$engine.$f("btn5")
    val btn6 = ztl$engine.$f("btn6")
    val btn7 = ztl$engine.$f("btn7")
    val info = ztl$engine.$f("info")
    runZTL(zscript, () => {
      var jq$jq = jq(".z-errorbox-content")
      typeKeys(box, "test");
      verifyFalse(jq$jq.exists())
      click(btn1);
      waitResponse()
      verifyFalse(jq$jq.exists());
      click(btn2)
      waitResponse();
      verifyTrue(jq$jq.exists())
      click(btn1);
      waitResponse()
      verifyTrue(jq$jq.exists());
      verifyEquals("Fail validation!!", jq$jq.html())
      click(btn3);
      waitResponse()
      verifyEquals("Failed!!!", jq$jq.html());
      click(btn4)
      waitResponse();
      verifyEquals("Failed!!!", jq("@window .z-messagebox .z-label").html())
      //for event thread compatible
      click(jq("@window[mode=\"modal\"] @button,@window[mode=\"highlighted\"] @button"))
      waitResponse();
      click(btn5)
      waitResponse();
      //for event thread compatible
      verifyFalse(jq("@window[mode=\"modal\"],@window[mode=\"highlighted\"]").exists());
      verifyFalse(jq$jq.exists())
      click(btn2);
      waitResponse()
      verifyTrue(jq$jq.exists());
      click(btn5)
      waitResponse();
      verifyFalse(jq$jq.exists())
      click(btn2);
      waitResponse()
      verifyTrue(jq$jq.exists());
      verifyEquals("", jq(info).html())
      click(btn6);
      waitResponse()
      verifyFalse(jq$jq.exists());
      verifyEquals("Fail validation!!", jq(info).html())
      click(btn7);
      waitResponse()
      verifyEquals("ab", jq(box).`val`());
    })
  }
}



