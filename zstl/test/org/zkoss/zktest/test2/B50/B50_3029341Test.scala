/* B50_3029341Test.java

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


class B50_3029341Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
<html>
<![CDATA[
<ol>
	<li>Click "a link"</li>
	<li>Check the row of the listbox will not be selected</li>
</ol>
]]>
</html>
	<listbox width="300px">
		<listitem>
			<listcell>
				<a label="a link" />
			</listcell>
			<listcell>
				<button label="button" />
			</listcell>
		</listitem>
		<listitem label="second item" />
	</listbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq("@a"))
      waitResponse()
      verifyFalse(jq("@listitem:eq(1)").is("selected"))
      verifyFalse(jq(".z-listitem-selected").exists())
    })
  }
}



