/* B30_1804356Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1804356Test extends ZTL4ScalaTestCase {
  @Test
  def testDatabinding() = {
    var zscript =
      """
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<zk	xmlns:h="http://www.w3.org/1999/xhtml" xmlns:zk="http://www.zkoss.org/2005/zk">
<html><![CDATA[
Make a textbox databinding access:load only. (This bug used to cause NullPointerException)<br/>
1. You should see ZK inside a textbox and a label after the textbox.<br/>
2. Change the contents of the textbox and then tab away.<br/>
3. Nothing happens means it is correct.<br/>
]]></html>

<zscript>
	String val = "ZK";
</zscript>
<vbox>
<textbox id="tb" value="@{val,access=load}"/>
<label id="label" value="@{val}"/>
</vbox>
</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tb = ztl$engine.$f("tb")
    val label = ztl$engine.$f("label")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      verifyEquals("ZK", jq(tb).`val`())
      verifyEquals("ZK", jq(label).html())
      `type`(tb, "Test")
      verifyEquals("Test", jq(tb).`val`())
      verifyEquals("ZK", jq(label).html())
      verifyFalse(jq(".z-error").exists())
    })
  }
}



