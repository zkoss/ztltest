/* B70_ZK_1816Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct  7 14:54:38 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  *
  * @author chunfu
  */
@Tags(tags = "")
class B70_ZK_1816Test extends ZTL4ScalaTestCase {
  @Test
  def testCase() = {
    val zscript =
      """
			<?xml version="1.0" encoding="UTF-8"?>

		<!--
B70-ZK-1816.zul

	Purpose:

	Description:

	History:
		Mon Jun  1 11:50:25 CST 2015, Created by chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
			<zk>
				<label multiline="true">
					1. hide 1st listheader
					2. sort 2nd listheader
					3. 1st listheader shouldn't appear
				</label>
				<listbox id="box">
					<listhead menupopup="auto">
						<listheader label="Name" sort="auto" />
						<listheader label="Gender" sort="auto" />
						<listheader label="Age"  sort="auto"/>
						<listheader label="Description"  sort="auto"/>
					</listhead>
					<listitem>
						<listcell label="Mary" />
						<listcell label="FEMALE" />
						<listcell label="18" />
						<listcell label="A young lady." />
					</listitem>
					<listitem>
						<listcell label="Emma" />
						<listcell label="FEMALE" />
						<listcell label="19" />
						<listcell label="A young lady." />
					</listitem>
					<listitem>
						<listcell label="John" />
						<listcell label="MALE" />
						<listcell label="20" />
						<listcell label="A college student." />
					</listitem>
					<listitem>
						<listcell label="Jane" />
						<listcell label="FEMALE" />
						<listcell label="32" />
						<listcell label="A remarkable artist." />
					</listitem>
					<listitem>
						<listcell label="Judy" />
						<listcell label="FEMALE" />
						<listcell label="34" />
						<listcell label="A remarkable artist." />
					</listitem>
					<listitem>
						<listcell label="Henry" />
						<listcell label="MALE" />
						<listcell label="29" />
						<listcell label="A graduate." />
					</listitem>
					<listitem>
						<listcell label="Howard" />
						<listcell label="MALE" />
						<listcell label="21" />
						<listcell label="A graduate." />
					</listitem>
				</listbox>
			</zk>
"""
    runZTL(zscript, () => {
      var listheader = jq(".z-listheader");
      var listheadBtn = jq(".z-listheader-button");
      mouseOver(listheader.eq(0));
      click(listheadBtn)
      waitResponse()
      click(jq(".z-menuitem-content").eq(4))
      waitResponse()
      mouseOver(listheader.eq(1));
      click(listheader.eq(1));
      waitResponse()
      verifyEquals("hidden", jq("@listheader").css("visibility"))
    })
  }
}
