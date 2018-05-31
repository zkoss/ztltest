/* B35_2233787Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B35_2233787Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<window title="Radiogroup and checkbox" border="normal">
				<vbox>
					select a radio then use arrow key to change selection, if not
					null show, its fixed.
					<radiogroup onCheck='fruit.value = self.selectedItem+""'>
						<radio id="r1" label="Apple" />
						<radio id="r2" label="Orange" />
						<radio label="Grape" />
					</radiogroup>
					<hbox>
						You have selected :
						<label id="fruit" />
					</hbox>
				</vbox>
			</window>	
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val r1 = ztl$engine.$f("r1")
    val r2 = ztl$engine.$f("r2")
    val fruit = ztl$engine.$f("fruit")
    runZTL(zscript, () => {
      click(r2.$n("real"))
      sendKeys(r2.$n("real"), Keys.ARROW_RIGHT)
      waitResponse()
      verifyNotEquals("null", jq(fruit).text())
      verifyNotEquals("", jq(fruit).text())
    })
  }
}



