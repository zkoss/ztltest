/* B50_2931091Test.java

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


class B50_2931091Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					Please check the menu will change style after mouse over and out
					<menubar>
						<menu id="m" label="test">
							<menupopup>
								<menu label="test" />
								<menu label="test" />
								<menu label="test" />
								<menu label="test" />
								<menu label="test" />
							</menupopup>
						</menu>
					</menubar>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val m = ztl$engine.$f("m")
    runZTL(zscript, () => {
      // 				cant get correct hover style
      //				varmenu = jq(".z-menu").toWidget().$n("a")
      //				var borderColor = jq(menu).css("border-color")
      //				verifyNotEquals(Strings.isNullOrEmpty(borderColor) ? borderColor : ColorVerifingHelper.transform(borderColor), "#8fb9d0")
      //				mouseOver(jq(".z-menu").toWidget().$n("a"))
      //				waitResponse()
      //				sleep(500);
      //				borderColor = jq(menu).css("border-color");
      //				verifyEquals(Strings.isNullOrEmpty(borderColor) ? borderColor : ColorVerifingHelper.transform(borderColor), "#8fb9d0");
      //				mouseOut(jq(".z-menu").toWidget().$n("a"))
      //				waitResponse()
      //				sleep(300)
      //				borderColor = jq(menu).css("border-color")
      //				verifyNotEquals(Strings.isNullOrEmpty(borderColor) ? borderColor : ColorVerifingHelper.transform(borderColor), "#8fb9d0")
    })
  }
}



