/* B30_1984025Test.java

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


class B30_1984025Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window title="Test" border="normal">
	You should see the "Ready" footer in this demo.
<listbox width="250px" height="400px">
<listhead sizable="true">
<listheader label="name" sort="auto"/>
<listheader label="gender" sort="auto"/>
</listhead>
<listitem>
<listcell label="Mary"/>
<listcell label="FEMALE"/>
</listitem>
<listitem>
<listcell label="John"/>
<listcell label="MALE"/>
</listitem>
<listitem>
<listcell label="Jane"/>
<listcell label="FEMALE"/>
</listitem>
<listitem>
<listcell label="Henry"/>
<listcell label="MALE"/>
</listitem><listfoot>
<listfooter label="Ready" />
</listfoot>
</listbox>
</window>


		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals("Ready", jq("@listfooter:visible").text())
    })
  }
}



