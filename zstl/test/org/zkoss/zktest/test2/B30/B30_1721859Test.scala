/* B30_1721859Test.java

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


class B30_1721859Test extends ZTL4ScalaTestCase {
  @Test
  def testWidth() = {
    var zscript =
      """
			<window xmlns:html="http://www.w3.org/1999/xhtml">
				Won't show in IE due to table structure
				<style>
				.blue { background-color: blue; }
				.green { background-color: green; }
				</style>
				
				Each 25%
				<hbox pack="stretch" width="100%" >
				 <vbox id="v1" pack="stretch" sclass="blue" width="50%"> Left </vbox>
				 <vbox id="v2" pack="stretch" sclass="green" width="50%"> Right </vbox>
				</hbox>
				Each 50%
				<hbox pack="stretch" width="100%" >
				 <vbox id="v3" pack="stretch" sclass="blue" width="100%"> Left </vbox>
				 <vbox id="v4" pack="stretch" sclass="green" width="100%"> Right </vbox>
				</hbox>
			</window>
		"""
    val ztl$engine = engine()
    val v1 = ztl$engine.$f("v1")
    val v2 = ztl$engine.$f("v2")
    val v3 = ztl$engine.$f("v3")
    val v4 = ztl$engine.$f("v4")
    runZTL(zscript, () => {
      verifyTrue(jq(v1).outerWidth() - (jq(v1.$n().parentNode()).outerWidth() / 2) <= 2)
      verifyTrue(jq(v2).outerWidth() - (jq(v2.$n().parentNode()).outerWidth() / 2) <= 2)
      verifyTolerant(jq(v3.$n().parentNode()).outerWidth(), jq(v3).outerWidth(), 1)
      verifyTolerant(jq(v4.$n().parentNode()).outerWidth(), jq(v4).outerWidth(), 1)
    })
  }
}



