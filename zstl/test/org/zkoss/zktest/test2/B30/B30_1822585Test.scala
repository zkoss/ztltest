/* B30_1822585Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1822585Test extends ZTL4ScalaTestCase {
  @Test
  def testonColSize() = {
    val ztl$engine = engine()
    val lab = ztl$engine.$f("lab")
    val cs = ztl$engine.$f("cs")
    val col1 = ztl$engine.$f("col1")
    val col2 = ztl$engine.$f("col2")
    val col3 = ztl$engine.$f("col3")
    val col4 = ztl$engine.$f("col4")
    val col5 = ztl$engine.$f("col5")
    runZTL(() => {
      var w1 = jq(col1).width()
      var w2 = jq(col2).width()
      var w3 = jq(col3).width()
      var w4 = jq(col4).width()
      var w5 = jq(col5).width()
      dragdropTo(col5, w5 + ",0", w5 + 10 + ",0")
      waitResponse()
      verifyContains(lab.attr("value"), "colindex:4")
      dragdropTo(col4, w4 + ",0", w4 + 10 + ",0")
      waitResponse()
      verifyContains(lab.attr("value"), "colindex:3")
      dragdropTo(col3, w3 + ",0", w3 + 10 + ",0")
      waitResponse()
      verifyContains(lab.attr("value"), "colindex:2")
      dragdropTo(col2, w2 + ",0", w2 + 10 + ",0")
      waitResponse()
      verifyContains(lab.attr("value"), "colindex:1")
      dragdropTo(col1, w1 + ",0", w1 + 10 + ",0")
      waitResponse()
      verifyContains(lab.attr("value"), "colindex:0")
    })
  }
}



