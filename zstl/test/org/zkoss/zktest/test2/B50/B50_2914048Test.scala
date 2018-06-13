/* B50_2914048Test.java

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


class B50_2914048Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
1.Please click "orient" button, and then click "append" button.
<separator/>
2. You can see that the new "Append 1" label is added next to "Second"
<box id="box">
First
<label value="Second"/>
</box>
<zscript>int cnt;
</zscript>
<button label="orient" onClick='box.setOrient(box.vertical?"horizontal":"vertical")'/>
<button label="append" onClick='new Label("Append "+ ++cnt).setParent(box)'/>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val box = ztl$engine.$f("box")
    runZTL(zscript, () => {
      click(jq("@button[label=\"orient\"]"))
      waitResponse()
      click(jq("@button[label=\"append\"]"))
      waitResponse()
      var s1 = jq("@label[value=\"Second\"]").parent().next().next().html()
      var s2 = jq("@label[value=\"Append 1\"]").parent().html()
      verifyEquals(s1, s2);
    })
  }
}



