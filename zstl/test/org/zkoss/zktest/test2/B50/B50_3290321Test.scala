/* B50_3290321Test.java

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
import org.zkoss.ztl.util._


class B50_3290321Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<window title="Listbox" border="normal">
				Please scroll to the right most, and click upon the header of the grid to trigger a sorting function, and then the label inside the header should not be appeared in the current screen. 
				<separator bar="true" />
				<listbox id="lb">
					<listhead sizable="true">
						<listheader align="center" width="40px"
							image="/img/Centigrade-Widget-Icons/ArrowsUpDown-16x16.png" />
						<listheader align="center" width="40px"
							image="/img/Centigrade-Widget-Icons/Envelope-16x16.png" />
						<listheader align="center" width="40px"
							image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
						<listheader id="sh" label="Subject" width="4000px" sort="auto" />
						<listheader label="Received" sort="auto" />
					</listhead>
					<listitem height="28px">
						<listcell
							image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
						<listcell
							image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
						<listcell
							image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
						<listcell label="ZK Jet 0.8.0 is released" />
						<listcell label="2008/11/17 17:41:29" />
					</listitem>
					<listitem height="28px">
						<listcell
							image="/img/Centigrade-Widget-Icons/ArrowDown-16x16.png" />
						<listcell
							image="/img/Centigrade-Widget-Icons/Envelope-16x16.png" />
						<listcell
							image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
						<listcell label="URLs for iPhone-Optimized Google Sites" />
						<listcell label="2008/11/17 15:56:37" />
					</listitem>
					<listitem height="28px">
						<listcell label="&#160;" />
						<listcell
							image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
						<listcell label="&#160;" />
						<listcell label="Style Guide for ZK 3.5 released" />
						<listcell label="2008/11/14 13:23:07" />
					</listitem>
					<listitem height="28px">
						<listcell
							image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
						<listcell
							image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
						<listcell label="&#160;" />
						<listcell label="ZK Studio 0.9.0 released." />
						<listcell label="2008/11/16 10:26:37" />
					</listitem>
				</listbox>
			</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lb = ztl$engine.$f("lb")
    val sh = ztl$engine.$f("sh")
    runZTL(zscript, () => {
      lb.$n("head").eval("scrollLeft = 3000")
      lb.$n("body").eval("scrollLeft = 3000")
      sleep(1000)
      var hsl = lb.$n("head").attr("scrollTop").toInt
      clickAt(sh, hsl + ",20")
      waitResponse()
      var newHsl = lb.$n("head").attr("scrollTop").toInt
      verifyTrue(hsl == newHsl)
      verifyTrue(jq(".z-listheader").toWidget().$n("sort-icon").exists())
    })
  }
}



