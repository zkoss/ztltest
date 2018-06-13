/* B50_3183438Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3183438Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<zk>
	<html><![CDATA[
		<ol>
			<li>The Textbox and Label should show value "B".</li>
			<li>Change Textbox value to "C" and click on somewhere else. The Label value should also become "C". Otherwise it is a bug.</li>
		</ol>
	]]></html>
	<zscript>
		java.util.Map map1 = new java.util.HashMap();
		java.util.Map map2 = new java.util.HashMap();
		map1.put("class", map2);
		map2.put("class", "B");
	</zscript>
	<textbox value="@{map1.class.class}" />
	<label value="@{map1.class.class}" />
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      verifyEquals("B", jq(".z-textbox").`val`())
      verifyEquals("B", jq("@label").text())
      typeKeys(jq("@textbox"), "C")
      waitResponse()
      verifyEquals("C", jq(".z-textbox").`val`())
      verifyEquals("C", jq("@label").text())
    })
  }
}



