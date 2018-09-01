/* B30_2018378Test.java

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
import org.zkoss.ztl.unit.Widget


class B30_2018378Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?page id="testZul" title=" New ZUL Title" cacheable="false" 
	language="xul/html" zscriptLanguage="Java" contentType="text/html;charset=UTF-8"?>
<zk>
<html><![CDATA[
1. You should see listbox with item0 ~ item19.<br/>
2. Press buton "remove previous item" and you should see the 1st item is removed
from the listbox (item0).<br/>
3. Press the button again, you should see item1 is removed.<br/>
4. Done.<br/>
]]></html>
<window>
<zscript><![CDATA[
List lst = new ArrayList(20);
ListModel model = new ListModelList(lst, true);
for(int j = 0; j < 20; ++j) {
lst.add("item"+ j);
}
]]></zscript>
<listbox model="${model}" rows="10"/>
<button label="remove previous item" onClick='Iterator it = model.listIterator(1);
it.previous(); it.remove();'/>
</window>
</zk>

		"""
    val ztl$engine = engine()
    val testZul = ztl$engine.$f("testZul")
    runZTL(zscript, () => {
      verifyEquals("item0", jq("@listitem:first").text())
      click(jq("@button"));
      waitResponse()
      verifyEquals("item1", jq("@listitem:first").text())
      click(jq("@button"));
      waitResponse()
      verifyEquals("item2", jq("@listitem:first").text())
    })
  }
}



