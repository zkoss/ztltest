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
import java.text.SimpleDateFormat
import java.util.Date
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_Issue_F0011_1 extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = {
<window apply="org.zkoss.zktest.zbind.issue.F0011" xmlns:n="http://www.zkoss.org/2005/zk/native">
	<custom-attributes composerName="vm"/>
	<div>
	1.row 1 date have to not empty and small than today <n:br/>
	2.row 2 date could be empty and have to large than today<n:br/>
	3.row 3 string value of row3 have to equals, and could not empty, doValidate after cmd1<n:br/>
	4.row 4 string value of row4 have to equals, and could not empty, doValidate<n:br/>
	4.row 5 string value of row5 have to equals, value 1 could be empty, doValidate after cmd3<n:br/>
	</div>
	<hbox>Row 1
		<datebox id="db1" value="@bind(vm.bday1) @validator('validator1', format='yyyy/MM/dd')"/>
		<label id="lb11" value="@bind(vm.bday1) @converter('formatedDate', format='yyyy/MM/dd')"/>
		<label id="lb12" value="@bind(vm.message1)"/>
	</hbox>
	<hbox>Row 2
		<datebox id="db2" value="@bind(vm.bday2) @validator(vm.validator2)" format="yyyy/MM/dd" />
		<label id="lb21" value="@bind(vm.bday2) @converter('formatedDate', format='yyyy/MM/dd')"/>
		<label id="lb22" value="@bind(vm.message2)"/>
	</hbox>
	<hbox>Row 3 <div/>
		Pass1<textbox id="tb31" value="@bind(vm.value1, save=vm.value1 before 'cmd1') @validator('validator31')" />
		Pass2<textbox id="tb32" value="@bind(vm.value2, save=vm.value2 before 'cmd1') @validator('validator32')" />
		<label id="lb31" value="@bind(vm.value2)"/>
		<label id="lb32" value="@bind(vm.message3)"/>
	</hbox>
	<hbox self="@form(id='fx', vm, save=vm before 'cmd2') @validator('validator4')">Row 4 <div/>
		Pass3<textbox id="tb41" value="@bind(fx.value3) @validator('validator41')" />
		Pass4<textbox id="tb42" value="@bind(fx.value4) @validator('validator41')" />
		<label id="lb41" value="@bind(vm.value4)"/>
		<label id="lb42" value="@bind(vm.message4)"/>
	</hbox>
	<hbox>Row 5<div/>
		Pass1<textbox id="tb51" value="@bind(vm.value1, save=vm.value1 before 'cmd3')" />
		Pass2<textbox id="tb52" value="@bind(vm.value2, save=vm.value2 before 'cmd3') @validator('validator5')" />
		<label id="lb51" value="@bind(vm.value2)"/>
		<label id="lb52" value="@bind(vm.message5)"/>
	</hbox>	
	<hbox>
		<button id="btn1" label="cmd1" onClick="@bind('cmd1')" />
		<button id="btn2" label="cmd2" onClick="@bind('cmd2')" />
		<button id="btn3" label="cmd3" onClick="@bind('cmd3')" />
		<button label="Dump" onClick="binder.getTracker().dump()" />
	</hbox>	
</window>
    }
    runZTL(zul, () => {
		val tb31 = engine $f "tb31"
    	val tb32 = engine $f "tb32"
    	val lb31 = engine $f "lb31"
    	val lb32 = engine $f "lb32"
		//validate property before command
		ZKSeleneseTestCase.assertEquals("",getValue(tb31))
		ZKSeleneseTestCase.assertEquals("",getValue(tb32))
		ZKSeleneseTestCase.assertEquals("",getText(lb31))
		ZKSeleneseTestCase.assertEquals("",getText(lb32))
//		Assert.assertEquals("",findWidget("$tb31").getValue());
//		Assert.assertEquals("",findWidget("$tb32").getValue());
//		Assert.assertEquals("",findWidget("$lb31").getValue());
//		Assert.assertEquals("",findWidget("$lb32").getValue());
		
		val btn1 = engine $f "btn1"
		click(btn1)
		waitResponse()
		ZKSeleneseTestCase.assertEquals("value1 is empty",getText(lb32))
//		findWidget("$btn1").click();
//		Assert.assertEquals("value1 is empty",findWidget("$lb32").getValue());
		
		`type`(tb31,"abc")
		waitResponse()
		ZKSeleneseTestCase.assertEquals("",getText(lb31))
		ZKSeleneseTestCase.assertEquals("value1 is empty",getText(lb32))		
//		findWidget("$tb31").keys("abc").tab();
//		Assert.assertEquals("",findWidget("$lb31").getValue());
//		Assert.assertEquals("value1 is empty",findWidget("$lb32").getValue());
		
		click(btn1)
		waitResponse()
		ZKSeleneseTestCase.assertEquals("value2 must euqlas to value 1",getText(lb32))
//		findWidget("$btn1").click();
//		Assert.assertEquals("value2 must euqlas to value 1",findWidget("$lb32").getValue());
		
		`type`(tb31,"abc")
		waitResponse()
		ZKSeleneseTestCase.assertEquals("",getText(lb31))
		ZKSeleneseTestCase.assertEquals("value2 must euqlas to value 1",getText(lb32))
//		findWidget("$tb32").keys("abc").tab();
//		Assert.assertEquals("",findWidget("$lb31").getValue());
//		Assert.assertEquals("value2 must euqlas to value 1",findWidget("$lb32").getValue());
		
		click(btn1)
		waitResponse()
		ZKSeleneseTestCase.assertEquals("abc",getText(lb31))
		ZKSeleneseTestCase.assertEquals("do Command1",getText(lb32))
//		findWidget("$btn1").click();
//		Assert.assertEquals("abc",findWidget("$lb31").getValue());
//		Assert.assertEquals("do Command1",findWidget("$lb32").getValue());      
      
    })
  }
}
