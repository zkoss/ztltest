package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1617.zul")
class B65_ZK_1617Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1617.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Feb 08, 2013 10:02:33 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<div>
	<label multiline="true">
		1. Please click the 'Rename' button.
		2. Try to drag the title of the panel, and it should be able to drag and drop.
	</label>
    <button id="btn" label="Rename" onClick="onClick()"/>
    <portallayout>
        <portalchildren>
            <panel id="panel" title="Change Me" border="normal">
                <panelchildren>
                    <div style="display:block;" width="400px" height="300px"/>
                </panelchildren>
            </panel>
        </portalchildren>
    </portallayout>
    <zscript>
        public void onClick() {
            panel.setTitle("Change Title");
        }
    </zscript>
</div>"""
    runZTL(zscript,
      () => {
        val btn = jq(".z-button:contains(Rename)")
        click(btn)
        waitResponse()
        
        val position = "2,2"
        val src = jq(".z-panel-header")
        
        val top = src.offsetTop()
        
        mouseMoveAt(src, position)
        waitResponse

        mouseDownAt(src, position)
        waitResponse

        mouseMoveAt(btn, position)
        waitResponse
        
        verifyTrue("it should be able to drag and drop.", top != src.offsetTop())
        
        mouseUpAt(btn, position)
        waitResponse
        
        
      })

  }
}