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
class Z60_Basic_VmInit extends ZTL4ScalaTestCase {
  def testBasic() = {
    //the following import tag is not XML format, hence can NOT put in val zul 
    val header = "<?init class=\"org.zkoss.zktest.zbind.basic.ViewModelInit\"?> \n" +
    			"<?import class=\"org.zkoss.bind.BindComposer\"?> \n"+
    			"<?import class=\"org.zkoss.zktest.zbind.basic.ViewModelInit$SubViewModel\"?>\n"
    val zul = {
<window>
	<vbox apply="BindComposer" viewModel="@bind(vm1=myvm1)" 
		composerName="@bind('vm')" queueName="@bind('myqueue1')" queueScope="@bind('desktop')" binderName="@bind('binder')">
		<label id="vm1_l1" value="@bind(vm1.name)" />
		<hbox>
			<textbox id="vm1_t1" value="@bind(vm1.value1) @converter(vm1.converter1)"/>
			<label id="vm1_l2" value="@bind(vm1.value1) @converter('converter1')"/>
		</hbox>
		<hbox>
			<label id="vm1_l3" value="@bind(vm1.value2)"/>
			<button id="vm1_btn" label="cmd1" onClick="@bind('cmd1')"/>	
		</hbox>
	</vbox>
	<vbox apply="BindComposer" viewModel="@bind(vm2=myvm2)" >
		<label id="vm2_l1" value="@bind(vm2.name)" />
		<hbox>
			<textbox id="vm2_t1" value="@bind(vm2.value1) @converter(vm2.converter1)"/>
			<label id="vm2_l2" value="@bind(vm2.value1) @converter('converter1')"/>
		</hbox>
		<hbox>
			<label id="vm2_l3" value="@bind(vm2.value2)"/>
			<button id="vm2_btn" label="cmd1" onClick="@bind('cmd1')"/>	
		</hbox>
		
		---Nested---
		<vbox apply="BindComposer" viewModel="@bind(vm3=myvm3)" >
			<label id="vm3_l1" value="@bind(vm3.name)" />
			<hbox>
				<textbox id="vm3_t1" value="@bind(vm3.value1) @converter(vm3.converter1)"/>
				<label id="vm3_l2" value="@bind(vm3.value1) @converter('converter1')"/>
			</hbox>
			<hbox>
				<label id="vm3_l3" value="@bind(vm3.value2)"/>
				<button id="vm3_btn" label="cmd1" onClick="@bind('cmd1')"/>	
			</hbox>
		</vbox>			
		---End Nested---
	</vbox>
	<vbox apply="BindComposer" viewModel="@bind(vm4='ViewModelInit$SubViewModel')" >
		<label id="vm4_l1" value="@bind(vm4.name)" />
		<hbox>
			<textbox id="vm4_t1" value="@bind(vm4.value1) @converter(vm4.converter1)"/>
			<label id="vm4_l2" value="@bind(vm4.value1) @converter('converter1')"/>
		</hbox>
		<hbox>
			<label id="vm4_l3" value="@bind(vm4.value2)"/>
			<button id="vm4_btn" label="cmd1" onClick="@bind('cmd1')"/>	
		</hbox>
	</vbox>		
</window>
    }
    runZTL(header+zul, () => {
    	val vm1_l1 = engine $f "vm1_l1"
    	val vm1_t1 = engine $f "vm1_t1"
    	val vm1_l2 = engine $f "vm1_l2"
    	val vm1_l3 = engine $f "vm1_l3"
    	
    	ZKSeleneseTestCase.assertEquals("AA", getText(vm1_l1));
    	ZKSeleneseTestCase.assertEquals("V1-AA", getValue(vm1_t1));
    	ZKSeleneseTestCase.assertEquals("V1-AA", getText(vm1_l2));
    	ZKSeleneseTestCase.assertEquals("V2", getText(vm1_l3));      
//      
//		Assert.assertEquals("AA",findWidget("$vm1_l1").getText());
//		Assert.assertEquals("V1-AA",findWidget("$vm1_t1").getText());
//		Assert.assertEquals("V1-AA",findWidget("$vm1_l2").getText());
//		Assert.assertEquals("V2",findWidget("$vm1_l3").getText());

    	`type`(vm1_t1, "OO")
    	sendKeys(vm1_t1, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("OO-AA", getValue(vm1_t1));
    	ZKSeleneseTestCase.assertEquals("OO-AA", getText(vm1_l2));
    	ZKSeleneseTestCase.assertEquals("V2", getText(vm1_l3));
		
//		findWidget("$vm1_t1").clear().keys("OO").tab();
//		Assert.assertEquals("OO-AA",findWidget("$vm1_t1").getText());
//		Assert.assertEquals("OO-AA",findWidget("$vm1_l2").getText());
//		Assert.assertEquals("V2",findWidget("$vm1_l3").getText());
		
    	click(engine $f "vm1_btn")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("OO-AA", getValue(vm1_t1));
    	ZKSeleneseTestCase.assertEquals("OO-AA", getText(vm1_l2));
    	ZKSeleneseTestCase.assertEquals("do command1 AA", getText(vm1_l3));

    	val vm2_l1 = engine $f "vm2_l1"
    	val vm2_t1 = engine $f "vm2_t1"
    	val vm2_l2 = engine $f "vm2_l2"
    	val vm2_l3 = engine $f "vm2_l3"
    	ZKSeleneseTestCase.assertEquals("BB", getText(vm2_l1));
    	ZKSeleneseTestCase.assertEquals("V1-BB", getValue(vm2_t1));
    	ZKSeleneseTestCase.assertEquals("V1-BB", getText(vm2_l2));    	
    	ZKSeleneseTestCase.assertEquals("V2", getText(vm2_l3));    	
//		findWidget("$vm1_btn").click();
//		Assert.assertEquals("OO-AA",findWidget("$vm1_t1").getText());
//		Assert.assertEquals("OO-AA",findWidget("$vm1_l2").getText());
//		Assert.assertEquals("do command1 AA",findWidget("$vm1_l3").getText());
//		Assert.assertEquals("BB",findWidget("$vm2_l1").getText());
//		Assert.assertEquals("V1-BB",findWidget("$vm2_t1").getText());
//		Assert.assertEquals("V1-BB",findWidget("$vm2_l2").getText());
//		Assert.assertEquals("V2",findWidget("$vm2_l3").getText());
		
    	`type`(vm2_t1, "OO")
    	sendKeys(vm2_t1, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("OO-BB", getValue(vm2_t1));
    	ZKSeleneseTestCase.assertEquals("OO-BB", getText(vm2_l2));    	
    	ZKSeleneseTestCase.assertEquals("V2", getText(vm2_l3));    	
//		findWidget("$vm2_t1").clear().keys("OO").tab();
//		Assert.assertEquals("OO-BB",findWidget("$vm2_t1").getText());
//		Assert.assertEquals("OO-BB",findWidget("$vm2_l2").getText());
//		Assert.assertEquals("V2",findWidget("$vm2_l3").getText());
		
    	click(engine $f "vm2_btn")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("OO-BB", getValue(vm2_t1));
    	ZKSeleneseTestCase.assertEquals("OO-BB", getText(vm2_l2));    	
    	ZKSeleneseTestCase.assertEquals("do command1 BB", getText(vm2_l3));  
//    	findWidget("$vm2_btn").click();
//		Assert.assertEquals("OO-BB",findWidget("$vm2_t1").getText());
//		Assert.assertEquals("OO-BB",findWidget("$vm2_l2").getText());
//		Assert.assertEquals("do command1 BB",findWidget("$vm2_l3").getText());
    	
    	val vm3_l1 = engine $f "vm3_l1"
    	val vm3_t1 = engine $f "vm3_t1"
    	val vm3_l2 = engine $f "vm3_l2"
    	val vm3_l3 = engine $f "vm3_l3"
    	ZKSeleneseTestCase.assertEquals("CC", getText(vm3_l1));
    	ZKSeleneseTestCase.assertEquals("V1-CC", getValue(vm3_t1));
    	ZKSeleneseTestCase.assertEquals("V1-CC", getText(vm3_l2));    	
    	ZKSeleneseTestCase.assertEquals("V2", getText(vm3_l3));      	
//		Assert.assertEquals("CC",findWidget("$vm3_l1").getText());
//		Assert.assertEquals("V1-CC",findWidget("$vm3_t1").getText());
//		Assert.assertEquals("V1-CC",findWidget("$vm3_l2").getText());
//		Assert.assertEquals("V2",findWidget("$vm3_l3").getText());
		
    	`type`(vm3_t1, "OO")
    	sendKeys(vm3_t1, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("OO-CC", getValue(vm3_t1));
    	ZKSeleneseTestCase.assertEquals("OO-CC", getText(vm3_l2));    	
    	ZKSeleneseTestCase.assertEquals("V2", getText(vm3_l3));      	
//		findWidget("$vm3_t1").clear().keys("OO").tab();
//		Assert.assertEquals("OO-CC",findWidget("$vm3_t1").getText());
//		Assert.assertEquals("OO-CC",findWidget("$vm3_l2").getText());
//		Assert.assertEquals("V2",findWidget("$vm3_l3").getText());
		
    	click(engine $f "vm3_btn")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("OO-CC", getValue(vm3_t1));
    	ZKSeleneseTestCase.assertEquals("OO-CC", getText(vm3_l2));    	
    	ZKSeleneseTestCase.assertEquals("do command1 CC", getText(vm3_l3));      	
//		findWidget("$vm3_btn").click();
//		Assert.assertEquals("OO-CC",findWidget("$vm3_t1").getText());
//		Assert.assertEquals("OO-CC",findWidget("$vm3_l2").getText());
//		Assert.assertEquals("do command1 CC",findWidget("$vm3_l3").getText());
		
    	val vm4_l1 = engine $f "vm4_l1"
    	val vm4_t1 = engine $f "vm4_t1"
    	val vm4_l2 = engine $f "vm4_l2"
    	val vm4_l3 = engine $f "vm4_l3"
    	ZKSeleneseTestCase.assertEquals("XX", getText(vm4_l1));
    	ZKSeleneseTestCase.assertEquals("V1-XX", getValue(vm4_t1));
    	ZKSeleneseTestCase.assertEquals("V1-XX", getText(vm4_l2));    	
    	ZKSeleneseTestCase.assertEquals("V2", getText(vm4_l3));      
//		Assert.assertEquals("XX",findWidget("$vm4_l1").getText());
//		Assert.assertEquals("V1-XX",findWidget("$vm4_t1").getText());
//		Assert.assertEquals("V1-XX",findWidget("$vm4_l2").getText());
//		Assert.assertEquals("V2",findWidget("$vm4_l3").getText());
		
    	`type`(vm4_t1, "OO")
    	sendKeys(vm4_t1, Keys.TAB)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("OO-XX", getValue(vm4_t1));
    	ZKSeleneseTestCase.assertEquals("OO-XX", getText(vm4_l2));    	
    	ZKSeleneseTestCase.assertEquals("V2", getText(vm4_l3));     	
//    	findWidget("$vm4_t1").clear().keys("OO").tab();
//		Assert.assertEquals("OO-XX",findWidget("$vm4_t1").getText());
//		Assert.assertEquals("OO-XX",findWidget("$vm4_l2").getText());
//		Assert.assertEquals("V2",findWidget("$vm4_l3").getText());
		
		click(engine $f "vm4_btn")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("OO-XX", getValue(vm4_t1));
    	ZKSeleneseTestCase.assertEquals("OO-XX", getText(vm4_l2));    	
    	ZKSeleneseTestCase.assertEquals("do command1 XX", getText(vm4_l3));     
//    	findWidget("$vm4_btn").click();
//		Assert.assertEquals("OO-XX",findWidget("$vm4_t1").getText());
//		Assert.assertEquals("OO-XX",findWidget("$vm4_l2").getText());
//		Assert.assertEquals("do command1 XX",findWidget("$vm4_l3").getText());
    })
  }
}
