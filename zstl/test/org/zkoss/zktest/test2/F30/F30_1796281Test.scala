/* F30_1796281Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class F30_1796281Test extends ZTL4ScalaTestCase {
  @Test
  def testTest() = {
    var zscript =
      """
			
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>[ 1796281 ] Improve Working with Combobox. Both setSelectedItem(Comboitem item) and setSelectedIndex(int jsel) are
			supported.</n:p>
				<n:ol>
					<n:li>click selectedItem , then combobox will sets the selectItem to "Cool!"</n:li>
					<n:li>click selectedIndex, then combobox will sets the selectItem to "Thumbs Up!"</n:li>
				</n:ol>
				<combobox id="cbbox">
					<comboitem label="Apple" />
					<comboitem label="Grape" />
					<comboitem id="c" label="Cool!" />
					<comboitem label="Simple and Rich" />
					<comboitem label="Thumbs Up!" />
				</combobox>
				<button id="btn1" label="selectedItem = Cool!" onClick="cbbox.selectedItem = c"/>
				<button id="btn2" label="selectedIndex = 4" onClick="cbbox.selectedIndex = 4"/>
			</zk>
		"""
    val ztl$engine = engine()
    val cbbox = ztl$engine.$f("cbbox")
    val c = ztl$engine.$f("c")
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    runZTL(zscript, () => {
      verifyEquals("", cbbox.$n("real").attr("value"))
      click(btn1)
      waitResponse()
      verifyEquals("Cool!", cbbox.$n("real").attr("value"))
      click(btn2)
      waitResponse()
      verifyEquals("Thumbs Up!", cbbox.$n("real").attr("value"))
    })
  }
}



