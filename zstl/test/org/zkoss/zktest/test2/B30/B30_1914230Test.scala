/* B30_1914230Test.java

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


class B30_1914230Test extends ZTL4ScalaTestCase {
  @Test
  def testSession() = {
    var zscript =
      """
		<window title="Memory Leak Test">
			<vbox>
				<html><![CDATA[
				<ol>
					<li>Input invalid value in the combobox, e.g., xxx.</li>
					<li>Press TAB to change focus.</li>
					<li>An erorr massage is shown up, but no onSelect is fired.</li>
				</ol>
				In other words, if the client detects the error, it shall not notify
				the server (with onSelect).
				]]></html>
				
				<combobox id="cb" constraint="strict"
					onSelect='msg1.value = "onSelect is fired, " + (self.selectedItem != null ? self.selectedItem.label:"n/a")'
					onChange='msg2.value = "onChange is fired, " + self.value'>
					<comboitem label="aaa" value="1" />
					<comboitem label="bbb" value="2" />
				</combobox>
				<label id="msg1"/>
				<label id="msg2"/>
				<button label="reset message" onClick='msg1.value = msg2.value = ""'/>
				<button label="reset all" onClick='cb.value = msg1.value = msg2.value = ""' />
			</vbox>
		</window>
		 """
    val ztl$engine = engine()
    val cb = ztl$engine.$f("cb")
    val msg1 = ztl$engine.$f("msg1")
    val msg2 = ztl$engine.$f("msg2")
    runZTL(zscript, () => {
      focus(cb.$n("real"))
      typeKeys(cb.$n("real"), "xxx")
      waitResponse()
      verifyEquals("", jq(msg1).text())
      verifyEquals("", jq(msg2).text())
    })
  }
}



