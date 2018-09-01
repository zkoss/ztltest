/* B35_2150566Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2150566Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
<listbox width="200px">
<listgroup label="Listgroup" id="lg"/>
<listitem label="Listitem"/>
</listbox>
<button label="After click me, and then click the 'open/close' icon should be open/close well"
onClick='lg.label="test"'/>
</zk>

		"""
    val ztl$engine = engine()
    val lg = ztl$engine.$f("lg")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyTrue(jq("@listitem @listcell").isVisible())
      click(jq("@listgroup").toWidget().$n("img"))
      waitResponse()
      verifyFalse(jq("@listitem @listcell").isVisible())
    })
  }
}



