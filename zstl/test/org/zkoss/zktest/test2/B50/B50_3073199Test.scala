/* B50_3073199Test.java

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


class B50_3073199Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?page title="test" contentType="text/html;charset=UTF-8"?>
<zk>
	<html><![CDATA[
		Click header <b>"first"</b> some times, it is OK if here shows no error messages.
	]]></html>
	<window border="none" height="100%">
		<grid>
			<columns>
				<column label="first" sort="auto" />
				<column label="teine veerg" />
			</columns>
			<rows>
				<row>
					<label value="first first" />
					<label value="first second" />
				</row>
				<row visible="false">
					<label value="second first" />
					<label value="second second" />
				</row>
				<row>
					<label value="third first" />
					<label value="third second" />
				</row>
			</rows>
		</grid>
	</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq("@column").eq(0))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



