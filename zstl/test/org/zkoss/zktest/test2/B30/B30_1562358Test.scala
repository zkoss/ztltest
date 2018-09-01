/* B30_1562358Test.java

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


class B30_1562358Test extends ZTL4ScalaTestCase {
  @Test
  def testScrollbar() = {
    var zscript =
      """
			<groupbox mold="3d" width="400px"> 
				<caption label="Groupbox With Wrong Width in IE"/>
				<grid id="grid" height="200px" sizedByContent="true"> <!--workaround: style="overflow:auto"-->
					<rows>
						<row id="row">
						(make sure blabla is all on one line - that is it does not
						wrap) 
						blablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablabla		 
						</row> 
					</rows> 	 
				</grid> 
			</groupbox>
		"""
    val ztl$engine = engine()
    val grid = ztl$engine.$f("grid")
    val row = ztl$engine.$f("row")
    runZTL(zscript, () => {
      // if (true) return
      //			verifyTrue(getElementHeight(row.firstChild()) < 35)
      //			varbody = grid.$n("body")
      //			var ch = parseInt(body.attr("clientHeight"))
      //			var oh = parseInt(body.attr("offsetHeight"))
      //			verifyEquals(oh - ch, JQuery.scrollbarWidth())
    })
  }
}



