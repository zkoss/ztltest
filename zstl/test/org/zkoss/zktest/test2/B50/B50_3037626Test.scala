/* B50_3037626Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3037626Test extends ZTL4ScalaTestCase {
  @Test
  def testSplitter() = {
    var zscript =
      """
<hbox width="100%" height="100%">
	<cell id="cell1">
		<grid id="grid">
			<rows>
				<row>row</row>
			</rows>
		</grid>
	</cell>
	<splitter />
	<cell>
		<grid>
			<rows>
				<row>row</row>
			</rows>
		</grid>
	</cell>
</hbox>	
		"""
    val ztl$engine = engine()
    val cell1 = ztl$engine.$f("cell1")
    val grid = ztl$engine.$f("grid")
    runZTL(zscript, () => {
      var i = jq("$cell1").width()
      dragdropTo(jq("@splitter"), "0,138", "-250,138")
      verifyTrue(i - 250 - jq("$cell1").width() < 8)
    })
  }
}



