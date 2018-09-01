/* B50_3087139Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3087139Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
It is correct if you see no JavaScript error, and OK to select items.
<listbox id="lb" mold="select">
	<listitem>
		<listcell label="abc">
		<textbox/>
		</listcell>
	</listitem>
</listbox>
</zk>

		"""
    val ztl$engine = engine()
    val lb = ztl$engine.$f("lb")
    runZTL(zscript, () => {
      select(lb, "abc")
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



