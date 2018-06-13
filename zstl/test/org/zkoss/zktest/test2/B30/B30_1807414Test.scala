/* B30_1807414Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1807414Test extends ZTL4ScalaTestCase {
  @Test
  def testModel() = {
    var zscript =
      """
<window title="Test of setModel with declared content" border="normal">
	<label value="Version: ${desktop.webApp.version}"/>
	<zscript><![CDATA[
	import org.zkoss.util.Pair;
	
	List infos = new LinkedList();
	for (int j = 0; j < 5; ++j) {
		infos.add(new Pair("A" + j, "B" + j));
	}
	ListModelList model = new ListModelList(infos);
	]]></zscript>
	
	<grid id="x" >
	<rows>
	<row>
	<textbox value="ABC"/><textbox value="DEF"/><textbox value="YYY"/>
	</row>
	</rows>
	</grid>
	<zscript>
	x.setModel(model);
	</zscript>

	<separator/>

	<listbox id="y">
	<listitem>
	<listcell>
	<textbox value="A"/>
	</listcell>
	<listcell>
	<textbox value="B"/>
	</listcell>
	</listitem>
	</listbox>
	<zscript>
	y.setModel(model);
	</zscript>
</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val x = ztl$engine.$f("x")
    val y = ztl$engine.$f("y")
    runZTL(zscript, () => {
      //we cant compare for (A0,B0) because there exist the &nbsp; would cause problems.
      //so we use some trick instead here.
      for (i <- 0 until 5) {
        //verifyEquals("(A0,B0)", jq("@row:eq(0) @label").text())
        var text = jq("@row:eq(" + i + ") @label").text()
        verifyTrue(text.indexOf("A" + i) != -1)
        verifyTrue(text.indexOf("B" + i) != -1)
      }
      verifyEquals("5", x.getChild("rows").nChildren())
      for (i <- 0 until 5) {
        //verifyEquals("(A0,B0)", jq("@listitem:eq(0) div").text())
        var text = jq("@listitem:eq(" + i + ") div").text()
        verifyTrue(text.indexOf("A" + i) != -1)
        verifyTrue(text.indexOf("B" + i) != -1)
      }
      verifyEquals("5", y.nChildren())
    })
  }
}



