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
import org.zkoss.ztl.Tags;
import org.openqa.selenium.Keys

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_Issue_F0013 extends ZTL4ScalaTestCase {
	def testIssue() = {
		val zul = {
				<window apply="org.zkoss.zktest.zbind.issue.F0013" xmlns:n="http://www.zkoss.org/2005/zk/native">
				<custom-attributes composerName="vm"/>
				<div>
				1.when click on cmd1, value in row 1 will all be appended -cmd1<n:br/>
				2.when click on cmd2, value in row 1/2 will all be appended -cmd2<n:br/>
				</div>
				<hbox>Row 1
				<label id="l1" value="@bind(vm.value1)" />
				<label id="l2" value="@bind(vm.value2)" />
				</hbox>
				<hbox self="@form(id='fx', load=vm, save={vm before 'cmd1',vm before 'cmd2',vm before 'cmd3'})">
				Row 2
				<textbox id="t1" value="@bind(fx.value1)" />
				<textbox id="t2" value="@bind(fx.value2)" />
				</hbox>
				<hbox>
				<button id="btn1" label="cmd1" onClick="@bind('cmd1')"/>
				<button id="btn2" label="cmd2" onClick="@bind('cmd2')"/>
				<button id="btn3" label="cmd3" onClick="@bind('cmd3')"/>
				<button label="Dump" onClick="binder.getTracker().dump()" />
				</hbox>	
				</window>
		}
		runZTL(zul, () => {
			val l1 = engine $f "l1"
			val l2 = engine $f "l2"
			val t1 = engine $f "t1"
			val t2 = engine $f "t2"

			verifyEquals("A",l1)
			verifyEquals("B",l2)
			verifyEquals("A",t1)
			verifyEquals("B",t2)
//			Assert.assertEquals("A",findWidget("$l1").getValue());
//			Assert.assertEquals("B",findWidget("$l2").getValue());
//			Assert.assertEquals("A",findWidget("$t1").getValue());
//			Assert.assertEquals("B",findWidget("$t2").getValue());

			`type`(t1,"Dennis")
			`type`(t1,"Chen")
			click(engine $f "btn1")
			waitResponse()
			verifyEquals("Dennis-cmd1",l1)
			verifyEquals("Chen-cmd1",l2)
			verifyEquals("Dennis",t1)
			verifyEquals("Chen",t2)
//			findWidget("$t1").clear().keys("Dennis");
//			findWidget("$t2").clear().keys("Chen");
//			findWidget("$btn1").click();
//			Assert.assertEquals("Dennis-cmd1",findWidget("$l1").getValue());
//			Assert.assertEquals("Chen-cmd1",findWidget("$l2").getValue());
//			Assert.assertEquals("Dennis",findWidget("$t1").getValue());
//			Assert.assertEquals("Chen",findWidget("$t2").getValue());

			`type`(t1,"Alice")
			`type`(t2,"Wu")
			click(engine $f "btn2")
			verifyEquals("Alice-cmd2",l1)
			verifyEquals("Wu-cmd2",l2)
			verifyEquals("Alice-cmd2",t1)
			verifyEquals("Wu-cmd2",t2)			
//			findWidget("$t1").clear().keys("Alice");
//			findWidget("$t2").clear().keys("Wu");
//			findWidget("$btn2").click();
//			Assert.assertEquals("Alice-cmd2",findWidget("$l1").getValue());
//			Assert.assertEquals("Wu-cmd2",findWidget("$l2").getValue());
//			Assert.assertEquals("Alice-cmd2",findWidget("$t1").getValue());
//			Assert.assertEquals("Wu-cmd2",findWidget("$t2").getValue());

			`type`(t1,"Jumper")
			`type`(t2,"Tj")
			click(engine $f "btn3")
			verifyEquals("Jumper-cmd3",l1)
			verifyEquals("Tj-cmd3",l2)
			verifyEquals("Jumper-cmd3",t1)
			verifyEquals("Tj-cmd3",t2)
			
//			findWidget("$t1").clear().keys("Jumper");
//			findWidget("$t2").clear().keys("Tj");
//			findWidget("$btn3").click();
//			Assert.assertEquals("Jumper-cmd3",findWidget("$l1").getValue());
//			Assert.assertEquals("Tj-cmd3",findWidget("$l2").getValue());
//			Assert.assertEquals("Jumper-cmd3",findWidget("$t1").getValue());
//			Assert.assertEquals("Tj-cmd3",findWidget("$t2").getValue());

		})
	}
}
