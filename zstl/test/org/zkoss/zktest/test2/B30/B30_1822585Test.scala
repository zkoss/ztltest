/* B30_1822585Test.java

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


class B30_1822585Test extends ZTL4ScalaTestCase {
  @Test
  def testonColSize() = {
    var zscript =
      """
<vbox>
Grid:onColSize event.getColIndex() alwyas return 1
	<label id="lab"/>
	<grid width="500px">
		<columns id="cs" sizable="true" onColSize='lab.value= event.getColIndex() + ""'>
			<column label="AA" id="col1" />
			<column label="BB" id="col2" />
			<column label="CC" id="col3" />
			<column label="DD" id="col4" />
			<column label="EE" id="col5" />
		</columns>
		<rows>
			<row>
				<label value="AA01" />
				<label value="BB01" />
				<label value="CC01" />
				<label value="DD01" />
				<label value="EE01" />
			</row>
			<row>
				<label value="AA02" />
				<label value="BB02" />
				<label value="CC02" />
				<label value="DD02" />
				<label value="EE02" />
			</row>
		</rows>
	</grid>
</vbox>
		 """
    val ztl$engine = engine()
    val lab = ztl$engine.$f("lab")
    val cs = ztl$engine.$f("cs")
    val col1 = ztl$engine.$f("col1")
    val col2 = ztl$engine.$f("col2")
    val col3 = ztl$engine.$f("col3")
    val col4 = ztl$engine.$f("col4")
    val col5 = ztl$engine.$f("col5")
    runZTL(zscript, () => {
      var w1 = jq(col1).outerWidth()
      var w2 = jq(col2).outerWidth()
      var w3 = jq(col3).outerWidth()
      var w4 = jq(col4).outerWidth()
      var w5 = jq(col5).outerWidth()
      dragdropTo(col5, w5 + ",0", w5 + 10 + ",0")
      waitResponse()
      verifyEquals(lab.attr("value"), "4")
      dragdropTo(col4, w4 + ",0", w4 + 10 + ",0")
      waitResponse()
      verifyEquals(lab.attr("value"), "3")
      dragdropTo(col3, w3 + ",0", w3 + 10 + ",0")
      waitResponse()
      verifyEquals(lab.attr("value"), "2")
      dragdropTo(col2, w2 + ",0", w2 + 10 + ",0")
      waitResponse()
      verifyEquals(lab.attr("value"), "1")
      dragdropTo(col1, w1 + ",0", w1 + 10 + ",0")
      waitResponse()
      verifyEquals(lab.attr("value"), "0")
    })
  }
}



