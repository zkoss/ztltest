/* B30_1877702Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1877702Test extends ZTL4ScalaTestCase {
  @Test
  def testOnSelect() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<vbox>
					Please select a comboitem, and then press the reset button, and then re-select the previous comboitem, the onSelect event should be fired.
					<combobox id="cb1" constraint="strict"
						onSelect='msg.value = "onSelect is fired, " + self.selectedItem.label'>
						<comboitem label="aaa" value="1" />
						<comboitem label="bbb" value="2" />
					</combobox>
					<label id="msg"/>
					<button id="reset" label="reset" onClick="cb1.selectedIndex = -1; msg.value = &quot;&quot;" />
				</vbox>
			</zk>
		"""
    val ztl$engine = engine()
    val cb1 = ztl$engine.$f("cb1")
    val msg = ztl$engine.$f("msg")
    val reset = ztl$engine.$f("reset")
    runZTL(zscript, () => {
      click(jq(jq(".z-combobox").toWidget().$n("btn")))
      waitResponse()
      click(jq(".z-comboitem:eq(0)"))
      waitResponse()
      verifyEquals("aaa", jq(jq(".z-combobox").toWidget().$n("real")).`val`())
      verifyEquals("onSelect is fired, aaa", jq("$msg").text())
      click(reset)
      waitResponse()
      verifyEquals("", jq(".z-combobox-input").`val`())
      click(jq(jq(".z-combobox").toWidget().$n("btn")))
      waitResponse()
      click(jq(".z-comboitem:eq(0)"))
      waitResponse()
      verifyEquals("aaa", jq(jq(".z-combobox").toWidget().$n("real")).`val`())
      verifyEquals("onSelect is fired, aaa", jq("$msg").text())
    })
  }
}



