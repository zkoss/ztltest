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
class Z60_LoadTest extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = {//load.zul
<window apply="org.zkoss.zktest.bind.basic.LoadComposer">
	<custom-attributes composerName="vm"/>
<grid width="500px" >
	<columns>
		<column label="First Name"></column>
		<column label="Last Name"></column>
		<column label="Full Name"></column>
		<column label="Street"></column>
	</columns>
	<rows>
		<row id="row1" value="@bind(vm.p1)">
			<textbox id="l1" value="@bind(vm.p1.firstName)"/>
			<label id="l2" value="@bind(vm.p1.lastName)"/>
			<label id="l3" value="@bind(vm.p1.fullName)"/>
			<label id="l4" value="@bind(vm.p1.address.street)"/>
		</row>
		<row id="row2" value="@bind(vm.selected)">
			<label id="l5" value="@bind(vm.selected.firstName)"/>
			<label id="l6" value="@load(vm.selected.lastName)"/>
			<label id="l7" value="@load(vm.selected.fullName)"/>
			<label id="l8" value="@load(vm.selected.address.street)"/>
		</row>
	</rows>
</grid>
<hbox>
<button id="btn1" label="change firstName1" onClick="@command('changeFirstName1')"/>
<button id="btn2" label="change lastName1" onClick="@command('changeLastName1')"/>

<button id="btn3" label="change firstName2" onClick="@command('changeFirstName2')"/>
<button id="btn4" label="change lastName2" onClick="@command('changeLastName2')"/>

<button id="btn5" label="event change lastName1" onClick="vm.changeLastName1()"/>
<button id="btn6" label="event change lastName2" onClick="vm.changeLastName2()"/>
</hbox>
<hbox>
<button id="btn7" label="p1 only" onClick="@command('notifyP1')"/>
<button id="btn8" label="selected only" onClick="@command('notifySelected')"/>
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
    	val l6 = engine $f "l6"
    	val l7 = engine $f "l7"
    	val l8 = engine $f "l8"
    	
    	ZKSeleneseTestCase.assertEquals("First1", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
    	ZKSeleneseTestCase.assertEquals("First1", getText(l5));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l6));
    	ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l7));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
    	
//    	Assert.assertEquals("First1",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("First1 Last1",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("First1",findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Last1",findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("First1 Last1",findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
    	val btn1 = engine $f "btn1"
    	click(btn1)
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("Dennis", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
    	ZKSeleneseTestCase.assertEquals("Dennis Last1", getText(l3));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
    	ZKSeleneseTestCase.assertEquals("Dennis", getText(l5));
    	ZKSeleneseTestCase.assertEquals("Last1", getText(l6));
    	ZKSeleneseTestCase.assertEquals("Dennis Last1", getText(l7));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
//		findWidget("$btn1").click();
//		Assert.assertEquals("Dennis",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("Dennis Last1",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("Dennis",findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Last1",findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("Dennis Last1",findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
    	click(engine $f "btn2")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("Dennis", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Chen", getText(l2));
    	ZKSeleneseTestCase.assertEquals("Dennis Chen", getText(l3));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
    	ZKSeleneseTestCase.assertEquals("Dennis", getText(l5));
    	ZKSeleneseTestCase.assertEquals("Chen", getText(l6));
    	ZKSeleneseTestCase.assertEquals("Dennis Chen", getText(l7));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
//		findWidget("$btn2").click();
//		Assert.assertEquals("Dennis",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("Dennis Chen",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("Dennis",findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("Dennis Chen",findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
    	click(engine $f "btn3")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("Alex", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Chen", getText(l2));
    	ZKSeleneseTestCase.assertEquals("Alex Chen", getText(l3));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
    	ZKSeleneseTestCase.assertEquals("Alex", getText(l5));
    	ZKSeleneseTestCase.assertEquals("Chen", getText(l6));
    	ZKSeleneseTestCase.assertEquals("Alex Chen", getText(l7));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
//		findWidget("$btn3").click();
//		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("Alex Chen",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("Alex Chen",findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
    	click(engine $f "btn4")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("Alex", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Wang", getText(l2));
    	ZKSeleneseTestCase.assertEquals("Alex Wang", getText(l3));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
    	ZKSeleneseTestCase.assertEquals("Alex", getText(l5));
    	ZKSeleneseTestCase.assertEquals("Wang", getText(l6));
    	ZKSeleneseTestCase.assertEquals("Alex Wang", getText(l7));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
//		findWidget("$btn4").click();
//		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Wang",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("Alex Wang",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Wang",findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("Alex Wang",findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
    	click(engine $f "btn5")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("Alex", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Chen", getText(l2));
    	ZKSeleneseTestCase.assertEquals("Alex Chen", getText(l3));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
    	ZKSeleneseTestCase.assertEquals("Alex", getText(l5));
    	ZKSeleneseTestCase.assertEquals("Chen", getText(l6));
    	ZKSeleneseTestCase.assertEquals("Alex Chen", getText(l7));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));		
//		findWidget("$btn5").click();
//		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("Alex Chen",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("Alex Chen",findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
    	click(engine $f "btn6")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("Alex", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Wang", getText(l2));
    	ZKSeleneseTestCase.assertEquals("Alex Wang", getText(l3));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
    	ZKSeleneseTestCase.assertEquals("Alex", getText(l5));
    	ZKSeleneseTestCase.assertEquals("Wang", getText(l6));
    	ZKSeleneseTestCase.assertEquals("Alex Wang", getText(l7));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));	
//		findWidget("$btn6").click();
//		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Wang",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("Alex Wang",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Wang",findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("Alex Wang",findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		

		//we have spec change here since 10/29, revision 18, notify p1 will also cause selected reload(they are same instance)
    	click(engine $f "btn7")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("Ian", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Tasi", getText(l2));
    	ZKSeleneseTestCase.assertEquals("Ian Tasi", getText(l3));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
    	ZKSeleneseTestCase.assertEquals("Ian", getText(l5));
    	ZKSeleneseTestCase.assertEquals("Tasi", getText(l6));
    	ZKSeleneseTestCase.assertEquals("Ian Tasi", getText(l7));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));	    	
//		findWidget("$btn7").click();
//		Assert.assertEquals("Ian",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Tasi",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("Ian Tasi",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("Ian",findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Tasi",findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("Ian Tasi",findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
		//we have spec change here since 10/29, revision 18, notify selected will also cause p1 reload(they are same instance)
    	click(engine $f "btn8")
    	waitResponse()
    	ZKSeleneseTestCase.assertEquals("Jumper", getValue(t1));
    	ZKSeleneseTestCase.assertEquals("Chen", getText(l2));
    	ZKSeleneseTestCase.assertEquals("Jumper Chen", getText(l3));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
    	ZKSeleneseTestCase.assertEquals("Jumper", getText(l5));
    	ZKSeleneseTestCase.assertEquals("Chen", getText(l6));
    	ZKSeleneseTestCase.assertEquals("Jumper Chen", getText(l7));
    	ZKSeleneseTestCase.assertEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));	    	
//		findWidget("$btn8").click();
//		Assert.assertEquals("Jumper",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("Jumper Chen",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
//		Assert.assertEquals("Jumper",findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("Jumper Chen",findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));      

    })
  }
}
