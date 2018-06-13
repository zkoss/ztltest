/* B50_2980977Test.java

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


class B50_2980977Test extends ZTL4ScalaTestCase {
  @Test
  def testSetspan() = {
    var zscript =
      """
			<zk>
			<grid>
			<rows>
			<row>
			<label value="File:"/>
			<textbox width="98%"/>
			</row>
			<row id="row">
			<label value="File:"/>
			<textbox width="98%"/>
			</row>
			<row>
			<label value="Options:"/>
			<textbox rows="3" width="98%"/>
			</row>
			</rows>
			</grid>
			<button id="btn" label="Click Me you should see the stripe still exists."
			onClick='row.setSpans("1,1")'/>
			<button id="btn2" label="Click Me you should see the stripe still exists."
			onClick='row.setClass("abc")'/>
			</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val row = ztl$engine.$f("row")
    val btn = ztl$engine.$f("btn")
    val btn2 = ztl$engine.$f("btn2")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyTrue(jq(row).hasClass("z-row z-grid-odd"))
      click(btn2)
      waitResponse()
      verifyTrue(jq(row).hasClass("z-row z-grid-odd"))
    })
  }

  @Test
  def testSetSclass() = {
    var zscript =
      """
		<zk>
			<listbox fixedLayout="true">
				<listhead sizable="true">
					<listheader align="center" width="40px"
						image="/img/Centigrade-Widget-Icons/ArrowsUpDown-16x16.png" />
					<listheader align="center" width="40px" image="/img/Centigrade-Widget-Icons/Envelope-16x16.png" />
					<listheader align="center" width="40px"
						image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
					<listheader label="Subject" sort="auto"/>
					<listheader label="Received" sort="auto"/>
				</listhead>
				<listitem height="28px">
					<listcell image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
					<listcell image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
					<listcell image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
					<listcell label="ZK Jet 0.8.0 is released" />
					<listcell label="2008/11/17 17:41:29" />
				</listitem>
				<listitem height="28px">
					<listcell image="/img/Centigrade-Widget-Icons/ArrowDown-16x16.png" />
					<listcell image="/img/Centigrade-Widget-Icons/Envelope-16x16.png" />
					<listcell image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
					<listcell label="URLs for iPhone-Optimized Google Sites" />
					<listcell label="2008/11/17 15:56:37" />
				</listitem>
				<listitem height="28px">
					<listcell label="&#160;" />
					<listcell image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
					<listcell label="&#160;" />
					<listcell label="Style Guide for ZK 3.5 released" />
					<listcell label="2008/11/14 13:23:07" />
				</listitem>
				<listitem id="row" height="28px">
					<listcell image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
					<listcell image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
					<listcell label="&#160;" />
					<listcell label="ZK Studio 0.9.0 released." />
					<listcell label="2008/11/16 10:26:37" />
				</listitem>
			</listbox>
			<button id="btn" label="Click Me you should see the stripe still exists."
			onClick='row.setClass("abc")'/>
		</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val row = ztl$engine.$f("row")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyTrue(jq(row).hasClass("z-listitem z-listbox-odd"))
    })
  }
}



