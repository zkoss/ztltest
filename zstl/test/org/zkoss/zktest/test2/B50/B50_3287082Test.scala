/* B50_3287082Test.java

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


class B50_3287082Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
			<li>Open the bandbox.</li>
			<li>Focus in the input of the paging.</li>
			<li>Remove "1", then type "2".</li>
			<li>"no fire" shall not become to "fire".</li>
		</ol>
	]]></html>
	<bandbox onChanging='msg.value = fire'>
		<bandpopup width="300px">
			<grid mold="paging" pageSize="3">
				<rows>
					<row forEach="1,1,1,1,1">
						<label value="item" />
					</row>
				</rows>
			</grid>
		</bandpopup>
	</bandbox>
	<label id="msg" value="no fire"/>
</zk>

		"""
    val ztl$engine = engine()
    val msg = ztl$engine.$f("msg")
    runZTL(zscript, () => {
      click(jq("@bandbox").toWidget().$n("btn"));
      waitResponse()
      typeKeys(jq(".z-paging").toWidget.$n("real"), "2");
      waitResponse()
      verifyEquals(jq(msg).text(), "no fire")
    })
  }
}



