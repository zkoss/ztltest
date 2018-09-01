package org.zkoss.zktest.test2.F65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F65-ZK-1351.zul")
class F65_ZK_1351Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
F65-ZK-1351.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Sep 20, 2012  3:07:28 PM, Created by jumperchen

Copyright (C) 2012 Potix Corporation. All Rights Reserved.

-->
<zk>
	<button label="ZK-1351 Feature: Support Messagebox without Buttons">
		<attribute name="onClick"><![CDATA[
			Messagebox.show("You should see no buttons with the dialog!", 
			    "Question", new Messagebox.Button[0],
			    Messagebox.QUESTION,
			        new org.zkoss.zk.ui.event.EventListener(){
			            public void onEvent(Event e){
			                if(Messagebox.ON_OK.equals(e.getName())){
			                    //OK is clicked
			                }else if(Messagebox.ON_CANCEL.equals(e.getName())){
			                    //Cancel is clicked
			                }
			            }
			        }
			    );
		]]></attribute>
	</button>
</zk>
"""
    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(ZK-1351)"))
        waitResponse()
        verifyFalse("You should see no buttons with the dialog", jq(".z-messagebox-window .z-button").exists)
      })

  }
}