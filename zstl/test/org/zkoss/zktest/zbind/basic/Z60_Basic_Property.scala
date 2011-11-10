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
class Z60_Basic_Property extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = {//property.zul
<window apply="org.zkoss.zktest.zbind.basic.PropertyComposer"
	composerName="@bind('vm')">
	<grid width="500px">
		<columns>
			<column label="" width="40px" />
			<column label="A"  />
			<column label="B"  />
			<column label="C"  />
		</columns>
		<rows>
			<row>
				1
				<textbox id="t1" value="@bind(vm.value1)" />
				<!-- load when vm.value1 was changed -->
				<label id="l1" value="@bind(vm.value1)" />
				<!-- only load when cmd1 -->
				<label id="l1x" value="@bind(load = vm.value1 after 'cmd1')" />
			</row>
			<row>
				2
				<!-- always change, but only load when cmd2, cmd2 will plus a post text on value2 -->
				<textbox id="t2" value="@bind(vm.value2, load=vm.value2 after 'cmd2')" />
				<!-- load when vm.value2 was changed -->
				<label id="l2" value="@bind(vm.value2)" />
				<!-- only load when cmd2 -->
				<label id="l2x" value="@bind(load = vm.value2 after 'cmd2')" />
			</row> 
			<row>
				3
				<!-- save before cmd3, load when value3 was changed, cmd3 will plus a post text on value3 -->
				<textbox id="t3" value="@bind(load=vm.value3, save = vm.value3 before 'cmd3')" />
				<label id="l3" value="@bind(load = vm.value3 before 'cmd3')" />
				<label id="l3x" value="@bind(load = vm.value3 after 'cmd3')" />
			</row>
			<!-- 
			<row>
				4
				<textbox id="t4" value="@bind(load=vm.value4, save = vm.value4 before 'cmd4')" />
				<label id="l4" value="@bind(load = vm.value4 before 'cmd4')" />
				<label id="l4x" value="@bind(load = vm.value4 after 'cmd4')" />
			</row>
			 -->
		</rows>

	</grid>
	<hbox>
		<button id="cmd1" label="Cmd1" onClick="@bind('cmd1')" />
		<button id="cmd2" label="Cmd2" onClick="@bind('cmd2')" />
		<button id="cmd3" label="Cmd3" onClick="@bind('cmd3')" />
		<button id="change3" label="Change3" onClick="@bind('change3')" />
		<!-- 
		<button label="c4" onClick="@bind('cmd4')" />
		 -->
	</hbox>
	<hbox>
		<button label="Dump" onClick="binder.getTracker().dump()" />
	</hbox>

</window>
    }
    runZTL(zul, () => {
    	val t1 = engine $f "t1"
    	val l1 = engine $f "l1"
    	val l1x = engine $f "l1x"
    	ZKSeleneseTestCase.assertEquals("A", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("A", getText(l1));
    	ZKSeleneseTestCase.assertEquals("", getText(l1x));    	
//		Assert.assertEquals("A",findWidget("$t1").getAttribute("value"));
//		Assert.assertEquals("A",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("",findWidget("$l1x").getAttribute("value"));
		
    	typeKeys(t1, "XX")
    	waitResponse()
    	//FIXME XX or AXX
    	ZKSeleneseTestCase.assertEquals("AXX", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("AXX", getText(l1));
    	ZKSeleneseTestCase.assertEquals("", getText(l1x));
//		findWidget("$t1").keys("XX");
//		findWidget("$cmd1").focus();
//		Assert.assertEquals("AXX",findWidget("$t1").getAttribute("value"));
//		Assert.assertEquals("AXX",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("",findWidget("$l1x").getAttribute("value"));
	
    	click(engine $f "cmd1")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("AXX", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("AXX", getText(l1));
    	ZKSeleneseTestCase.assertEquals("AXX", getText(l1x));
//		findWidget("$cmd1").click();
//		Assert.assertEquals("AXX",findWidget("$t1").getAttribute("value"));
//		Assert.assertEquals("AXX",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("AXX",findWidget("$l1x").getAttribute("value"));
		
		//test 2
    	val t2 = engine $f "t2"
    	val l2 = engine $f "l2"
    	val l2x = engine $f "l2x"
    	ZKSeleneseTestCase.assertEquals("", getValue(t2));
    	ZKSeleneseTestCase.assertEquals("B", getText(l2));
    	ZKSeleneseTestCase.assertEquals("", getText(l2x));    	    	
//		Assert.assertEquals("",findWidget("$t2").getAttribute("value"));
//		Assert.assertEquals("B",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("",findWidget("$l2x").getAttribute("value"));
		
    	`type`(t2, "YY")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("YY", getValue(t2));
    	ZKSeleneseTestCase.assertEquals("YY", getText(l2));
    	ZKSeleneseTestCase.assertEquals("", getText(l2x));
//		findWidget("$t2").keys("YY");
//		findWidget("$cmd2").focus();
//		Assert.assertEquals("YY",findWidget("$t2").getAttribute("value"));
//		Assert.assertEquals("YY",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("",findWidget("$l2x").getAttribute("value"));
		
    	click(engine $f "cmd2")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("YY-by-cmd2", getValue(t2));
    	ZKSeleneseTestCase.assertEquals("YY", getText(l2));
    	ZKSeleneseTestCase.assertEquals("YY-by-cmd2", getText(l2x));
//		findWidget("$cmd2").click();
//		Assert.assertEquals("YY-by-cmd2",findWidget("$t2").getAttribute("value"));
//		Assert.assertEquals("YY",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("YY-by-cmd2",findWidget("$l2x").getAttribute("value"));
		
		//test 3
    	val t3 = engine $f "t3"
    	val l3 = engine $f "l3"
    	val l3x = engine $f "l3x"
    	ZKSeleneseTestCase.assertEquals("C", getValue(t3));
    	ZKSeleneseTestCase.assertEquals("", getText(l3));
    	ZKSeleneseTestCase.assertEquals("", getText(l3x));     	
//		Assert.assertEquals("C",findWidget("$t3").getAttribute("value"));
//		Assert.assertEquals("",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("",findWidget("$l3x").getAttribute("value"));
		
    	typeKeys(t3, "ZZ")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("CZZ", getValue(t3));
    	ZKSeleneseTestCase.assertEquals("", getText(l3));
    	ZKSeleneseTestCase.assertEquals("", getText(l3x));      	
//		findWidget("$t3").keys("ZZ");
//		findWidget("$cmd3").focus();
//		Assert.assertEquals("CZZ",findWidget("$t3").getAttribute("value"));
//		Assert.assertEquals("",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("",findWidget("$l3x").getAttribute("value"));
		
    	click(engine $f "cmd3")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("CZZ-by-cmd3", getValue(t3));
    	ZKSeleneseTestCase.assertEquals("CZZ", getText(l3));
    	ZKSeleneseTestCase.assertEquals("CZZ-by-cmd3", getText(l3x));
//		findWidget("$cmd3").click();
//		Assert.assertEquals("CZZ-by-cmd3",findWidget("$t3").getAttribute("value"));
//		Assert.assertEquals("CZZ",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("CZZ-by-cmd3",findWidget("$l3x").getAttribute("value"));
		
    	`type`(t3, "GG")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("GG", getValue(t3));
    	ZKSeleneseTestCase.assertEquals("CZZ", getText(l3));
    	ZKSeleneseTestCase.assertEquals("CZZ-by-cmd3", getText(l3x));
//		findWidget("$t3").clear().keys("GG");
//		findWidget("$cmd3").focus();
//		Assert.assertEquals("GG",findWidget("$t3").getAttribute("value"));
//		Assert.assertEquals("CZZ",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("CZZ-by-cmd3",findWidget("$l3x").getAttribute("value"));
		
    	click(engine $f "change3")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("CZZ-by-cmd3-by-change3", getValue(t3));
    	ZKSeleneseTestCase.assertEquals("CZZ", getText(l3));
    	ZKSeleneseTestCase.assertEquals("CZZ-by-cmd3", getText(l3x));
//		findWidget("$change3").click();
//		Assert.assertEquals("CZZ-by-cmd3-by-change3",findWidget("$t3").getAttribute("value"));
//		Assert.assertEquals("CZZ",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("CZZ-by-cmd3",findWidget("$l3x").getAttribute("value"));      
    })
  }
}
