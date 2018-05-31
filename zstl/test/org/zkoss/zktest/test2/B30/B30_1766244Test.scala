/* B30_1766244Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1766244Test extends ZTL4ScalaTestCase {
  @Test
  def testScrolling() = {
    var zscript =
      """
		<window title="Bug: combox in scrollable grid">
		 <grid id="grid" height="105px">
		  <columns>
		   <column/><column/>
		  </columns> 
		  <rows>
			<row>combobox
			<combobox>
			<comboitem label="First"/>
			<comboitem label="Second"/>
			<comboitem label="Third"/>
			</combobox>
			</row>
			<row>datebox <datebox/></row>
			<row>combobox
			<combobox id="cb">
			<comboitem label="First"/>
			<comboitem label="Second"/>
			<comboitem label="Third"/>
			</combobox>
			</row>
			<row>combobox <combobox/></row>
			<row>combobox <combobox/></row>
			<row>combobox <combobox/></row>
		  </rows>
		 </grid>
		</window>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val grid = ztl$engine.$f("grid")
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      var offset1: Array[Int] = zk(cb).revisedOffset()
      var offset2: Array[Int] = zk(cb.$n("btn")).revisedOffset()
      grid.$n("body").eval("scrollTop = 20")
      var offset3 = zk(cb).revisedOffset()
      var offset4 = zk(cb.$n("btn")).revisedOffset()
      verifyEquals(offset1(0), offset3(0))
      verifyEquals(offset2(0), offset4(0))
      verifyEquals(offset1(1) - 20, offset3(1))
      verifyEquals(offset2(1) - 20, offset4(1))
      grid.$n("body").eval("scrollTop = 0")
      offset3 = zk(cb).revisedOffset()
      offset4 = zk(cb.$n("btn")).revisedOffset()
      verifyEquals(offset1(0), offset3(0))
      verifyEquals(offset1(1), offset3(1))
      verifyEquals(offset2(0), offset4(0))
      verifyEquals(offset2(1), offset4(1))
    })
  }
}



