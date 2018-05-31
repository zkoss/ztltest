/* B50_3005632Test.java

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


class B50_3005632Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<window>
<html>
<![CDATA[
<ol>
<li>You shall see listbox with item0~item9</li>
<li>Press "Replace with empty model" button, you shall see the listbox contents are clear to empty(white background).</li>
<li>If not, it is a bug.</li>
</ol>
]]>
</html>
<zscript><![CDATA[
List lst = new ArrayList(120);
ListModel model = new ListModelList(lst, true);
for(int j = 0; j < 120; ++j) {
lst.add("item"+ j);
}
]]></zscript>
<listbox id="lb" model="${model}" rows="10"/>
<button id="btn" label="Replace with empty model" onClick='lb.setModel(new ListModelList(new ArrayList()))'/>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lb = ztl$engine.$f("lb")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyFalse(jq("@listitem").exists())
    })
  }
}



