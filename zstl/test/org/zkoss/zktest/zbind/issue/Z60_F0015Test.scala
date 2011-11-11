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
import org.zkoss.ztl.ZKTestCase
import junit.framework.Assert
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_F0015Test extends ZTL4ScalaTestCase {
	def testIssue() = {
		val zul = {
<window apply="org.zkoss.zktest.zbind.issue.F0015" xmlns:n="http://www.zkoss.org/2005/zk/native">
	<custom-attributes composerName="vm"/>
	<div>
	1.click cmd1, only first value change to 'doCommand1' in both row1,2<n:br/>
	2.click cmd1, values change to 'doCommand1' 'doCommand2' 'doCommand3' in both row1,2<n:br/>
	</div>
	<hbox>Row 1
		<label id="l11" value="@bind(vm.value1)" />
		<label id="l12" value="@bind(vm.value2)" />
		<label id="l13" value="@bind(vm.value3)" />
	</hbox>
	<hbox>Row 2
		<label id="l21" value="@bind(load = vm.value1 after 'cmd1')" />
		<label id="l22" value="@bind(load = vm.value2 after 'cmd2')" />
		<label id="l23" value="@bind(load = vm.value3 after 'cmd3')" />
	</hbox>
	<hbox>
		<button id="btn1" label="cmd1" onClick="@bind('cmd1')"/>
		<button id="btn2" label="cmd2" onClick="@bind('cmd2')"/>
		<button label="Dump" onClick="binder.getTracker().dump()" />
	</hbox>	
</window>
		}
		runZTL(zul, () => {
			val l11 = engine $f "l11"
			val l12 = engine $f "l12"
			val l13 = engine $f "l13"
			val l21 = engine $f "l21"
			val l22 = engine $f "l22"
			val l23 = engine $f "l23"
			
			ZKSeleneseTestCase.assertEquals("A",getText(l11))
			ZKSeleneseTestCase.assertEquals("B",getText(l12))
			ZKSeleneseTestCase.assertEquals("C",getText(l13))
			ZKSeleneseTestCase.assertEquals("",getText(l21))
			ZKSeleneseTestCase.assertEquals("",getText(l22))
			ZKSeleneseTestCase.assertEquals("",getText(l23))
//			Assert.assertEquals("A",findWidget("$l11").getValue());
//			Assert.assertEquals("B",findWidget("$l12").getValue());
//			Assert.assertEquals("C",findWidget("$l13").getValue());
//			Assert.assertEquals("",findWidget("$l21").getValue());
//			Assert.assertEquals("",findWidget("$l22").getValue());
//			Assert.assertEquals("",findWidget("$l23").getValue());

			click(engine $f "btn1")
			waitResponse()
			ZKSeleneseTestCase.assertEquals("doCommand1",getText(l11))
			ZKSeleneseTestCase.assertEquals("B",getText(l12))
			ZKSeleneseTestCase.assertEquals("C",getText(l13))
			ZKSeleneseTestCase.assertEquals("doCommand1",getText(l21))
			ZKSeleneseTestCase.assertEquals("",getText(l22))
			ZKSeleneseTestCase.assertEquals("",getText(l23))
//			findWidget("$btn1").click();
//			Assert.assertEquals("doCommand1",findWidget("$l11").getValue());
//			Assert.assertEquals("B",findWidget("$l12").getValue());
//			Assert.assertEquals("C",findWidget("$l13").getValue());
//			Assert.assertEquals("doCommand1",findWidget("$l21").getValue());
//			Assert.assertEquals("",findWidget("$l22").getValue());
//			Assert.assertEquals("",findWidget("$l23").getValue());

			click(engine $f "btn2")
			waitResponse()
			ZKSeleneseTestCase.assertEquals("doCommand1",getText(l11))
			ZKSeleneseTestCase.assertEquals("doCommand2",getText(l12))
			ZKSeleneseTestCase.assertEquals("doCommand3",getText(l13))
			ZKSeleneseTestCase.assertEquals("doCommand1",getText(l21))
			ZKSeleneseTestCase.assertEquals("doCommand2",getText(l22))
			ZKSeleneseTestCase.assertEquals("doCommand3",getText(l23))
//			findWidget("$btn2").click();
//			Assert.assertEquals("doCommand1",findWidget("$l11").getValue());
//			Assert.assertEquals("doCommand2",findWidget("$l12").getValue());
//			Assert.assertEquals("doCommand3",findWidget("$l13").getValue());
//			Assert.assertEquals("doCommand1",findWidget("$l21").getValue());
//			Assert.assertEquals("doCommand2",findWidget("$l22").getValue());
//			Assert.assertEquals("doCommand3",findWidget("$l23").getValue());		  

		})
	}
}
