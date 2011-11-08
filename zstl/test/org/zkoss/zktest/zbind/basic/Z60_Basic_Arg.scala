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
import org.zkoss.ztl.Tags;
import org.openqa.selenium.Keys

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_Basic_Arg extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <window apply="org.zkoss.zktest.zbind.basic.ArgsComposer">
	<custom-attributes composerName="vm"/>
	<hbox>
		<label id="l1" value="@bind(vm.value1) @converter(vm.converter1, arg1 = 'Arg1', arg2 = 'Arg2')" />
		<label id="l2" value="@bind(vm.value2) @converter(vm.converter1, arg1 = vm.myArg1, arg2 = vm.myArg2)" />
	</hbox>
	<hbox>
		<textbox id="t1" value="@bind(vm.value1) @converter(vm.converter1, arg1 = 'Arg1', arg2 = 'Arg2')" />
		<textbox id="t2" value="@bind(vm.value2) @converter(vm.converter1, arg1 = vm.myArg1, arg2 = vm.myArg2)" />
	</hbox>
	<hbox>
		<textbox id="t3" value="@bind(vm.value1) @validator(vm.validator1, text = 'V1')" />
		<label id ="l3" value="@bind(vm.message3)"/>
	</hbox>
	<hbox self="@form(id='fx',vm, save=vm before 'cmd2') @validator(vm.validator2, text = 'V2')">
		<textbox id="t4" value="@bind(fx.value1)" />
		<label id ="l4" value="@bind(vm.message4)"/>
	</hbox>
	
	
	<hbox>
		<button id="btn1" label="cmd1" onClick="@bind('cmd1', param1='Dennis', param2=vm.param2)"/>
		<button id="btn2" label="cmd2" onClick="@bind('cmd2')"/>
		<button label="Dump" onClick="binder.getTracker().dump()" />
	</hbox>	
</window>
    }
    runZTL(zul, () => {
    	val l1 = engine $f "l1"
    	val l2 = engine $f "l2"
    	val t1 = engine $f "t1"
    	val t2 = engine $f "t2"
    	
    	verifyEquals("A-Arg1", getValue(l1));
    	verifyEquals("B-myarg1", getValue(l2));
    	verifyEquals("A-Arg1", getValue(t1));
    	verifyEquals("B-myarg1", getValue(t2));
    	
    	`type`(t1, "X")
    	sendKeys(t1, Keys.TAB)
    	waitResponse()
    	verifyEquals("X-Arg2-Arg1", getValue(l1));
    	verifyEquals("B-myarg1", getValue(l2));
    	verifyEquals("X-Arg2-Arg1", getValue(t1));
    	verifyEquals("B-myarg1", getValue(t2));    	

    	`type`(t2, "Y")
    	sendKeys(t2, Keys.TAB)
    	waitResponse()
    	verifyEquals("X-Arg2-Arg1", getValue(l1));
    	verifyEquals("Y-myarg2-myarg1", getValue(l2));
    	verifyEquals("X-Arg2-Arg1", getValue(t1));
    	verifyEquals("Y-myarg2-myarg1", getValue(t2));    	

    	click(engine $f "btn1")
    	waitResponse()
    	verifyEquals("X-Arg2Dennis-Arg1", getValue(l1));
    	verifyEquals("Y-myarg2Chen-myarg1", getValue(l2));
    	verifyEquals("X-Arg2Dennis-Arg1", getValue(t1));
    	verifyEquals("Y-myarg2Chen-myarg1", getValue(t2));

    	val t3 = engine $f "t3"
    	val l3 = engine $f "l3"
    	`type`(t3, "ABC")
    	sendKeys(t3, Keys.TAB)
    	waitResponse()
    	verifyEquals("value have to equals V1", getValue(l3));

    	`type`(t3, "V1")
    	sendKeys(t3, Keys.TAB)
    	waitResponse()
    	verifyEquals("", getValue(l3));
    	verifyEquals("V1-Arg1", getValue(l1));

    	val t4 = engine $f "t4"
    	val l4 = engine $f "l4"
    	`type`(t4, "ABC")
    	sendKeys(t4, Keys.TAB)
    	waitResponse()
    	verifyEquals("", getValue(l4));
    	click(engine $f "btn2")
    	waitResponse()
    	verifyEquals("value have to equals V2", getValue(l4));
    	verifyEquals("V1", getValue(t3));

    	`type`(t4, "V2")
    	sendKeys(t4, Keys.TAB)
    	click(engine $f "btn2")
    	waitResponse()
    	verifyEquals("execute cmd2", getValue(l4));
    	verifyEquals("V2-Arg1", getValue(l1));
    	verifyEquals("V2", getValue(t3));

    })
  }
}
