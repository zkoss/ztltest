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
class Z60_Basic_Load extends ZTL4ScalaTestCase {
  def testBasic() = {
    //the following import tag is not XML format, hence can NOT put in val zul 
    val header = "<?init class=\"org.zkoss.zktest.zbind.basic.ViewModelInit\"?> \n" +
    			"<?import class=\"org.zkoss.bind.BindComposer\"?> \n"+
    			"<?import class=\"org.zkoss.zktest.zbind.basic.ViewModelInit$SubViewModel\"?>\n"
    val zul = {
<window apply="org.zkoss.zktest.zbind.basic.LoadComposer">
	<custom-attributes composerName="vm"/>
<grid width="1000px" >
	<columns>
		<column label="First Name"></column>
		<column label="Last Name"></column>
		<column label="Full Name"></column>
		<column label="Address.street"></column>
	</columns>
	<rows>
		<row id="row1">
			<textbox id="l1" value="@bind(vm.p1.firstName)"/>
			<label id="l2" value="@bind(vm.p1.lastName)"/>
			<label id="l3" value="@bind(vm.p1.fullName)"/>
			<label id="l4" value="@bind(vm.p1.address.street)"/>
		</row>	
		<row id="row2" self="@form(id='fx', load=vm.p1, save=vm.p1 before 'saveForm')">
			<textbox id="l5" value="@bind(fx.firstName)"/>
			<label id="l6" value="@bind(fx.lastName)"/>
			<label id="l7" value="@bind(fx.fullName)"/>
			<label id="l8" value="@bind(fx.address.street)"/>
		</row>
	</rows>
</grid>
<hbox>
	bind to p2, p2 will be create when click save form
	<textbox id="l9" value="@bind(vm.p2.firstName)"/>
	<label id="la" value="@bind(vm.p2.lastName)"/>
	<label id="lb" value="@bind(vm.p2.fullName)"/>
	<label id="lc" value="@bind(vm.p2.address.street)"/>
</hbox>
<hbox>
<button id="btn1" label="save form" onClick="@bind('saveForm')"/>
</hbox>

<button label="Dump" onClick="binder.getTracker().dump()"/>
</window>
    }
    runZTL(header+zul, () => {
    	val l1 = engine $f "l1"
    	val l2 = engine $f "l2"
    	val l3 = engine $f "l3"
    	val l5 = engine $f "l5"
    	val l6 = engine $f "l6"
    	val l7 = engine $f "l7"
    	val l9 = engine $f "l9"
    	val la = engine $f "la"
    	val lb = engine $f "lb"
    	

    	verifyEquals("First1", getValue(l1));
    	verifyEquals("Last1", getValue(l2));
    	verifyEquals("First1 Last1", getValue(l3));
    	verifyEquals("First1", getValue(l5));
    	verifyEquals("Last1", getValue(l6));
    	verifyEquals("First1 Last1", getValue(l7));
    	verifyEquals("", getValue(l9));
    	verifyEquals("", getValue(la));
    	verifyEquals("", getValue(lb)); 
//		Assert.assertEquals("First1", findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("First1 Last1",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("First1 Last1", findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$l9").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$la").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$lb").getAttribute("value"));

    	`type`(l1,"XXX")
    	waitResponse()
    	verifyEquals("XXX", getValue(l1));
    	verifyEquals("Last1", getValue(l2));
    	verifyEquals("XXX Last1", getValue(l3));
//		findWidget("$l1").clear().keys("XXX");
//		findWidget("$btn1").focus();
//		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("XXX Last1", findWidget("$l3")
//				.getAttribute("value"));

		// spec change, p1.first change will not effect p1 -> fx
    	verifyEquals("First1", getValue(l5));
    	verifyEquals("Last1", getValue(l6));
    	verifyEquals("First1 Last1", getValue(l7));
    	verifyEquals("", getValue(l9));
    	verifyEquals("", getValue(la));
    	verifyEquals("", getValue(lb));    	
//		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("First1 Last1",	findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$l9").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$la").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$lb").getAttribute("value"));

    	`type`(l5,"YYY")
    	waitResponse()
    	verifyEquals("XXX", getValue(l1));
    	verifyEquals("Last1", getValue(l2));
    	verifyEquals("XXX Last1", getValue(l3));
    	verifyEquals("YYY", getValue(l5));
    	verifyEquals("Last1", getValue(l6));
    	verifyEquals("YYY Last1", getValue(l7));
    	verifyEquals("", getValue(l9));
    	verifyEquals("", getValue(la));
    	verifyEquals("", getValue(lb));    	
//		findWidget("$l5").clear().keys("YYY");
//		findWidget("$btn1").focus();
//		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("XXX Last1", findWidget("$l3")
//				.getAttribute("value"));
//		Assert.assertEquals("YYY", findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("First1 Last1",
//				findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$l9").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$la").getAttribute("value"));
//		Assert.assertEquals("", findWidget("$lb").getAttribute("value"));

    	click(engine $f "btn1")
    	waitResponse()
    	verifyEquals("YYY", getValue(l1));
    	verifyEquals("Last1", getValue(l2));
    	verifyEquals("YYY Last1", getValue(l3));
    	verifyEquals("YYY", getValue(l5));
    	verifyEquals("Last1", getValue(l6));
    	verifyEquals("YYY Last1", getValue(l7));
    	verifyEquals("YYY", getValue(l9));
    	verifyEquals("Last1", getValue(la));
    	verifyEquals("YYY Last1", getValue(lb));       	
//		findWidget("$btn1").click();
//		Assert.assertEquals("YYY", findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("YYY Last1", findWidget("$l3")
//				.getAttribute("value"));
//		Assert.assertEquals("YYY", findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("YYY Last1", findWidget("$l7")
//				.getAttribute("value"));
//		Assert.assertEquals("YYY", findWidget("$l9").getAttribute("value"));
//		Assert.assertEquals("Last1", findWidget("$la").getAttribute("value"));
//		Assert.assertEquals("YYY Last1", findWidget("$lb")
//				.getAttribute("value"));
    })
  }
}
