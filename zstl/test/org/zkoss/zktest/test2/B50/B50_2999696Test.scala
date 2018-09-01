/* B50_2999696Test.java

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


class B50_2999696Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
<html>
<![CDATA[
<ol>
	<li>If you see no Exception, then it is OK.</li>
</ol>
]]>
</html>
<grid hflex="min" vflex="min">
	<columns>
		<column hflex="min"/>
		<column hflex="min"/>
	</columns>
	<rows>
		<row>
			<label value="File:"/>
			<textbox width="98%"/>
		</row>
		<row>
			<label value="Type:"/>
			<hbox>
				<listbox rows="1" mold="select">
					<listitem label="Java Files,(*.java)"/>
					<listitem label="All Files,(*.*)"/>
				</listbox>
				<button label="Browse..."/>
			</hbox>
		</row>
		<row>
			<label value="Options:"/>
			<textbox rows="3" width="99%"/>
		</row>
	</rows>
</grid>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      if (jq(".z-window-highlighted").exists() || jq(".z-window-modal").exists()) {
        verifyTrue(false)
      }
    })
  }
}



