/* B36_2726542Test.java

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
import org.zkoss.ztl.Widget


class B36_2726542Test extends ZTL4ScalaTestCase {
  @Test
  def testscorll() = {
    var zscript =
      """
			<zk xmlns:w="http://www.zkoss.org/2005/zk/client">
				<div id="outer" style="overflow-y: scroll; height: 200px;">
				<button label="test" w:onClick='this.$f("outer").$n().scrollTop=200;jq(this.$f("l1")).val(zk(this.$f("outer")).revisedOffset()[1]);'/>
				<div style="height: 800px;background:red;"/> </div>
				<label id="l1"/>
				After click the test button, you should see the message "top, 0".
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val outer = ztl$engine.$f("outer")
    val l1 = ztl$engine.$f("l1")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyEquals("0", jq(l1).`val`().trim())
    })
  }
}



