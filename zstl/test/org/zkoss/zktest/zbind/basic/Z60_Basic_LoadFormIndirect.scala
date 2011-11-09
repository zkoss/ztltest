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
class Z60_Basic_LoadFormIndirect extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = {//load-form-indirect.zul
<window apply="org.zkoss.zktest.zbind.basic.LoadIndirectComposer" composerName="@bind('vm')" binderName="@bind('binder')">
	<!-- <custom-attributes composerName="vm"/>-->
<grid width="500px" >
	<columns>
		<column label="First Name"></column>
		<column label="Last Name"></column>
		<column label="Full Name"></column>
		<column label="Current Field"></column>
	</columns>
	<rows>
		<row id="row1" self="@form(id='fx', load=vm.p1, save=vm.p1 before 'saveForm')">
			<textbox id="l1" value="@bind(fx.firstName)"/>
			<label id="l2" value="@bind(fx.lastName)"/>
			<label id="l3" value="@bind(fx.fullName)"/>
			<hbox>
			<!-- this indirect only load a available value when loading is fire by form load, because only at that time have fx in context -->
			<label id="l4" value="@bind(fx[vm.currField])"/>/
			<label id="l5" value="@bind(vm.p1[vm.currField])"/>
			</hbox>
		</row>
	</rows>
</grid>
<hbox>
	<textbox id="l6" value="@bind(vm.p2.firstName)"/>
	<label id="l7" value="@bind(vm.p2.lastName)"/>
	<label id="l8" value="@bind(vm.p2.fullName)"/>
</hbox>
<hbox>
<button id="btn1" label="to firstName" onClick="@bind('toFirstName')"/>
<button id="btn2" label="to lastName" onClick="@bind('toLastName')"/>
<button id="btn3" label="to fullName" onClick="@bind('toFullName')"/>
<button id="btn4" label="save form" onClick="@bind('saveForm')"/>
</hbox>

<button label="Dump" onClick="binder.getTracker().dump()"/>
</window>
    }
    runZTL(zul, () => {
    	val t1 = engine $f "l1"
    	val l2 = engine $f "l2"
    	val l3 = engine $f "l3"
    	val l4 = engine $f "l4"
    	val l5 = engine $f "l5"
    	val t6 = engine $f "l6"
    	val l7 = engine $f "l7"
    	val l8 = engine $f "l8"

    	ZKSeleneseTestCase.assertEquals("First1", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("First1", getText(l4));
    	ZKSeleneseTestCase.assertEquals("First1", getText(l5));
    	ZKSeleneseTestCase.assertEquals("", getValue(t6));
    	ZKSeleneseTestCase.assertEquals("", getText(l7));
    	ZKSeleneseTestCase.assertEquals("", getText(l8));
//    	Assert.assertEquals("First1", findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("First1 Last1",	findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("First1", findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

    	`type`(t1,"XXX")
    	val btn1 = engine $f "btn1"
    	click(btn1)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("XXX", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("First1", getText(l4));
    	ZKSeleneseTestCase.assertEquals("First1", getText(l5));
    	ZKSeleneseTestCase.assertEquals("", getValue(t6));
    	ZKSeleneseTestCase.assertEquals("", getText(l7));
    	ZKSeleneseTestCase.assertEquals("", getText(l8));    	
//		findWidget("$l1").clear().keys("XXX");
//		findWidget("$btn1").focus();
//		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("First1 Last1",	findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("First1", findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

    	val btn2 = engine $f "btn2"
    	click(btn2)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("First1", getText(l4));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l5));
    	ZKSeleneseTestCase.assertEquals("", getText(l8));
//		findWidget("$btn2").click();
//		Assert.assertEquals("First1", findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

    	val btn3 = engine $f "btn3"
    	click(btn3)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("First1", getText(l4));
    	ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l5));
    	ZKSeleneseTestCase.assertEquals("", getText(l8));
//		findWidget("$btn3").click();
//		Assert.assertEquals("First1", findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("First1 Last1",
//				findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

		val btn4 = engine $f "btn4"
    	click(btn4)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("XXX", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l4));
    	ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l5));
    	ZKSeleneseTestCase.assertEquals("XXX", getValue(t6));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l7));
    	ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l8));
//    	findWidget("$btn4").click();
//		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("XXX Last1", findWidget("$l3")
//				.getAttribute("value"));
//		Assert.assertEquals("XXX Last1", findWidget("$l4")
//				.getAttribute("value"));
//		Assert.assertEquals("XXX Last1", findWidget("$l5")
//				.getAttribute("value"));
//		Assert.assertEquals("XXX", findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("XXX Last1", findWidget("$l8")
//				.getAttribute("value"));

    	`type`(t1,"YYY")
    	click(btn1)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l4));
    	ZKSeleneseTestCase.assertEquals("XXX", getText(l5));
    	ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l8));
//		findWidget("$l1").clear().keys("YYY");
//		findWidget("$btn1").focus();
//		findWidget("$btn1").click();
//		Assert.assertEquals("XXX Last1", findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("XXX", findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("XXX Last1", findWidget("$l8").getAttribute("value"));

		click(btn4)
		waitResponse()
		ZKSeleneseTestCase.assertEquals("YYY", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("YYY Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("YYY", getText(l4));
    	ZKSeleneseTestCase.assertEquals("YYY", getText(l5));
    	ZKSeleneseTestCase.assertEquals("YYY", getValue(t6));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l7));
    	ZKSeleneseTestCase.assertEquals("YYY Last1", getText(l8));
//    	findWidget("$btn4").click();
//		Assert.assertEquals("YYY", findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("YYY Last1", findWidget("$l3")
//				.getAttribute("value"));
//		Assert.assertEquals("YYY", findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("YYY", findWidget("$l5").getAttribute("value"));
//
//		Assert.assertEquals("YYY", findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("YYY Last1", findWidget("$l8")
//				.getAttribute("value"));
      
    })
  }
}
