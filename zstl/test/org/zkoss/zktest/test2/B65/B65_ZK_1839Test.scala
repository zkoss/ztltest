package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1839.zul")
class B65_ZK_1839Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1839.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jul 15, 2013  2:26:53 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	Please click the dropdown list(select tag), it should show up the list on IE9. Otherwise, it is a bug.
	<listbox>
		<listhead sizable="true">
			<listheader align="center" width="40px" />
			<listheader align="center" width="40px" />
			<listheader align="center" width="40px" />
			<listheader label="Subject" sort="auto" />
			<listheader label="Received" width="200px" />
		</listhead>
		<listitem height="28px" draggable="aaa">
			<listcell />
			<listcell />
			<listcell />
			<listcell />
			<listcell>
				<listbox width="100%" mold="select">
					<listitem label="Test1" selected="true" />
					<listitem label="Test2" />
				</listbox>
			</listcell>
		</listitem>
	</listbox>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-select"))
        waitResponse()

        verifyTrue("it should show up the list",
          jq(".z-option:contains(Test1)").exists && jq(".z-option:contains(Test1)").exists)

      })

  }
}