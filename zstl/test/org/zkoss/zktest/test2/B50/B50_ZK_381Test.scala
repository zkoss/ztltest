/* B50_ZK_381Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_ZK_381Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<html><![CDATA[
				<ol>
				<li>Click right arrow to scroll menubar to right most side.</li>
				<li>Click left arrow to scroll menubar to left most side.</li>
				<li>The bug is fixed if do above without any problem.</li>
				</ol>
				]]></html>
					<menubar id="menubar" width="130px" scrollable="true">
						<menu label="Project" image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
							<menupopup>
								<menuitem label="New" onClick="alert(self.label)"  />
								<menuitem label="Open" onClick="alert(self.label)" />
								<menuitem label="Save" onClick="alert(self.label)"  />
								<menuitem label="Exit" onClick="alert(self.label)"  />
							</menupopup>
						</menu>
						<menu label="Help">
							<menupopup>
								<menuitem label="Bug Report" onClick="alert(self.label)"  />
								<menu label="About">
									<menupopup>
										<menuitem label="About Potix"  onClick="alert(self.label)" />
									</menupopup>
								</menu>
							</menupopup>
						</menu>
						<menuitem label="ZK Web Framework" onClick="alert(self.label)" />
					</menubar>
				</zk>

		"""
    val ztl$engine = engine()
    val menubar = ztl$engine.$f("menubar")
    runZTL(zscript, () => {
      var i = jq(menubar.$n("cave")).children().length()
      var e = jq(menubar.$n("cave")).get(0).firstChild()
      //0
      var wd1 = parseInt(e.attr("offsetWidth"))
      e = e.nextSibling()
      //1
      var wd2 = parseInt(e.attr("offsetWidth"))
      e = e.nextSibling()
      //2
      var wd3 = parseInt(e.attr("offsetWidth"))
      for (j <- 0 until 5) {
        click(jq(".z-menubar").toWidget().$n("right"))
        sleep(500)
      }
      waitResponse()
      verifyTolerant(parseInt(menubar.$n("body").attr("scrollLeft")), wd1 + wd2 + wd3 - jq(menubar.$n("body")).outerWidth(), 16)
      for (j <- 0 until 5) {
        click(jq(".z-menubar").toWidget().$n("left"))
        sleep(500)
      }
      waitResponse()
      verifyEquals(0, menubar.$n("body").attr("scrollLeft"))
    })
  }
}



