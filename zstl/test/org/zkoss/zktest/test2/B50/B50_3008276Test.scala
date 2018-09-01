/* B50_3008276Test.java

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


class B50_3008276Test extends ZTL4ScalaTestCase {
  @Test
  def testFocus() = {
    var zscript =
      """
<zk>
<listbox>
<listhead>
<listheader hflex="1"/>
</listhead>
</listbox>
</zk>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyFalse(jq(".z-modal-mask").exists())
    })
  }
}



