package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1955.zul")
class B65_ZK_1955Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1955.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Oct 23, 2013  3:47:14 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	<window border="normal">

		<label multiline="true">
		1. click the magnifying glass button
		--> focus is in bandbox, and the text states so (OK)
		2. click a row in popup
		--> focus is in bandbox, and the text states so (OK)
		3. click somewhere else outside the popup.
		--> you should see "I don't know where is focus" as the message.
		Or in IE, the bandbox will get the focus without that message.
		</label>

		<bandbox onFocus='Clients.log("focus is in bandbox")' onBlur='Clients.log("I do not know where is focus")'>
			<bandpopup style="max-height:330px;" hflex="1">
				<listbox multiple="true">


					<listhead>
						<listheader />
						<listheader></listheader>
					</listhead>

					<listitem>
						<listcell>
							<label value="listcell" />
						</listcell>
						<listcell>
							<label value="listcell" />
						</listcell>
					</listitem>

				</listbox>
			</bandpopup>
		</bandbox>
	</window>
</zk>
"""
    runZTL(zscript,
      () => {
        val bb = jq(".z-bandbox").toWidget()
        focus(bb.$n("real"))
        waitResponse()
        sleep(300)
        verifyContains(getZKLog(), "focus is in bandbox")

        closeZKLog()
        click(bb.$n("btn"))
        waitResponse()
        clickAt(jq(bb.$n("pp")).find(".z-listitem"), "5,5")
        waitResponse()
        sleep(300)
        verifyContains(getZKLog(), "focus is in bandbox")

        closeZKLog()
        click(jq(".z-window-content"))
        waitResponse()
        sleep(300)
        verifyContains(getZKLog(), "I do not know where is focus")
      })

  }
}