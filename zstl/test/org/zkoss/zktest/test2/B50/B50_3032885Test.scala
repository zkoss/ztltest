/* B50_3032885Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3032885Test extends ZTL4ScalaTestCase {
  @Test
  def testInplace() = {
    var zscript =
      """
<zk>
<vbox>
<div><combobox mold="rounded" inplace="true" />&lt;&lt;Combobox Here</div>
<div><bandbox mold="rounded" inplace="true" />&lt;&lt;Bandbox Here</div>
<div><datebox mold="rounded" inplace="true" />&lt;&lt;Datebox Here</div>
<div><timebox mold="rounded" inplace="true" />&lt;&lt;Timebox Here</div>
<div><spinner mold="rounded" inplace="true" />&lt;&lt;Spinner Here</div>
<label>When any of the Combo Input above gets focus, this label will be pushed down.</label>
</vbox>
</zk>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      var t1 = jq("@label:eq(0)").offsetTop()
      focus(jq("@combobox").toWidget().$n("real"))
      verifyEquals(t1, jq("@label:eq(0)").offsetTop())
      t1 = jq("@label:eq(1)").offsetTop()
      focus(jq("@bandbox").toWidget().$n("real"))
      verifyEquals(t1, jq("@label:eq(1)").offsetTop())
      t1 = jq("@label:eq(2)").offsetTop()
      focus(jq("@datebox").toWidget().$n("real"))
      verifyEquals(t1, jq("@label:eq(2)").offsetTop())
      t1 = jq("@label:eq(3)").offsetTop()
      focus(jq("@timebox").toWidget().$n("real"))
      verifyEquals(t1, jq("@label:eq(3)").offsetTop())
      t1 = jq("@label:eq(4)").offsetTop()
      focus(jq("@spinner").toWidget().$n("real"))
      verifyEquals(t1, jq("@label:eq(4)").offsetTop())
    })
  }
}



