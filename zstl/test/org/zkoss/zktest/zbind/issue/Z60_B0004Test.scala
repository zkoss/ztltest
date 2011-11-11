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
class Z60_B0004Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = {
<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
	<window apply="org.zkoss.bind.BindComposer" viewModel="@bind(vm='org.zkoss.zktest.zbind.issue.B0004')">
		<div>
			1.value 1 have to large than 10, <n:br/>
			2.value 2 have to large than 20, <n:br/> 
			3.value 2 have to large than value 1 <n:br/>
		</div>
		<hbox>
			<hbox>Value1:<label id="l11" value="@bind(vm.value1)"></label></hbox>
			<hbox>Value2:<label id="l12" value="@bind(vm.value2)"></label></hbox>
		</hbox>	
		<hbox id="h1" self="@form(id='fx',load=vm, save=vm before 'cmd1') @validator(vm.validator3)">
			Form
			Value1:<textbox id="t21" value="@bind(fx.value1) @validator(vm.validator1)" />
			Value2:<textbox id="t22" value="@bind(fx.value2) @validator(vm.validator2)" />
		</hbox>
		<vbox>
			<label id="msg1" value="@bind(vm.lastMessage1)"></label>
			<label id="msg2" value="@bind(vm.lastMessage2)"></label>
			<label id="msg3" value="@bind(vm.lastMessage3)"></label>
		</vbox>
	
		<hbox>
			<button id="btn1" label="cmd1" onClick="@bind('cmd1')"/>
		</hbox>
		
		extra test :
		<hbox>
			<button label="detach t22" onClick="t22.detach()"/>
			<button label="detach h1" onClick="h1.detach()"/>
		</hbox>
	</window>
</zk>
    }
    runZTL(zul, () => {
    	val l11 = engine $f "l11"
    	val l12 = engine $f "l12"
    	val msg1 = engine $f "msg1"
    	val msg2 = engine $f "msg2"
    	val msg3 = engine $f "msg3"
    	
    	ZKSeleneseTestCase.assertEquals("0", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("", getText(msg2));
    	ZKSeleneseTestCase.assertEquals("", getText(msg3));
    	
//		Assert.assertEquals("0",findWidget("$l11").getText());
//		Assert.assertEquals("",findWidget("$l12").getText());
//		Assert.assertEquals("",findWidget("$msg1").getText());
//		Assert.assertEquals("",findWidget("$msg2").getText());
//		Assert.assertEquals("",findWidget("$msg3").getText());
		
    	click(engine $f "btn1")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("0", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("value 1 have to large than 10", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("", getText(msg2));
    	ZKSeleneseTestCase.assertEquals("", getText(msg3));    	
//		findWidget("$btn1").click();
//		Assert.assertEquals("0",findWidget("$l11").getText());
//		Assert.assertEquals("",findWidget("$l12").getText());
//		Assert.assertEquals("value 1 have to large than 10",findWidget("$msg1").getText());
//		Assert.assertEquals("",findWidget("$msg2").getText());
//		Assert.assertEquals("",findWidget("$msg3").getText());
		
		val t21 = engine $f "t21"
    	`type`(t21, "32")
    	sendKeys(t21, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("0", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("", getText(msg2));
    	ZKSeleneseTestCase.assertEquals("", getText(msg3));    	
//		findWidget("$t21").clear().keys("32").tab();
//		Assert.assertEquals("0",findWidget("$l11").getText());
//		Assert.assertEquals("",findWidget("$l12").getText());
//		Assert.assertEquals("",findWidget("$msg1").getText());
//		Assert.assertEquals("",findWidget("$msg2").getText());
//		Assert.assertEquals("",findWidget("$msg3").getText());
		
		click(engine $f "btn1")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("0", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("value 2 is not valid For input string: \"\"", getText(msg2));
    	ZKSeleneseTestCase.assertEquals("", getText(msg3));  		
//    	findWidget("$btn1").click();
//		Assert.assertEquals("0",findWidget("$l11").getText());
//		Assert.assertEquals("",findWidget("$l12").getText());
//		Assert.assertEquals("",findWidget("$msg1").getText());
//		Assert.assertEquals("value 2 is not valid For input string: \"\"",findWidget("$msg2").getText());
//		Assert.assertEquals("",findWidget("$msg3").getText());
		
		val t22 = engine $f "t22"
    	`type`(t22, "13")
    	sendKeys(t22, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("0", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("value 2 have to large than 20", getText(msg2));
    	ZKSeleneseTestCase.assertEquals("", getText(msg3));      	
//		findWidget("$t22").clear().keys("13").tab();
//		Assert.assertEquals("0",findWidget("$l11").getText());
//		Assert.assertEquals("",findWidget("$l12").getText());
//		Assert.assertEquals("",findWidget("$msg1").getText());
//		Assert.assertEquals("value 2 have to large than 20",findWidget("$msg2").getText());
//		Assert.assertEquals("",findWidget("$msg3").getText());
		
    	`type`(t22, "22")
    	sendKeys(t22, Keys.TAB)
    	waitResponse()    
    	ZKSeleneseTestCase.assertEquals("0", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("", getText(msg2));
    	ZKSeleneseTestCase.assertEquals("", getText(msg3));      	
//		findWidget("$t22").clear().keys("22").tab();
//		Assert.assertEquals("0",findWidget("$l11").getText());
//		Assert.assertEquals("",findWidget("$l12").getText());
//		Assert.assertEquals("",findWidget("$msg1").getText());
//		Assert.assertEquals("",findWidget("$msg2").getText());
//		Assert.assertEquals("",findWidget("$msg3").getText());
		
		click(engine $f "btn1")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("0", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("value 2 have to large than value 1", getText(msg2));
    	ZKSeleneseTestCase.assertEquals("", getText(msg3));  			
//    	findWidget("$btn1").click();
//		Assert.assertEquals("0",findWidget("$l11").getText());
//		Assert.assertEquals("",findWidget("$l12").getText());
//		Assert.assertEquals("",findWidget("$msg1").getText());
//		Assert.assertEquals("value 2 have to large than value 1",findWidget("$msg2").getText());
//		Assert.assertEquals("",findWidget("$msg3").getText());
		
    	`type`(t22, "42")
    	sendKeys(t22, Keys.TAB)
    	waitResponse()    
    	ZKSeleneseTestCase.assertEquals("0", getText(l11));
    	ZKSeleneseTestCase.assertEquals("", getText(l12));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("", getText(msg2));
    	ZKSeleneseTestCase.assertEquals("", getText(msg3));  
//    	findWidget("$t22").clear().keys("42").tab();
//		Assert.assertEquals("0",findWidget("$l11").getText());
//		Assert.assertEquals("",findWidget("$l12").getText());
//		Assert.assertEquals("",findWidget("$msg1").getText());
//		Assert.assertEquals("",findWidget("$msg2").getText());
//		Assert.assertEquals("",findWidget("$msg3").getText());
		
		click(engine $f "btn1")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("32", getText(l11));
    	ZKSeleneseTestCase.assertEquals("42", getText(l12));
    	ZKSeleneseTestCase.assertEquals("", getText(msg1));
    	ZKSeleneseTestCase.assertEquals("value 2 have to large than value 1", getText(msg2));
    	ZKSeleneseTestCase.assertEquals("execute command 1", getText(msg3));  				
//		findWidget("$btn1").click();
//		Assert.assertEquals("32",findWidget("$l11").getText());
//		Assert.assertEquals("42",findWidget("$l12").getText());
//		Assert.assertEquals("",findWidget("$msg1").getText());
//		Assert.assertEquals("",findWidget("$msg2").getText());
//		Assert.assertEquals("execute command 1",findWidget("$msg3").getText());      
    })
  }
}
