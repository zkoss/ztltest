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
class Z60_F0002Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = {
<window apply="org.zkoss.zktest.zbind.issue.F0002" xmlns:n="http://www.zkoss.org/2005/zk/native">
	<custom-attributes composerName="vm"/>
	<div>
	1.Change row'1 value will only change value of label in row2 <n:br/>
	2.Change row'2 value will not change value of label in row2, but it changed after click cmd1,
	After click cmd1, row1's value also change<n:br/>
	3.Change row'2 value will not change value of label in row3,  but it changed after click cmd2
	</div>
	<hbox>Row 1
		<textbox id="tb1" value="@bind(vm.value1)"/>
		<label id="l1" value="@bind(vm.value1)" />
	</hbox>
	<hbox>Row 2
		<textbox id="tb2" value="@bind(init=vm.value1,save=vm.value1 before 'cmd1')"/>
		<label id="l2" value="@bind(init=vm.value1,load=vm.value1 after 'cmd1')" />
	</hbox>
	<hbox self="@form(id='fx', init=vm.form1, load=vm, save=vm after 'cmd2')">
		Row 3
		<textbox id="tb3" value="@bind(fx.value2)"/>
		<label id="l31" value="@bind(vm.value2)" />
		<label id="l32" value="@bind(vm.formValue2)" />
	</hbox>
	<hbox>
		<button id="btn1" label="cmd1" onClick="@bind('cmd1')" />
		<button id="btn2" label="cmd2" onClick="@bind('cmd2')" />
		<button label="Dump" onClick="binder.getTracker().dump()" />
	</hbox>	
</window>
    }
    runZTL(zul, () => {
		//test property init
    	val tb1 = engine $f "tb1"
    	val l1 = engine $f "l1"
    	val tb2 = engine $f "tb2"
    	val l2 = engine $f "l2"
    	
    	ZKSeleneseTestCase.assertEquals("A", getValue(tb1));
    	ZKSeleneseTestCase.assertEquals("A", getText(l1));
    	ZKSeleneseTestCase.assertEquals("A", getValue(tb2));
    	ZKSeleneseTestCase.assertEquals("A", getText(l2));
    	
//		Assert.assertEquals("A",findWidget("$tb1").getValue());
//		Assert.assertEquals("A",findWidget("$l1").getValue());
//		Assert.assertEquals("A",findWidget("$tb2").getValue());
//		Assert.assertEquals("A",findWidget("$l2").getValue());
		
    	`type`(tb1, "XX")
    	sendKeys(tb1, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("XX", getValue(tb1));
    	ZKSeleneseTestCase.assertEquals("XX", getText(l1));
    	ZKSeleneseTestCase.assertEquals("A", getValue(tb2));
    	ZKSeleneseTestCase.assertEquals("A", getText(l2));    	
//		findWidget("$tb1").clear().keys("XX").tab();
//		Assert.assertEquals("XX",findWidget("$tb1").getValue());
//		Assert.assertEquals("XX",findWidget("$l1").getValue());
//		Assert.assertEquals("A",findWidget("$tb2").getValue());
//		Assert.assertEquals("A",findWidget("$l2").getValue());

    	`type`(tb2, "YY")
    	sendKeys(tb2, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("XX", getValue(tb1));
    	ZKSeleneseTestCase.assertEquals("XX", getText(l1));
    	ZKSeleneseTestCase.assertEquals("YY", getValue(tb2));
    	ZKSeleneseTestCase.assertEquals("A", getText(l2));    	
//		findWidget("$tb2").clear().keys("YY").tab();
//		Assert.assertEquals("XX",findWidget("$tb1").getValue());
//		Assert.assertEquals("XX",findWidget("$l1").getValue());
//		Assert.assertEquals("YY",findWidget("$tb2").getValue());
//		Assert.assertEquals("A",findWidget("$l2").getValue());
		
    	click(engine $f "btn1")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("YY", getValue(tb1));
    	ZKSeleneseTestCase.assertEquals("YY", getText(l1));
    	ZKSeleneseTestCase.assertEquals("YY", getValue(tb2));
    	ZKSeleneseTestCase.assertEquals("YY", getText(l2));       	
//		findWidget("$btn1").click();
//		Assert.assertEquals("YY",findWidget("$tb1").getValue());
//		Assert.assertEquals("YY",findWidget("$l1").getValue());
//		Assert.assertEquals("YY",findWidget("$tb2").getValue());
//		Assert.assertEquals("YY",findWidget("$l2").getValue());
		
		//test form init
    	val tb3 = engine $f "tb3"
    	val l31 = engine $f "l31"
    	val l32 = engine $f "l32"
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("B", getValue(tb3));
    	ZKSeleneseTestCase.assertEquals("B", getText(l31));
    	ZKSeleneseTestCase.assertEquals("B", getText(l32));    	
//		Assert.assertEquals("B",findWidget("$tb3").getValue());
//		Assert.assertEquals("B",findWidget("$l31").getValue());
//		Assert.assertEquals("B",findWidget("$l32").getValue());
		
    	`type`(tb3, "ZZ")
    	sendKeys(tb3, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("ZZ", getValue(tb3));
    	ZKSeleneseTestCase.assertEquals("B", getText(l31));
    	ZKSeleneseTestCase.assertEquals("B", getText(l32));    	
//		findWidget("$tb3").clear().keys("ZZ").tab();
//		Assert.assertEquals("ZZ",findWidget("$tb3").getValue());
//		Assert.assertEquals("B",findWidget("$l31").getValue());
//		Assert.assertEquals("B",findWidget("$l32").getValue());
		
    	click(engine $f "btn2")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("ZZ", getValue(tb3));
    	ZKSeleneseTestCase.assertEquals("ZZ", getText(l31));
    	ZKSeleneseTestCase.assertEquals("ZZ", getText(l32));     	
//		findWidget("$btn2").click();
//		Assert.assertEquals("ZZ",findWidget("$tb3").getValue());
//		Assert.assertEquals("ZZ",findWidget("$l31").getValue());
//		Assert.assertEquals("ZZ",findWidget("$l32").getValue());
		
    })
  }
}
