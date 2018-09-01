/* B50_3086343Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3086343Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk xmlns:n="native">
<zscript>
void change(Div d) {
	parent.insertBefore(d, parent.firstChild);
}
</zscript>
Please click the blue area, it shall become the first child.
Then click the red area, it shall become the first child.
<div id="parent">
	<div id="first" onClick="change(self)" style="background:red">
		<n:h1>Item A.1</n:h1>
		<n:h1>Item A.2</n:h1>
		<n:h1>Item A.3</n:h1>
	</div>
	<div id="second" onClick="change(self)" style="background:blue">
		<n:h1>Item B.1</n:h1>
		<n:h1>Item B.2</n:h1>
		<n:h1>Item B.3</n:h1>
	</div>
</div>
</zk>

		"""
    val ztl$engine = engine()
    val parent = ztl$engine.$f("parent")
    val first = ztl$engine.$f("first")
    val second = ztl$engine.$f("second")
    runZTL(zscript, () => {
      for (i <- 0 until 3) {
        var y = i + 1
        verifyEquals("Item B." + y, jq("div > div > div:eq(1) > h1:eq(" + i + ")").text())
      }
      clickAt(second, "10,10")
      waitResponse()
      for (i <- 0 until 3) {
        var y = i + 1
        verifyEquals("Item A." + y, jq("div > div > div:eq(1) > h1:eq(" + i + ")").text())
      }
    })
  }
}



