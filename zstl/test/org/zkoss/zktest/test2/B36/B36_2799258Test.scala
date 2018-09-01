/* B36_2799258Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2799258Test extends ZTL4ScalaTestCase {
  @Test
  def testscrollbar() = {
    var zscript =
      """
			<zk>
			please increase the column's width to show the horizontal scrollbar, and the scrollbar should not cover over the item. (IE only)
			<listbox fixedLayout="true">
				<listhead sizable="true">
					<listheader align="center" width="40px" label="col1" />
					<listheader align="center" label="col2" />
					<listheader align="center" label="col3" />
					<listheader label="col4" />
					<listheader label="col5" />
				</listhead>
				<listitem height="28px">
					<listcell label="content1" />
					<listcell label="content2" />
					<listcell label="content3" />
					<listcell label="content4" />
					<listcell label="content5" />
				</listitem>
			</listbox>
			</zk>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      var header = jq("@listheader:eq(0)")
      var x = header.outerWidth()
      // Distance of dragging must be very large because you
      // cannot know how much the screen size of test machine is.
      dragdropTo(header, x + ",0", (x + 5000) + ",0")
      var body = jq(jq("@listbox").toWidget().$n("cave"))
      var bodyHeight = body.outerHeight()
      var caveHeight = body.find("table").outerHeight()
      verifyTrue((bodyHeight - 15) > caveHeight); //15: the height of the scroll bar
    })
  }
}



