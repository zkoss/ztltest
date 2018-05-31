/* B50_2943346Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2943346Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
				    <window id="win" title="You should see the first label is 'A long text which is...' " border="normal" width="200px">
				        <zscript>
				            String abc = "A long text which is not truncated even if it should.\n" +
						"Or not?";
				        </zscript>
				        <label id="lb1" maxlength="20" value="${abc}"/>
				        <separator bar="true"/>
				        <label id="lb2" maxlength="20" multiline="true" value="${abc}"/>
				    </window>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val lb1 = ztl$engine.$f("lb1")
    val lb2 = ztl$engine.$f("lb2")
    runZTL(zscript, () => {
      verifyEquals("A long text which is...", jq("span.z-label:eq(0)").text())
    })
  }
}



