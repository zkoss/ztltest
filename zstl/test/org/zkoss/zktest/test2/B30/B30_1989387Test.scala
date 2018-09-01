/* B30_1989387Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1989387Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
<button label="It doesn't show any error after Click the button">
<attribute name="onClick">
c.detach();
new Center().setParent(b);
</attribute>
</button>
<borderlayout id="b" height="300px">
			<west maxsize="600" size="30%" flex="true" border="0" splittable="true">
				<div style="background:#E6D92C">
					<label value="30%"
						style="color:white;font-size:50px" />
				</div>
			</west>
			<center id="c">
				<label value="Here is a border"
					style="color:gray;font-size:30px" />
			</center>
			<east size="30%" flex="true" border="0" collapsible="true">
				<div style="background:#B8D335">
					<label value="30%"
						style="color:white;font-size:50px" />
				</div>
			</east>
		</borderlayout>
</zk>

		"""
    val ztl$engine = engine()
    val b = ztl$engine.$f("b")
    val c = ztl$engine.$f("c")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      verifyFalse(jq("@window").exists())
    })
  }
}



