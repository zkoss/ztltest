/* B35_1962310Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_1962310Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
If you can use keyboard to up/down each item, that is correct.
<listbox width="250px" focus="true">
	<listhead>
		<listheader visible="false" label="Name" sort="auto" />
		<listheader label="Gender" sort="auto" />
	</listhead>
	<listitem selected="true">
		<listcell label="Mary" />
		<listcell label="female" />
	</listitem>
	<listitem>
		<listcell label="John" />
		<listcell label="male" />
	</listitem>
	<listitem>
		<listcell label="Jane" />
		<listcell label="female" />
	</listitem>
	<listitem>
		<listcell label="Henry" />
		<listcell label="male" />
	</listitem>
</listbox>
</zk>

		"""
    runZTL(zscript, () => {
      click(jq(".z-listitem-selected"))
      verifyEquals(0, jq(".z-listitem-selected").eval("index()"))
      sendKeys(jq("@listbox"), Keys.DOWN)
      waitResponse()
      verifyEquals(1, jq(".z-listitem-selected").eval("index()"))
      sendKeys(jq("@listbox"), Keys.DOWN)
      waitResponse()
      verifyEquals(2, jq(".z-listitem-selected").eval("index()"))
      sendKeys(jq("@listbox"), Keys.UP)
      waitResponse()
      verifyEquals(1, jq(".z-listitem-selected").eval("index()"))
    })
  }
}



