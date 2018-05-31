/* B30_1881557Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1881557Test extends ZTL4ScalaTestCase {
  @Test
  def testtestboxOnchange() = {
    var zscript =
      """
<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
<n:ol>
		<n:li>Clicks textbox (to gain focus), </n:li>
		<n:li>Clicks other place (to lose focus), and then you shall see nothing happen.<n:br />(if a messagebox is shown, that's wrong. )</n:li>

</n:ol>
<window>
	<textbox id="test" onChange='alert("1");' constraint="no negative,no zero"/>
</window>
</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val test = ztl$engine.$f("test")
    runZTL(zscript, () => {
      /**
        * 2010/10/27:TonyQ
        *
        * @browsers ie6,ie7,ie8,chrome,firefox,safari402
        * @version zk505
        */
      var $test = jq("$test")
      focus($test)
      blur($test)
      waitResponse()
      // There should only exist the main window,
      // if there appear two window , that means the alert is out ,
      // and that's incorrect for our test case!
      verifyEquals(jq("@window").length(), 1)
      //make ture the focus and blur works , we test another case.
      focus($test)
      typeKeys($test, "123")
      blur($test)
      waitResponse()
      verifyEquals(jq("@window").length(), 2)
    })
  }
}



