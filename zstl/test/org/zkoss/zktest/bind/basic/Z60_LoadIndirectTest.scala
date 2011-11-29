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
package org.zkoss.zktest.bind.basic

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_LoadIndirectTest extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = {//load-indirect.zul
<window apply="org.zkoss.zktest.bind.basic.LoadIndirectComposer">
	<custom-attributes composerName="vm"/>
<grid width="500px" >
	<columns>
		<column label="First Name"></column>
		<column label="Last Name"></column>
		<column label="Full Name"></column>
		<column label="Current Field"></column>
	</columns>
	<rows>
		<row id="row1">
			<textbox id="l1" value="@bind(vm.p1.firstName)"/>
			<label id="l2" value="@bind(vm.p1.lastName)"/>
			<label id="l3" value="@bind(vm.p1.fullName)"/>
			<label id="l4" value="@bind(vm.p1[vm.currField])"/>
		</row>
	</rows>
</grid>
<hbox>
<button id="btn1" label="to firstName" onClick="@command('toFirstName')"/>
<button id="btn2" label="to lastName" onClick="@command('toLastName')"/>
<button id="btn3" label="to fullName" onClick="@command('toFullName')"/>

<listbox selectedItem="@bind(vm.currField)" id="select" mold="select">
<listitem label="firstName" value="firstName" />
<listitem label="lastName" value="lastName" />
<listitem label="fullName" value="fullName" />
</listbox>

</hbox>

<button label="Dump" onClick="binder.getTracker().dump()"/>
</window>
      }
    runZTL(zul, () => {
    	val t1 = engine $f "l1"
    	val l2 = engine $f "l2"
    	val l3 = engine $f "l3"
    	val l4 = engine $f "l4"
    	val select = engine $f "select"
    	
          	
    	ZKSeleneseTestCase.assertEquals("First1", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("First1", getText(l4));
    	ZKSeleneseTestCase.assertEquals("0", getSelectedIndex(select));
//		Assert.assertEquals("First1",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("First1 Last1",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("First1",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals(0L,findWidget("$select").getAttribute("selectedIndex"));
		
		`type`(t1, "AAA")
		click(engine $f "btn1")
		waitResponse()
		ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("AAA Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("AAA", getText(l4));
//		findWidget("$l1").clear().keys("AAA");
//		findWidget("$btn1").focus();
//		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("AAA Last1",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("AAA",findWidget("$l4").getAttribute("value"));
		
		
		click(engine $f "btn2")
		ZKSeleneseTestCase.assertEquals("AAA", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("AAA Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l4));
    	ZKSeleneseTestCase.assertEquals("1", getSelectedIndex(select));
//		findWidget("$btn2").click();
//		Assert.assertEquals("AAA",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("AAA Last1",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("Last1",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals(1L,findWidget("$select").getAttribute("selectedIndex"));
		
    	`type`(t1, "BBB")
		waitResponse()
		ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("BBB Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l4));
//		findWidget("$l1").clear().keys("BBB");
//		findWidget("$btn1").focus();
//		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("Last1",findWidget("$l4").getAttribute("value"));
		
		click(engine $f "btn3")
		ZKSeleneseTestCase.assertEquals("BBB", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("BBB Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("BBB Last1", getText(l4));
    	ZKSeleneseTestCase.assertEquals("2", getSelectedIndex(select)); //listbox.$n().get("selectedIndex")
//		findWidget("$btn3").click();
//		Assert.assertEquals("BBB",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("BBB Last1",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals(2L,findWidget("$select").getAttribute("selectedIndex"));
		
    	click(engine $f "btn1")
		ZKSeleneseTestCase.assertEquals("BBB", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("BBB Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("BBB", getText(l4));
    	ZKSeleneseTestCase.assertEquals("0", getSelectedIndex(select));
//		findWidget("$btn1").click();
//		Assert.assertEquals("BBB",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("BBB",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals(0L,findWidget("$select").getAttribute("selectedIndex"));      

    })
  }
}
