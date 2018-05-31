/* B50_3192194Test.java

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
import org.zkoss.ztl.Widget


class B50_3192194Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
1. Please click the button "show current selection", you should see the dialog "[David]"
<separator/>
1. Please select the item("Steven") and click the button "show current selection", you should see the dialog "[Steven]"
<separator/>
<combobox id="combobox" width="100px">
		<attribute name="onCreate"><![CDATA[
			List list2 = new ArrayList();
			list2.add("David");
			list2.add("Thomas");
			list2.add("Steven");
			ListModelList lm2 = new ListModelList(list2);
			lm2.addSelection(lm2.get(0));
			combobox.setModel(lm2);
		]]></attribute>
	</combobox>
	<button label="show current selection" onClick="alert(combobox.getModel().getSelection())"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val combobox = ztl$engine.$f("combobox")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyEquals("[David]", getAlertMessage())
      clickAlert()
      waitResponse()
      click(combobox.$n("btn"))
      waitResponse()
      click(jq("@comboitem:eq(2)"))
      waitResponse()
      click(jq("@button"))
      waitResponse()
      verifyEquals("[Steven]", jq(".z-window-highlighted @label").text())
    })
  }
}



