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
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals("100 , 0", widget(jq("@button:eq(0)")).get("label"))
      verifyEquals("101 , 0", widget(jq("@button:eq(1)")).get("label"))
      verifyEquals("102 , 0", widget(jq("@button:eq(2)")).get("label"))
      verifyEquals("103 , 0", widget(jq("@button:eq(3)")).get("label"))
      verifyEquals("104 , 0", widget(jq("@button:eq(4)")).get("label"))
      verifyEquals("105 , 1", widget(jq("@button:eq(5)")).get("label"))
      verifyEquals("106 , 1", widget(jq("@button:eq(6)")).get("label"))
      verifyEquals("107 , 1", widget(jq("@button:eq(7)")).get("label"))
      verifyEquals("108 , 1", widget(jq("@button:eq(8)")).get("label"))
      verifyEquals("109 , 1", widget(jq("@button:eq(9)")).get("label"))
    })
  }
}



