package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-2869.zul")
class B80_ZK_2869Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B80-ZK-2869.zul

	Purpose:
		
	Description:
		
	History:
		Fri Sep 11 09:44:37 CST 2015, Created by jumperchen

Copyright (C) 2015 Potix Corporation. All Rights Reserved.

-->
<zk xmlns:x="xhtml">
    <label multiline="true">
        Click both "fails" and "works" buttons, you should be able to see a message "CONTENT" being rendered in red and green border.
    </label>
    <div apply="org.zkoss.bind.BindComposer">
        <button id="trigger" label="fails"/>
        <button id="trigger2" label="works"/>

        <div fulfill="trigger.onClick" style="border: 1px solid red">
            <apply template="mainContent" templateName="contentTemplateFails"/>
        </div>

        <div fulfill="trigger2.onClick" style="border: 1px solid green">
            <apply template="mainContent" templateName="contentTemplateWorks"/>
        </div>

        <template name="mainContent">
            <div>
                <apply template="@load(templateName)" />
            </div>
        </template>

        <template name="contentTemplateFails">
            <x:div id="abc"><!-- PROBLEM with x:div -->
                <apply template="content"/>
            </x:div>
        </template>

        <template name="contentTemplateWorks">
            <div><!-- works with div -->
                <apply template="content"/>
            </div>
        </template>

        <template name="content">
            CONTENT
        </template>
    </div>
</zk>

""" 
  runZTL(zscript,
    () => {
      //click the fail button
      click(jq("button").eq(0))
      waitResponse()
      //check that message exists in the 1st label
      verifyEquals("\n            CONTENT\n        ", jq(".z-div .z-label").eq(0).text())
      //click the works button
      click(jq("button").eq(1))
      waitResponse()
      //check that message exists in the both label
      verifyEquals("\n            CONTENT\n        ", jq(".z-div .z-label").eq(0).text())
      verifyEquals("\n            CONTENT\n        ", jq(".z-div .z-label").eq(1).text())
    })
  }
}