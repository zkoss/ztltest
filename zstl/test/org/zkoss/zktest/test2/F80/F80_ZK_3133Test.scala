/* F80_ZK_3133Test.scala

	Purpose:
		
	Description:
		
	History:
		Fri, Jun  3, 2016  6:18:15 PM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.F80

import org.junit.Test
import org.openqa.selenium.Dimension
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  *
  * @author Sefi
  */
@Tags(tags = "F80-ZK-3133.zul")
class F80_ZK_3133Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    val zscript =
      """<zk>
					<label multiline="true">
						1. should see "there are more then one MatchMedia method "all and (min-width: 501px)" in class org.zkoss.zktest.test2.F80_ZK_3133_1_VM" error below two window
						1. should see "onCreate" in zklog
						2. shrink the width of the browser to 450px
						3. should see the content text in both windows change from "browser width &gt; 500px" to "browser width = 450px"
						4. reload this zul without closing the browser
						5. the content text of both windows should remain "browser width = 450px"
						6. enlarge the width of the browser to 550px
						7. should see the content text of both windows change from "browser width = 450px" to "browser width &gt; 500px"

					</label>
					<div viewModel="@id('vm') @init('org.zkoss.zktest.test2.F80_ZK_3133_VM')">
						<window border="normal" width="@bind(vm.windowWidth)" title="window0">
							<apply template="@bind(vm.templateName)"/>
						</window>
					</div>
					<template name="a">
						<label value="@bind(vm.text)"/>
					</template>
					<template name="b">
						<label value="@bind(vm.text)"/>
					</template>
					<div viewModel="@id('vm') @init('org.zkoss.zktest.test2.F80_ZK_3133_2_VM')">
						<window border="normal" width="@bind(vm.windowWidth)" title="window1">
							<label value="@bind(vm.label1)" onCreate="@command('all and (min-width: 501px)')"/>
						</window>
					</div>
					<iframe src="test2/F80-ZK-3133-1.zul" width="100%" vflex="1"/>
				</zk>"""

    runZTL(zscript, () => {

      verifyTrue(getZKLog(), "onCreate")

      var zwin = jq(".z-window-content")
      val zwin1orgw = parseInt(zwin.eq(0).text())
      val zwin2orgw = parseInt(zwin.eq(1).text())
      setWindowSize(450, getWindowHeight())
      waitResponse()

      val zwin1w = parseInt(zwin.eq(0).text())
      val zwin2w = parseInt(zwin.eq(1).text())
      verifyTrue(zwin1w < zwin1orgw)
      verifyTrue(zwin2w < zwin2orgw)

      refresh()
      waitForPageToLoad("10000");
      runRawZscript(zscript)
      waitResponse()

      zwin = jq(".z-window-content")
      verifyEquals(zwin1w, parseInt(zwin.eq(0).text()))
      verifyEquals(zwin2w, parseInt(zwin.eq(1).text()))

      setWindowSize(550, getWindowHeight())
      waitResponse()

      verifyContains(zwin.eq(0).text(), "browser width > 500px")
      verifyContains(zwin.eq(1).text(), "browser width > 500px")

    })
  }
}
