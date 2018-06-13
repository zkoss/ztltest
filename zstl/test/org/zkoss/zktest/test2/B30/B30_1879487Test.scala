/* B30_1879487Test.java

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


class B30_1879487Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>There are two situations in which this events happen</n:p>
				<n:ol>
					<n:li>
						After loading zul, please drop down the list of items and click
						outside of the combobox (for example in order to close dropped
						down list without any selection) the onSelect event should not fire
						and messagebox 'on select: item is null' shouldn't appear.
					</n:li>
					<n:li>
						After loading zul, please focus in combobox, and then click on the 'anyMessage' button.
						It should not show any messages about the onSelect event. It should show "anyMessage".
					</n:li>
				</n:ol>
				<vbox>
					<combobox id="cb1" constraint="strict"
						onSelect="Messagebox.show(self.selectedItem != null ?
			self.selectedItem.value : &quot; on select: item is null&quot;);">
						<comboitem label="aaa" value="1" />
						<comboitem label="bbb" value="2" />
					</combobox>
					<zscript>
			
					</zscript>
					<button label="anyMessage"
						onClick="Messagebox.show(&quot;anyMessage&quot;)" />
				</vbox>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb1 = ztl$engine.$f("cb1")
    runZTL(zscript, () => {
      click(jq(jq(".z-combobox").toWidget().$n("btn")))
      waitResponse()
      clickAt(jq("p"), "3,3")
      waitResponse()
      verifyFalse(jq(".z-messagebox").exists())
      click(jq(".z-button"))
      waitResponse()
      verifyEquals("anyMessage", jq(".z-messagebox .z-label").text())
    })
  }
}



