/* B30_1948963Test.java

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


class B30_1948963Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
	<n:ol>
		<n:li>Type a time into the Timebox, then click the button, then you should not see any error box.</n:li>
	</n:ol>
	<window title="My First Window" border="normal" width="200px">
	<timebox id="time"/>
	<button label="validate" onClick="validate()"/>
	<zscript>
	void validate()
	{
	if(time.getValue() == null)
		throw new WrongValueException(time, &quot;Empty&quot;);
	}
	</zscript>
	</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val time = ztl$engine.$f("time")
    runZTL(zscript, () => {
      focus(jq("@timebox").toWidget().$n("real"))
      click(jq("@timebox").toWidget().$n("btn-up"))
      blur(jq("@timebox").toWidget().$n("real"))
      waitResponse()
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq(".z-errorbox").exists())
    })
  }
}



