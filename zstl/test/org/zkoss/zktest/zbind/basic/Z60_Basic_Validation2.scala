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
package org.zkoss.zktest.zbind.basic

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_Basic_Validation2 extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = {//validation.zul
<window apply="org.zkoss.zktest.zbind.basic.ValidationComposer">
	<custom-attributes composerName="vm"/>
	<vbox>
		<hbox>Value1:<label id="l11" value="@bind(vm.value1)"></label></hbox>
		<hbox>Value2:<label id="l12" value="@bind(vm.value2)"></label></hbox>
	</vbox>	
	<hbox>
		Prompt:
		Value1:<textbox id="t21" value="@bind(vm.value1) @validator('validator1')" errorMessage="@bind(vm.lastMessage1)" />
		Value2:<textbox id="t22" value="@bind(vm.value2) @validator('validator2')" errorMessage="@bind(vm.lastMessage2)"/>
	</hbox>	
	<hbox>
		Command:
		Value1:<textbox id="t31" value="@bind(vm.value1, save=vm.value1 before 'cmd1') @validator('validator1')" />
		Value2:<textbox id="t32" value="@bind(vm.value2, save=vm.value2 before 'cmd1') @validator('validator2')" />
	</hbox>
	<hbox>
		<button id="btn1" label="cmd1" onClick="@bind('cmd1')"/>
	</hbox>	
	<vbox>
		<label id="msg1" value="@bind(vm.lastMessage1)"></label>
		<label id="msg2" value="@bind(vm.lastMessage2)"></label>
	</vbox>
</window>
    }
    runZTL(zul, () => {
    	val l11 = engine $f "l11"
    	val l12 = engine $f "l12"
    	val t21 = engine $f "t21"
    	val t22 = engine $f "t22"
    	val t31 = engine $f "t31"
    	val t32 = engine $f "t32"
    	val msg1 = engine $f "msg1"
    	val msg2 = engine $f "msg2"

    	ZKSeleneseTestCase.assertEquals("0", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("0", getValue(t21));
    	ZKSeleneseTestCase.assertEquals("", getValue(t22));
    	ZKSeleneseTestCase.assertEquals("0", getValue(t31));
    	ZKSeleneseTestCase.assertEquals("", getValue(t32));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("", getText(msg2));
//    	Assert.assertEquals("0",findWidget("$l11").getValue());
//		Assert.assertEquals("",findWidget("$l12").getValue());
//		Assert.assertEquals("0",findWidget("$t21").getValue());
//		Assert.assertEquals("",findWidget("$t22").getValue());
//		Assert.assertEquals("0",findWidget("$t31").getValue());
//		Assert.assertEquals("",findWidget("$t32").getValue());
//		Assert.assertEquals("",findWidget("$msg1").getValue());
//		Assert.assertEquals("",findWidget("$msg2").getValue());

    	`type`(t21, "1")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("0", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("1", getValue(t21));
    	ZKSeleneseTestCase.assertEquals("", getValue(t22));
    	ZKSeleneseTestCase.assertEquals("0", getValue(t31));
    	ZKSeleneseTestCase.assertEquals("", getValue(t32));
    	ZKSeleneseTestCase.assertEquals("value 1 have to large than 10", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("", getText(msg2));
//		findWidget("$t21").clear().keys("1").tab();
//		Assert.assertEquals("0",findWidget("$l11").getValue());
//		Assert.assertEquals("",findWidget("$l12").getValue());
//		Assert.assertEquals("1",findWidget("$t21").getValue());
//		Assert.assertEquals("",findWidget("$t22").getValue());
//		Assert.assertEquals("0",findWidget("$t31").getValue());
//		Assert.assertEquals("",findWidget("$t32").getValue());
//		Assert.assertEquals("value 1 have to large than 10",findWidget("$msg1").getValue());
//		Assert.assertEquals("",findWidget("$msg2").getValue());
		
    	`type`(t21, "12")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("12", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("12", getValue(t21));
    	ZKSeleneseTestCase.assertEquals("", getValue(t22));
    	ZKSeleneseTestCase.assertEquals("12", getValue(t31));
    	ZKSeleneseTestCase.assertEquals("", getValue(t32));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("", getText(msg2));    	
//		findWidget("$t21").clear().keys("12").tab();
//		Assert.assertEquals("12",findWidget("$l11").getValue());
//		Assert.assertEquals("",findWidget("$l12").getValue());
//		Assert.assertEquals("12",findWidget("$t21").getValue());
//		Assert.assertEquals("",findWidget("$t22").getValue());
//		Assert.assertEquals("12",findWidget("$t31").getValue());
//		Assert.assertEquals("",findWidget("$t32").getValue());
//		Assert.assertEquals("",findWidget("$msg1").getValue());
//		Assert.assertEquals("",findWidget("$msg2").getValue());
		
		
    	`type`(t22, "3")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("12", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("12", getValue(t21));
    	ZKSeleneseTestCase.assertEquals("3", getValue(t22));
    	ZKSeleneseTestCase.assertEquals("12", getValue(t31));
    	ZKSeleneseTestCase.assertEquals("", getValue(t32));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("value 2 have to large than 20", getText(msg2));
//		findWidget("$t22").clear().keys("3").tab();
//		Assert.assertEquals("12",findWidget("$l11").getValue());
//		Assert.assertEquals("",findWidget("$l12").getValue());
//		Assert.assertEquals("12",findWidget("$t21").getValue());
//		Assert.assertEquals("3",findWidget("$t22").getValue());
//		Assert.assertEquals("12",findWidget("$t31").getValue());
//		Assert.assertEquals("",findWidget("$t32").getValue());
//		Assert.assertEquals("",findWidget("$msg1").getValue());
//		Assert.assertEquals("value 2 have to large than 20",findWidget("$msg2").getValue());
		
		`type`(t22, "33")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("12", getText(l11));
    	ZKSeleneseTestCase.assertEquals("33", getText(l12));
    	ZKSeleneseTestCase.assertEquals("12", getValue(t21));
    	ZKSeleneseTestCase.assertEquals("33", getValue(t22));
    	ZKSeleneseTestCase.assertEquals("12", getValue(t31));
    	ZKSeleneseTestCase.assertEquals("33", getValue(t32));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("", getText(msg2));
//    	findWidget("$t22").clear().keys("33").tab();
//		Assert.assertEquals("12",findWidget("$l11").getValue());
//		Assert.assertEquals("33",findWidget("$l12").getValue());
//		Assert.assertEquals("12",findWidget("$t21").getValue());
//		Assert.assertEquals("33",findWidget("$t22").getValue());
//		Assert.assertEquals("12",findWidget("$t31").getValue());
//		Assert.assertEquals("33",findWidget("$t32").getValue());
//		Assert.assertEquals("",findWidget("$msg1").getValue());
//		Assert.assertEquals("",findWidget("$msg2").getValue());
    })
  }
}
