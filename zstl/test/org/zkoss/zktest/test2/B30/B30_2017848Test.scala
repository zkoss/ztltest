/* B30_2017848Test.java

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
import org.zkoss.ztl.Widget


class B30_2017848Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?page id="testZul" title=" New ZUL Title" cacheable="false" 
	language="xul/html" zscriptLanguage="Java" contentType="text/html;charset=UTF-8"?>
<zk>
	<html><![CDATA[
		<ol>
			<li>You should see listbox with item0 to item19.</li>
			<li>Press Button "remove 1st item" and you should see the 1st item (item0) is removed from the listbox.</li>
			<li>Press the button again, you should see item1 is removed.</li>
		</ol>
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
	<button label="remove 1st item" 
		onClick='Iterator it = model.iterator(); it.next(); it.remove()'/>
	</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
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



