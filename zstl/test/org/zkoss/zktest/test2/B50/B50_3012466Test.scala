/* B50_3012466Test.java

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


class B50_3012466Test extends ZTL4ScalaTestCase {
  @Test
  def testSelect() = {
    var zscript =
      """
		<zk>
Please select 'a' or 'b', you should see the result as you selected.
<listbox mold="select" onSelect="self.selectedItem.invalidate();">
<listitem label="a"/>
<listitem label="b"/>
<listitem label="c" selected="true"/>
</listbox>
</zk>
	 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      select(jq("@select"), "b")
      waitResponse()
      verifyEquals(getSelectedLabel(jq("@select")), "b");
      select(jq("@select"), "a")
      waitResponse()
      verifyEquals(getSelectedLabel(jq("@select")), "a")
    })
  }
}



