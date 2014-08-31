package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-2076.zul")
class F70_ZK_2076Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?page title="F70-ZK-2049" contentType="text/html;charset=UTF-8"?>
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
		<button id="clean" label="clean" />
	</div>
</window>
"""  
  runZTL(zscript,
    () => {
      val t1 = jq("$t1");
      val t2 = jq("$t2");
      
      clickAt(jq("$b1"), "1,1");
      waitResponse();
      verifyTrue(t1.eval("val()").equals("test1"));
      verifyTrue(t2.eval("val()").equals(""));
      clickAt(jq("$clean"), "1,1");
      waitResponse();
      
      clickAt(jq("$b2"), "1,1");
      waitResponse();
      verifyTrue(t1.eval("val()").equals("test1"));
      verifyTrue(t2.eval("val()").equals("test2"));
      clickAt(jq("$clean"), "1,1");
      waitResponse();
      
      clickAt(jq("$b3"), "1,1");
      waitResponse();
      verifyTrue(t1.eval("val()").equals("test1"));
      verifyTrue(t2.eval("val()").equals("test3"));
      clickAt(jq("$clean"), "1,1");
      waitResponse();
      
      clickAt(jq("$b4"), "1,1");
      waitResponse();
      verifyTrue(t1.eval("val()").equals("test1"));
      verifyTrue(t2.eval("val()").equals("test4"));
      clickAt(jq("$clean"), "1,1");
      waitResponse();
      
      clickAt(jq("$b5"), "1,1");
      waitResponse();
      verifyTrue(t1.eval("val()").equals("test1"));
      verifyTrue(t2.eval("val()").equals(""));
    })
    
  }
}