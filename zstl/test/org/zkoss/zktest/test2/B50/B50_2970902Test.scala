/* B50_2970902Test.java

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


class B50_2970902Test extends ZTL4ScalaTestCase {
  @Test
  def testVisible() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" arg0="./win"?>
			<window id="win" title="new page title" border="normal">
				<zscript>
				String[] entries = new String[] { " ", "A", "B" };
				</zscript>
				<combobox id="cb1" model="@{entries}" />
				<combobox id="cb2">
					<comboitem id="ci2" label=" " />
					<comboitem label="A" />
					<comboitem label="B" />
				</combobox>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val cb1 = ztl$engine.$f("cb1")
    val cb2 = ztl$engine.$f("cb2")
    val ci2 = ztl$engine.$f("ci2")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      cb1.set("open", true)
      verifyTrue(cb1.firstChild().$n().get("offsetHeight").toInt > 5)
      waitResponse()
      cb2.set("open", true)
      verifyTrue(ci2.$n().get("offsetHeight").toInt > 5)
    })
  }
}



