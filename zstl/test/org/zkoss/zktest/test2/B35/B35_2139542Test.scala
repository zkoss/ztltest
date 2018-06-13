/* B35_2139542Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2139542Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<hbox>
	<datebox id="db" />
	<button label="Click Me without error, that is correct!" onClick='db.setFormat("dd-MMM-yyyy")'/>
</hbox>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val db = ztl$engine.$f("db")
    runZTL(zscript, () => {
      click(jq("@button"))
      verifyFalse(jq(".z-errorbox").exists())
      var n$db = db.$n("real")
      focus(n$db)
      typeKeys(n$db, "asd")
      blur(n$db)
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



