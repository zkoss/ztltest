package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2146.zul")
class B70_ZK_2146Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2146.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Apr 15, 2014  2:49:05 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
Please click the "Toggle Status" to see the first three buttons should display as its enabled status.
    <window vflex="true" border="normal">
        <tabbox vflex="true">
            <tabs>
                <tab id="msg" label="Result: Disabled"/>
            </tabs>
            <tabpanels>
                <tabpanel>
                    <toolbar>
                    <button label="Toggle" id="mybtn" disabled="true"/>
                        <combobutton id="mycb" label="My" mold="toolbar" disabled="true">

                            <menupopup>
                                <menuitem label="123"/>
                            </menupopup>

                        </combobutton>
                        <toolbarbutton id="myph" label="Placeholder" disabled="true"/>

                        <toolbarbutton label="Toggle Status">
                        	<attribute name="onClick">
                        	mybtn.setDisabled(!mybtn.isDisabled());
                        	mycb.setDisabled(!mycb.isDisabled());
                        	myph.setDisabled(mycb.isDisabled());
                        	 msg.setLabel("Result: " + (mycb.isDisabled() ? "Disabled" : "Non-Disabled")); 
                        	</attribute>
                        </toolbarbutton>
                    </toolbar>
                </tabpanel>
            </tabpanels>
        </tabbox>
    </window>
</zk>
"""  
  runZTL(zscript,
    () => {
      click(jq(".z-toolbarbutton:contains(Toggle)"))
      waitResponse()
      verifyImage()
    })
    
  }
}