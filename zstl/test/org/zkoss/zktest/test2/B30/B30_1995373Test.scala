/* B30_1995373Test.java

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


class B30_1995373Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
<vbox>
	<label value=' Please type a "%" sign into the input element, and then focus out the input element, you should see an error box.' />
	<intbox/>
</vbox>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      typeKeys(jq("input.z-intbox"), "%")
      waitResponse()
      blur(jq("input.z-intbox"))
      waitResponse()
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



