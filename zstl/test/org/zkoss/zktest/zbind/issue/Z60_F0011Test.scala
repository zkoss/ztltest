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
class Z60_F0011Test extends ZTL4ScalaTestCase {
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
		val sdf = new SimpleDateFormat("yyyy/MM/dd");
		var now = new Date()
		val today = sdf.format(now).toString();
		val yesterday = sdf.format(new Date(now.getTime()-1000*60*60*24)).toString();
		val tomorrow = sdf.format(new Date(now.getTime()+1000*60*60*24));
		
		val db1 = engine $f "db1"
    	val lb11 = engine $f "lb11"
    	val lb12 = engine $f "lb12"
		//validate date1
		ZKSeleneseTestCase.assertEquals(today, getValue(db1.$n("real")))
		ZKSeleneseTestCase.assertEquals(today, getText(lb11))
		ZKSeleneseTestCase.assertEquals("", getText(lb12))
		
//		Assert.assertEquals(today,findWidget("$db1").getText());
//		Assert.assertEquals(today,findWidget("$lb11").getValue());
//		Assert.assertEquals("",findWidget("$lb12").getValue());
		
		`type`(db1.$n("real"), tomorrow)
    	waitResponse()
		ZKSeleneseTestCase.assertEquals(tomorrow, getValue(db1.$n("real")))
		ZKSeleneseTestCase.assertEquals(today, getText(lb11))
		ZKSeleneseTestCase.assertEquals("date bday1 must small than today", getText(lb12))    	
//		findWidget("$db1").clear().keys(tomorrow).tab();
//		Assert.assertEquals(tomorrow,findWidget("$db1").getText());
//		Assert.assertEquals(today,findWidget("$lb11").getValue());
//		Assert.assertEquals("date bday1 must small than today",findWidget("$lb12").getValue());
		`type`(db1.$n("real"), yesterday)
    	waitResponse()
		ZKSeleneseTestCase.assertEquals(yesterday, getValue(db1.$n("real")))
		ZKSeleneseTestCase.assertEquals(yesterday, getText(lb11))
		ZKSeleneseTestCase.assertEquals("", getText(lb12))    		
//		findWidget("$db1").clear().keys(yesterday).tab();
//		Assert.assertEquals(yesterday,findWidget("$db1").getText());
//		Assert.assertEquals(yesterday,findWidget("$lb11").getValue());
//		Assert.assertEquals("",findWidget("$lb12").getValue());
		//validate date2
		val db2 = engine $f "db2"
    	val lb21 = engine $f "lb21"
    	val lb22 = engine $f "lb22"
		ZKSeleneseTestCase.assertEquals("", getValue(db2.$n("real")))
		ZKSeleneseTestCase.assertEquals("", getText(lb21))
		ZKSeleneseTestCase.assertEquals("", getText(lb22))      	
//		Assert.assertEquals("",findWidget("$db2").getText());
//		Assert.assertEquals("",findWidget("$lb21").getValue());
//		Assert.assertEquals("",findWidget("$lb22").getValue());
		
		`type`(db2.$n("real"), yesterday)
    	waitResponse()
		ZKSeleneseTestCase.assertEquals(yesterday, getValue(db2.$n("real")))
		ZKSeleneseTestCase.assertEquals("", getText(lb21))
		ZKSeleneseTestCase.assertEquals("date bday2 must large than today", getText(lb22))
//		findWidget("$db2").clear().keys(yesterday).tab();
//		Assert.assertEquals(yesterday,findWidget("$db2").getText());
//		Assert.assertEquals("",findWidget("$lb21").getValue());
//		Assert.assertEquals("date bday2 must large than today",findWidget("$lb22").getValue());

		`type`(db2.$n("real"), tomorrow)
    	waitResponse()
		ZKSeleneseTestCase.assertEquals(tomorrow, getValue(db2.$n("real")))
		ZKSeleneseTestCase.assertEquals(tomorrow, getText(lb21))
		ZKSeleneseTestCase.assertEquals("", getText(lb22))
//		findWidget("$db2").clear().keys(tomorrow).tab();
//		Assert.assertEquals(tomorrow,findWidget("$db2").getText());
//		Assert.assertEquals(tomorrow,findWidget("$lb21").getValue());
//		Assert.assertEquals("",findWidget("$lb22").getValue());
    })
  }
}
