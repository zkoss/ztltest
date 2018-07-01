package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2810.zul")
class B70_ZK_2810Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2810.zul

	Purpose:
		
	Description:
		
	History:
		Wed Jul  8 10:59:41 CST 2015, Created by chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<div>
	<label multiline="true">
	1. switch between each tab
	2. the height of tabpanel should adjust with the content
	</label>
    <tabbox orient="left" width="300px">
        <tabs width="100px">
            <tab label="Tab short" />
            <tab label="Tab long" />
            <tab label="Tab even longer" />
        </tabs>
        <tabpanels>
            <tabpanel>
            	<div height="200px" style="background-color: red;"/>
            </tabpanel>
            <tabpanel>
            	<div height="400px" style="background-color: green;"/>
            </tabpanel>
            <tabpanel>
            	<div height="600px" style="background-color: blue;"/>
            </tabpanel>
        </tabpanels>
    </tabbox>
</div>

"""
    runZTL(zscript,
      () => {
        //init state, check 1st tabpanel have the same height as its content
        verifyEquals(jq(".z-tabpanel").eq(0).height(), jq(".z-tabpanel > .z-div").eq(0).height());
        println(jq(".z-tabpanel").eq(0).height());
        //switch to 2nd tab
        click(jq(".z-tab").eq(1))
        waitResponse()
        //check 2nd tabpanel have the same height as its content
        verifyEquals(jq(".z-tabpanel").eq(1).height(), jq(".z-tabpanel > .z-div").eq(1).height());
        println(jq(".z-tabpanel").eq(1).height());
        //switch to 3rd tab
        click(jq(".z-tab").eq(2))
        waitResponse()
        //check 3rd tabpanel have the same height as its content
        verifyEquals(jq(".z-tabpanel").eq(2).height(), jq(".z-tabpanel > .z-div").eq(2).height());
        println(jq(".z-tabpanel").eq(2).height());
        //switch back to 1st tab
        click(jq(".z-tab").eq(0))
        waitResponse()
        //check 1st tabpanel have the same height as its content
        verifyEquals(jq(".z-tabpanel").eq(0).height(), jq(".z-tabpanel > .z-div").eq(0).height());
        println(jq(".z-tabpanel").eq(0).height());
      })
  }
}