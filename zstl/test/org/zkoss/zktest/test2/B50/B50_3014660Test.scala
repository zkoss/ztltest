/* B50_3014660Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_3014660Test extends ZTL4ScalaTestCase {
  @Test
  def testonChanging() = {
    var zscript =
      """
<zk>
Please type "abx" into the combobox, and then you should see "ab" in the combobox.
<combobox id="combo" autodrop="true">
<attribute name="onChanging"><![CDATA[
if (event.getValue().equals("abx")) {
self.setValue("ab");
}
]]></attribute>
</combobox>
<zscript><![CDATA[
String[] _dict = { "abacus", "accuracy" };
ListModel dictModel = new SimpleListModel(_dict);
combo.setModel(dictModel);
]]></zscript>
</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val combo = ztl$engine.$f("combo")
    runZTL(zscript, () => {
      focus(combo)
      typeKeys(combo.$n("real"), "abx");
      waitResponse()
      verifyEquals("ab", jq(combo.$n("real")).`val`());
    })
  }
}



