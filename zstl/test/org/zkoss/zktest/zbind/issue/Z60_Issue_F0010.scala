/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.zbind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_Issue_F0010 extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = {
<window apply="org.zkoss.zktest.zbind.issue.F0010" xmlns:n="http://www.zkoss.org/2005/zk/native">
	<custom-attributes composerName="vm"/>
	<div>
	1.row1 values should all have '-toUi-cX' postfix <n:br/>
	2.change value of row2, will cause row1,row2 update, and value have -toBean-CX-toUI-Cx' postfix<n:br/>
	</div>
	<hbox>Row 1
		<label id="l0" value="@bind(vm.value0) @converter('converter0')" />
		<label id="l1" value="@bind(vm.value1) @converter(vm.converterPool.converter1)" />
		<label id="l2" value="@bind(vm.value2) @converter(vm.converter2)" />
	</hbox>
	<hbox>Row 2
		<textbox id="t0" value="@bind(vm.value0) @converter('converter0')" />
		<textbox id="t1" value="@bind(vm.value1) @converter(vm.converterPool.converter1)" />
		<textbox id="t2" value="@bind(vm.value2) @converter(vm.converter2)" />
	</hbox>
	<hbox>
		<button id="btn1" label="cmd1" onClick="@bind('cmd1')" />
		<button id="btn2" label="cmd2" onClick="@bind('cmd2')" />
		<button label="Dump" onClick="binder.getTracker().dump()" />
	</hbox>	
</window>
    }
    runZTL(zul, () => {
    	val l0 = engine $f "l0"
    	val l1 = engine $f "l1"
    	val l2 = engine $f "l2"
    	val t0 = engine $f "t0"
    	val t1 = engine $f "t1"
    	val t2 = engine $f "t2"
    	
    	ZKSeleneseTestCase.assertEquals("A-toUI-c0",l0)
    	ZKSeleneseTestCase.assertEquals("B-toUI-c1",l1)
    	ZKSeleneseTestCase.assertEquals("C-toUI-c2",l2)
    	ZKSeleneseTestCase.assertEquals("A-toUI-c0",t0)
    	ZKSeleneseTestCase.assertEquals("B-toUI-c1",t1)
    	ZKSeleneseTestCase.assertEquals("C-toUI-c2",t2)
//		Assert.assertEquals("A-toUI-c0",findWidget("$l0").getValue());
//		Assert.assertEquals("B-toUI-c1",findWidget("$l1").getValue());
//		Assert.assertEquals("C-toUI-c2",findWidget("$l2").getValue());
//		Assert.assertEquals("A-toUI-c0",findWidget("$t0").getValue());
//		Assert.assertEquals("B-toUI-c1",findWidget("$t1").getValue());
//		Assert.assertEquals("C-toUI-c2",findWidget("$t2").getValue());
		
    	`type`(t0, "I")
    	sendKeys(t0, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",l0)
    	ZKSeleneseTestCase.assertEquals("B-toUI-c1",l1)
    	ZKSeleneseTestCase.assertEquals("C-toUI-c2",l2)
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",t0)
    	ZKSeleneseTestCase.assertEquals("B-toUI-c1",t1)
    	ZKSeleneseTestCase.assertEquals("C-toUI-c2",t2)
//		findWidget("$t0").clear().keys("I").tab();
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
//		Assert.assertEquals("B-toUI-c1",findWidget("$l1").getValue());
//		Assert.assertEquals("C-toUI-c2",findWidget("$l2").getValue());
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
//		Assert.assertEquals("B-toUI-c1",findWidget("$t1").getValue());
//		Assert.assertEquals("C-toUI-c2",findWidget("$t2").getValue());
		
    	`type`(t1, "J")
    	sendKeys(t1, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",l0)
    	ZKSeleneseTestCase.assertEquals("J-toBean-c1-toUI-c1",l1)
    	ZKSeleneseTestCase.assertEquals("C-toUI-c2",l2)
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",t0)
    	ZKSeleneseTestCase.assertEquals("J-toBean-c1-toUI-c1",t1)
    	ZKSeleneseTestCase.assertEquals("C-toUI-c2",t2)    	
//		findWidget("$t1").clear().keys("J").tab();
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
//		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$l1").getValue());
//		Assert.assertEquals("C-toUI-c2",findWidget("$l2").getValue());
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
//		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$t1").getValue());
//		Assert.assertEquals("C-toUI-c2",findWidget("$t2").getValue());
		
    	`type`(t2, "K")
    	sendKeys(t2, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",l0)
    	ZKSeleneseTestCase.assertEquals("J-toBean-c1-toUI-c1",l1)
    	ZKSeleneseTestCase.assertEquals("K-toBean-c2-toUI-c2",l2)
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",t0)
    	ZKSeleneseTestCase.assertEquals("J-toBean-c1-toUI-c1",t1)
    	ZKSeleneseTestCase.assertEquals("K-toBean-c2-toUI-c2",t2)    	
//		findWidget("$t2").clear().keys("K").tab();
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
//		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$l1").getValue());
//		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
//		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$t1").getValue());
//		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());
		
		
    	`type`(t1, "X")
    	sendKeys(t1, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",l0)
    	ZKSeleneseTestCase.assertEquals("X-toBean-c1-toUI-c1",l1)
    	ZKSeleneseTestCase.assertEquals("K-toBean-c2-toUI-c2",l2)
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",t0)
    	ZKSeleneseTestCase.assertEquals("X-toBean-c1-toUI-c1",t1)
    	ZKSeleneseTestCase.assertEquals("K-toBean-c2-toUI-c2",t2)      	
		//test converter dependency
//		findWidget("$t1").clear().keys("X").tab();
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
//		Assert.assertEquals("X-toBean-c1-toUI-c1",findWidget("$l1").getValue());
//		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
//		Assert.assertEquals("X-toBean-c1-toUI-c1",findWidget("$t1").getValue());
//		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());
		
    	click(engine $f "btn1")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",l0)
    	ZKSeleneseTestCase.assertEquals("X-toBean-c1-toUI-c3",l1)
    	ZKSeleneseTestCase.assertEquals("K-toBean-c2-toUI-c2",l2)
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",t0)
    	ZKSeleneseTestCase.assertEquals("X-toBean-c1-toUI-c3",t1)
    	ZKSeleneseTestCase.assertEquals("K-toBean-c2-toUI-c2",t2)    	
//    	findWidget("$btn1").click();
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
//		Assert.assertEquals("X-toBean-c1-toUI-c3",findWidget("$l1").getValue());
//		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
//		Assert.assertEquals("X-toBean-c1-toUI-c3",findWidget("$t1").getValue());
//		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());
		
    	`type`(t1, "X")
    	sendKeys(t1, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",l0)
    	ZKSeleneseTestCase.assertEquals("X-toBean-c3-toUI-c3",l1)
    	ZKSeleneseTestCase.assertEquals("K-toBean-c2-toUI-c2",l2)
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",t0)
    	ZKSeleneseTestCase.assertEquals("X-toBean-c3-toUI-c3",t1)
    	ZKSeleneseTestCase.assertEquals("K-toBean-c2-toUI-c2",t2) 
//		findWidget("$t1").clear().keys("X").tab();
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
//		Assert.assertEquals("X-toBean-c3-toUI-c3",findWidget("$l1").getValue());//
//		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
//		Assert.assertEquals("X-toBean-c3-toUI-c3",findWidget("$t1").getValue());//
//		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());
    	
    	click(engine $f "btn1")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",l0)
    	ZKSeleneseTestCase.assertEquals("X-toBean-c3-toUI-c4",l1)
    	ZKSeleneseTestCase.assertEquals("K-toBean-c2-toUI-c2",l2)
    	ZKSeleneseTestCase.assertEquals("I-toBean-c0-toUI-c0",t0)
    	ZKSeleneseTestCase.assertEquals("X-toBean-c3-toUI-c4",t1)
    	ZKSeleneseTestCase.assertEquals("K-toBean-c2-toUI-c2",t2) 
//		findWidget("$btn2").click();
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
//		Assert.assertEquals("X-toBean-c3-toUI-c4",findWidget("$l1").getValue());//
//		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
//		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
//		Assert.assertEquals("X-toBean-c3-toUI-c4",findWidget("$t1").getValue());//
//		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());
    })
  }
}
