/* B30_1963607Test.java

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


class B30_1963607Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window title="Load more than one page at a time">
	<paging pageSize="5" id="pg"/>
	<listbox id="l" mold="paging" paginal="${pg}">
	<listhead/>
	</listbox>
	<button label="Test Listbox">
	 <attribute name="onClick"><![CDATA[
	 for (int i = 0; i < 6; i++)
		 new Listitem("li"+i).setParent(l);
	 ]]></attribute>
	</button>
	<grid mold="paging" pageSize="5">
		<columns/>
		<rows id="rows"/>
	</grid>
	<button label="Test Grid">
	 <attribute name="onClick"><![CDATA[
	 for (int i = 0; i < 6; i++) {
		 Row r= new Row();
		 new Label("r" + i).setParent(r);
		 r.setParent(rows);
	 }
	 ]]></attribute>
	</button>
	
</window>

		"""
    val ztl$engine = engine()
    val pg = ztl$engine.$f("pg")
    val l = ztl$engine.$f("l")
    val rows = ztl$engine.$f("rows")
    runZTL(zscript, () => {
      click(jq("@button:eq(0)"))
      waitResponse()
      verifyNotEquals("/ 1", jq("span.z-paging-text:first").text())
      verifyEquals(5, jq("@listitem:visible").length())
      click(jq("@button:eq(1)"))
      waitResponse()
      verifyNotEquals("/ 1", jq("span.z-paging-text:last").text())
      verifyEquals(5, jq("@row:visible").length())
    })
  }
}



