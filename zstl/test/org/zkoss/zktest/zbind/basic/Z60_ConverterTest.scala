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
class Z60_ConverterTest extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = {//converter.zul
<window apply="org.zkoss.zktest.zbind.basic.ConverterComposer">
	<custom-attributes composerName="vm"/>
	format : yyyy/MM/dd
	<vbox>
		<textbox id="t1" value="@bind(vm.bday1) @converter('myconverter1')" />
		<label id="l1" value="@bind(vm.age1)"/>
	</vbox>
	<vbox self="@form(id='fx', load=vm, save=vm before 'saveForm')">
		<textbox id="t2" value="@bind(fx.bday1) @converter('myconverter1')" />
		<label id="l2" value="@bind(fx.age1)"/>
	</vbox>
	<hbox>
		<button id="saveForm" label="saveForm" onClick="@bind('saveForm')" />
	</hbox>
	<hbox>
		<button label="Dump" onClick="binder.getTracker().dump()" />
	</hbox>	
</window>
    }
    runZTL(zul, () => {
      val t1 = engine $f "t1"
      val l1 = engine $f "l1"
      val t2 = engine $f "t2"
      val l2 = engine $f "l2"
      
      ZKSeleneseTestCase.assertEquals("1975/02/13", getValue(t1));
      ZKSeleneseTestCase.assertEquals("36", getText(l1));
      ZKSeleneseTestCase.assertEquals("1975/02/13", getValue(t2));
      ZKSeleneseTestCase.assertEquals("36", getText(l2));
//      Assert.assertEquals("1975/02/13",findWidget("$t1").getAttribute("value"));
//      Assert.assertEquals("36",findWidget("$l1").getAttribute("value"));
//      Assert.assertEquals("1975/02/13",findWidget("$t2").getAttribute("value"));
//      Assert.assertEquals("36",findWidget("$l2").getAttribute("value"));
		
      `type`(t1, "1980/02/AA")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getValue(t1));
      ZKSeleneseTestCase.assertEquals("0", getText(l1));
      ZKSeleneseTestCase.assertEquals("1975/02/13", getValue(t2));
      ZKSeleneseTestCase.assertEquals("36", getText(l2));
//      findWidget("$t1").clear().keys("1980/02/AA");
//      findWidget("$saveForm").focus();
//      Assert.assertEquals("",findWidget("$t1").getAttribute("value"));
//      Assert.assertEquals("0",findWidget("$l1").getAttribute("value"));
//      Assert.assertEquals("1975/02/13",findWidget("$t2").getAttribute("value"));
//      Assert.assertEquals("36",findWidget("$l2").getAttribute("value"));

      `type`(t1, "1980/02/13")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("1980/02/13", getValue(t1));
      ZKSeleneseTestCase.assertEquals("31", getText(l1));
      ZKSeleneseTestCase.assertEquals("1975/02/13", getValue(t2));
      ZKSeleneseTestCase.assertEquals("36", getText(l2));
//      findWidget("$t1").clear().keys("1980/02/13");
//      findWidget("$saveForm").focus();
//      Assert.assertEquals("1980/02/13",findWidget("$t1").getAttribute("value"));
//      Assert.assertEquals("31",findWidget("$l1").getAttribute("value"));
//      Assert.assertEquals("1975/02/13",findWidget("$t2").getAttribute("value"));
//      Assert.assertEquals("36",findWidget("$l2").getAttribute("value"));


      `type`(t2, "1985/02/13")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("1980/02/13", getValue(t1));
      ZKSeleneseTestCase.assertEquals("31", getText(l1));
      ZKSeleneseTestCase.assertEquals("1985/02/13", getValue(t2));
      ZKSeleneseTestCase.assertEquals("36", getText(l2));
//      findWidget("$t2").clear().keys("1985/02/13");
//      findWidget("$saveForm").focus();
//      Assert.assertEquals("1980/02/13",findWidget("$t1").getAttribute("value"));
//      Assert.assertEquals("31",findWidget("$l1").getAttribute("value"));
//      Assert.assertEquals("1985/02/13",findWidget("$t2").getAttribute("value"));
//      Assert.assertEquals("36",findWidget("$l2").getAttribute("value"));

      click(engine $f "saveForm")
      ZKSeleneseTestCase.assertEquals("1985/02/13", getValue(t1));
      ZKSeleneseTestCase.assertEquals("26", getText(l1));
      ZKSeleneseTestCase.assertEquals("1985/02/13", getValue(t2));
      ZKSeleneseTestCase.assertEquals("26", getText(l2));
//      findWidget("$saveForm").click();
//      Assert.assertEquals("1985/02/13",findWidget("$t1").getAttribute("value"));
//      Assert.assertEquals("26",findWidget("$l1").getAttribute("value"));
//      Assert.assertEquals("1985/02/13",findWidget("$t2").getAttribute("value"));
//      Assert.assertEquals("26",findWidget("$l2").getAttribute("value"));
    })
  }
}
