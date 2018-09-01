/* B50_3026665Test.java

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


class B50_3026665Test extends ZTL4ScalaTestCase {
  @Test
  def testFocusStyle() = {
    var zscript =
      """
<?page title="Bandbox gets focus from children focus" contentType="text/html;charset=UTF-8"?>
<zk>
	<bandbox>
		<bandpopup>
			<intbox />
		</bandpopup>
	</bandbox>
	<intbox/>
</zk>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      click(jq("@bandbox").toWidget().$n("btn"))
      waitResponse();
      focus(jq(jq("@bandbox").toWidget().$n("pp")).find("@intbox"))
      waitResponse()
      verifyNotEquals("", jq("@bandbox").css("box-shadow"))
    })
  }
}



