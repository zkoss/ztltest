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

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Element
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug 3058028
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3058028.zul, Unstable")
class B50_3058028Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
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
        verifyNotEquals("", jq(jq(".z-combobox:eq(0)").toWidget().$n("real")).css("box-shadow"))
        sendKeys(inp, Keys.TAB)
        waitResponse()
        verifyNotEquals("", jq(jq(".z-combobox:eq(1)").toWidget().$n("real")).css("box-shadow"))
      }
    )
  }
}