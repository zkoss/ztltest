/* B30_1786154Test.java

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


class B30_1786154Test extends ZTL4ScalaTestCase {
  @Test
  def testForEach() = {
    var zscript =
      """
<zk>
	expect to get 100 ~ 104 in first row, then 105 ~ 109 for next row.
	<zscript>
	int[] counts = new int[2];
	String[] labels = new String[] {"100", "101", "102", "103", "104", "105",
	"106", "107", "108", "109", "110"};
	</zscript>
	<grid>
	<rows>
	
	<row forEach="${counts}">
		<button forEach="${labels}"
		forEachBegin="${forEachStatus.previous.index * 5}"
		forEachEnd="${forEachStatus.previous.index * 5 + 4}"
		label='${each} , ${forEachStatus.previous.index}'/>
		</row>
	</rows>
	</grid>
</zk> 
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyEquals("100 , 0", widget(jq("@button:eq(0)")).attr("label"))
      verifyEquals("101 , 0", widget(jq("@button:eq(1)")).attr("label"))
      verifyEquals("102 , 0", widget(jq("@button:eq(2)")).attr("label"))
      verifyEquals("103 , 0", widget(jq("@button:eq(3)")).attr("label"))
      verifyEquals("104 , 0", widget(jq("@button:eq(4)")).attr("label"))
      verifyEquals("105 , 1", widget(jq("@button:eq(5)")).attr("label"))
      verifyEquals("106 , 1", widget(jq("@button:eq(6)")).attr("label"))
      verifyEquals("107 , 1", widget(jq("@button:eq(7)")).attr("label"))
      verifyEquals("108 , 1", widget(jq("@button:eq(8)")).attr("label"))
      verifyEquals("109 , 1", widget(jq("@button:eq(9)")).attr("label"))
    })
  }
}



