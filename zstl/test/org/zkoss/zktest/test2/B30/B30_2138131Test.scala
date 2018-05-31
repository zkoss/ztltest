/* B30_2138131Test.java

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
import org.zkoss.ztl.Widget


class B30_2138131Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
<zscript><![CDATA[
//@DECLARATION
public class MyComposer extends org.zkoss.zk.ui.util.GenericForwardComposer {
	public void onClick$btn() {
		alert("Hi! w2.");
	}
}
]]>
MyComposer mycomp = new MyComposer();
</zscript>
<html><![CDATA[
<p>Load this page and there is no exception message, then it is correct.</p>               
]]>
</html>
<window title="ztl" id="w2" apply="${mycomp}">
	<label value="Hello! GenericForwardComposer"/>
</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val w2 = ztl$engine.$f("w2")
    runZTL(zscript, () => {
      verifyFalse(jq("@window:not(@window[title=\"ztl\"])").exists())
    })
  }
}



