/* B50_3058028Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 14:18:15 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test
import org.zkoss.ztl.Element
import org.zkoss.ztl.JQuery
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.Scripts
import org.zkoss.ztl.Widget
import org.zkoss.ztl.ZK
import org.zkoss.ztl.ZKClientTestCase
import java.lang._
import java.util.Calendar
import java.util.List
import java.util.ArrayList;
import org.openqa.selenium.Keys

/**
 * A test class for bug 3058028
 * @author benbai
 *
 */
@Tags(tags = "B50-3058028.zul, Unstable")
class B50_3058028Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
<zk>
	<html><![CDATA[
	<ul>
	<li>Test environment: IE</li>
	<li>Press TAB to change focus to "bb"</li>
	<li>Press TAB again and the focus shall switch to "cc"</li>
	</ul>
	]]></html>
	
	<textbox focus="true"/>
	<combobox value="bb">
		<comboitem label="aa"/>
		<comboitem label="bb"/>
	</combobox>
	<combobox value="cc">
		<comboitem label="aa"/>
		<comboitem label="bb"/>
	</combobox>
</zk>
    """

   // Run syntax 2
    runZTL(zscript,
        () => {
			sendKeys(jq("@textbox"), Keys.TAB)
			waitResponse()
			var inp: Element = jq(".z-combobox").toWidget().$n("real")
			verifyTrue(!"".equals(jq(jq(".z-combobox:eq(0)").toWidget().$n("real")).css("box-shadow")))
			sendKeys(inp, Keys.TAB)
			waitResponse()
			verifyTrue(!"".equals(jq(jq(".z-combobox:eq(1)").toWidget().$n("real")).css("box-shadow")))
        }
   )
  }
}