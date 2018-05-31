/* B30_2197450Test.java

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
import org.zkoss.ztl.Widget


class B30_2197450Test extends ZTL4ScalaTestCase {
  @Test
  def testcombobox() = {
    var zscript =
      """
			<zk>
			<zscript>
			void dump(Label i) {
				String value = "";
				for (Component r = page.firstRoot; r != null; r = r.nextSibling)
					value += "" + r.id +",";
				i.value = value;
			}
			</zscript>
			
			<window id="win1" title="win1" border="normal" width="200px">Click
				<button id="btn" label="test" onClick="dump(i1)"/>
				and you shall see "win1,win2,win3,"
				<separator/>
				<label id="i1"/>
				<separator/>
				Then, click <button id="btn1" label="test2" onClick="win2.detach();dump(i2)"/>
				and you shall see "win1,win3,"
				<separator/>
				<label id="i2"/>
			</window>
			<window id="win2" title="win2" width="200px">Hello, 2nd World!</window>
			<window id="win3" title="win3" border="normal" width="200px">Hello, 3rd World!
			</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win1 = ztl$engine.$f("win1")
    val btn = ztl$engine.$f("btn")
    val i1 = ztl$engine.$f("i1")
    val btn1 = ztl$engine.$f("btn1")
    val i2 = ztl$engine.$f("i2")
    val win2 = ztl$engine.$f("win2")
    val win3 = ztl$engine.$f("win3")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyEquals(3, jq("div.z-window-embedded").length())
      verifyEquals("win1,win2,win3,", (jq(i1.$n()).text()))
      click(btn1)
      waitResponse()
      verifyEquals("win1,win3,", (jq(i2.$n()).text()))
      verifyEquals(2, jq("div.z-window-embedded").length());
    })
  }
}



