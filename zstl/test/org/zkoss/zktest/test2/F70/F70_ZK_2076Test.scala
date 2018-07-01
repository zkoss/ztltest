package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F70-ZK-2076.zul")
class F70_ZK_2076Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>
<!--
F70-ZK-2076.zul

	Purpose:
		
	Description:
		
	History:
		Wed, June 19, 2014  5:56:04 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<window apply="org.zkoss.zktest.test2.F70_ZK_2076">
	<div>
		1. click each test with clean first. if text1 and text2 are not
		like expected result, that's a bug.
	</div>
	<div>
		text1:
		<textbox id="t1" />
	</div>
	<div>
		text2:
		<textbox id="t2" />
	</div>
	<div>
		<button id="b1" label="test1" />
		expceted:
			text1: [test1]
			text2: [] 
	</div>
	<div>
		<button id="b2" label="test2" />
		expceted:
			text1: [test1]
			text2: [test2] 
	</div>
	<div>
		<button id="b3" label="test3" />
		expceted:
			text1: [test1]
			text2: [test3] 
	</div>
	<div>
		<button id="b4" label="test4" />
		expceted:
			text1: [test1]
			text2: [test4] 
	</div>
	<div>
		<button id="b5" label="test5" />
		expceted:
			text1: [test1]
			text2: [] 
	</div>
	<div>
		<button id="b6" label="test6" />
		expceted:
			text1: [test1]
			text2: [test6] 
	</div>
	<div>
		<button id="clean" label="clean" />
	</div>
</window>
"""
    runZTL(zscript,
      () => {
        val t1 = jq("$t1");
        val t2 = jq("$t2");
        waitResponse(true);
        click(jq("$b1"));
        waitResponse();
        verifyEquals(t1.eval("val()"), "test1")
        verifyEquals(t2.eval("val()"), "")
        click(jq("$clean"));
        waitResponse();

        click(jq("$b2"));
        waitResponse();
        verifyEquals(t1.eval("val()"), "test1")
        verifyEquals(t2.eval("val()"), "test2")
        click(jq("$clean"));
        waitResponse();

        click(jq("$b3"));
        waitResponse();
        verifyEquals(t1.eval("val()"), "test1")
        verifyEquals(t2.eval("val()"), "test3")
        click(jq("$clean"));
        waitResponse();

        click(jq("$b4"));
        waitResponse();
        verifyEquals(t1.eval("val()"), "test1")
        verifyEquals(t2.eval("val()"), "test4")
        click(jq("$clean"));
        waitResponse();

        click(jq("$b5"));
        waitResponse();
        verifyEquals(t1.eval("val()"), "test1")
        verifyEquals(t2.eval("val()"), "")
        click(jq("$clean"));
        waitResponse();

        click(jq("$b6"));
        waitResponse();
        verifyEquals(t1.eval("val()"), "test1")
        verifyEquals(t2.eval("val()"), "test6")
      })

  }
}