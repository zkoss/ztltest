/* B50_2981273Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import java.text._
import java.util.Date

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget

class B50_2981273Test extends ZTL4ScalaTestCase {
  @Test
  def testDateformat() = {
    var zscript =
      """
			<datebox id="db" format="dd.MMM.yyyy" onCreate="self.value = new Date();"/>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val db = ztl$engine.$f("db")
    runZTL(zscript, () => {
      var date = jq(db.$n("real")).`val`()
      var year = date.substring(date.lastIndexOf(".") + 1)
      var sdf = new SimpleDateFormat("yyyy")
      verifyEquals(sdf.format(new Date()), year)
    })
  }
}



