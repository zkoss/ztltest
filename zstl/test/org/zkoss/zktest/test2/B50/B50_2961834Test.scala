/* B50_2961834Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2961834Test extends ZTL4ScalaTestCase {
  @Test
  def testSize() = {
    var zscript =
      """
			<zk>
				<html>		
					<![CDATA[ <ol> <li>Press "r" in combobox.</li> <li>Combobox
					shall select "Richard" automatically</li> <li>Press "Hello"
					button. If you see the combobox show "r" again, it is a
					Bug.</li> </ol> ]]>		
				</html>
				<combobox id="mycombo" value="" constraint="strict, no empty">
					<comboitem id="i1" label="David" />
					<comboitem id="i2" label="Richard" />
					<comboitem id="i3" label="Tom" />
				</combobox>
				<button id="btn" label="Hello">
					<attribute name="onClick">
						new Comboitem("Henri").setParent(mycombo);
					</attribute>
				</button>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val mycombo = ztl$engine.$f("mycombo")
    val i1 = ztl$engine.$f("i1")
    val i2 = ztl$engine.$f("i2")
    val i3 = ztl$engine.$f("i3")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      focus(mycombo.$n("real"))
      sendKeys(mycombo.$n("real"), "R")
      waitResponse()
      verifyEquals("Richard", jq(jq(".z-combobox").toWidget().$n("real")).`val`())
      click(btn)
      waitResponse()
      verifyEquals("Richard", jq(jq(".z-combobox").toWidget().$n("real")).`val`())
    })
  }
}



