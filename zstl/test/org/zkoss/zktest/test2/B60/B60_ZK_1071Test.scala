package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1071.zul")
class B60_ZK_1071Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B60-ZK-1071.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Apr 24, 2012  7:49:27 PM, Created by jumperchen

Copyright (C) 2012 Potix Corporation. All Rights Reserved.

-->
<window id="win" title="new page title" border="normal">
	<label multiline="true">
	1.Always happen in Chrome.
	2.open bandbox, select item B in listbox. the bandbox value should become 'B'
	3.click Save, it should pop up a 'value:B' messagebox (however in Chrome it popup a wrong value exception)
	</label>
	<zscript>
	org.zkoss.zul.ListModelList model = new org.zkoss.zul.ListModelList();
	model.add("A");
	model.add("B");
	model.add("C");
	</zscript>
	<vbox hflex="1" pack="stretch" >
		<bandbox id="bd" hflex="1" readonly="true" constraint="no empty"
			onChange="val=bd.value">
			<bandpopup id="bp">
				<vbox align="stretch" hflex="1">
					<listbox model="${model}" 
						onSelect='bd.close();bd.setValue(self.getSelectedItem().getValue())' height="200px" hflex="1">
						<listhead>
							<listheader label="Name" hflex="1" />
						</listhead>
						<template name="model" >
							<listitem>
								<listcell label="${each}" />
							</listitem>
						</template>
					</listbox>
				</vbox>
			</bandpopup>
		</bandbox>
		<button label="Save" onClick='alert("value:"+bd.getValue())' />
	</vbox>
</window>

"""
    runZTL(zscript,
      () => {
        val bb = jq(".z-bandbox")
        click(bb)
        waitResponse()
        click(jq(".z-listitem:contains(B)"))
        waitResponse()
        verifyTrue("the bandbox value should become 'B'",
          bb.toWidget().$n("real").get("value") == "B")
        click(jq(".z-button:eq(0)"))
        waitResponse()
        verifyContains("it should pop up a 'value:B' messagebox",
          jq(".z-messagebox-window .z-label").text(), "value:B")

      })

  }
}