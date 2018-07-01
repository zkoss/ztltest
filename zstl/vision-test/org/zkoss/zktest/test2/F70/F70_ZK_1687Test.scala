package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-1687.zul")
class F70_ZK_1687Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
F70-ZK-1687.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Oct 30, 2013  5:26:04 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	<vlayout vflex="true">
	<hlayout>
	<label multiline="true">
	1. Portallayout support horizontal view (row based layout).
	2. Please check the horizental checkbox.
	3. Drag and drop any panel it should be able to re-position as horizontal.
	</label>
	<checkbox label="horizental">
		<attribute name="onCheck">
		pl.setOrient(self.isChecked() ? "horizontal" : "vertical");
		
		for (Panel p : org.zkoss.zk.ui.select.Selectors.find(pl, "panel")) {
			p.setStyle(pl.isVertical() ? "margin-bottom:10px" : "margin-right: 10px");
		}
		
		if (pl.isVertical()) {
			pl.firstChild.setWidth("40%");
			pl.firstChild.setHeight("");
			pl.lastChild.setWidth("50%");
			pl.lastChild.setHeight("");
		} else {
			pl.firstChild.setHeight("40%");
			pl.firstChild.setWidth("");
			pl.lastChild.setHeight("50%");
			pl.lastChild.setWidth("");
		}
		
		</attribute>
	</checkbox>
	</hlayout>
	<portallayout id="pl" vflex="1" maximizedMode="whole">
		<portalchildren style="padding: 5px" width="40%">
			<panel width="300px" height="300px" title="Google Tools" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
				<panelchildren>
					Panel 1
				</panelchildren>
			</panel>
			<panel width="300px" height="300px" title="LabPixies Clock" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
				<panelchildren>
					Panel 2
				</panelchildren>
			</panel>
		</portalchildren>
		
		<portalchildren style="padding: 5px" width="50%">
			<panel height="300px" title="Trio" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
				<panelchildren>
					Panel 3
				</panelchildren>
			</panel>
		</portalchildren>
	</portallayout>
	</vlayout>
</zk>
"""
    runZTL(zscript,
      () => {
        verifyImage()
        
        click(jq(".z-checkbox"))
        waitResponse()
        verifyImage()
        
        val position = "2,2"
        val src = jq(".z-panel:contains(Panel 1)")
        val target = jq(".z-panel:contains(Panel 2)")
        
        mouseMoveAt(src, position)
        waitResponse()

        mouseDownAt(src, position)
        waitResponse()

        mouseMoveAt(target, position)
        waitResponse()

        mouseUpAt(target, position)
        waitResponse()
        
        verifyImage()
        
      })

  }
}