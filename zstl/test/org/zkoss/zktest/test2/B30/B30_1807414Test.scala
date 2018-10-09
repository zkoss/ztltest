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
    val ztl$engine = engine()
    val x = ztl$engine.$f("x")
    val y = ztl$engine.$f("y")
    runZTL(zscript, () => {
      for (i <- 0 until 5) {
        var textR = jq("@row").eq(i).find("@label").text()
        verifyContains(textR, "A" + i)
        verifyContains(textR, "B" + i)
      }
      verifyEquals("5", x.getChild("rows").nChildren())
      for (i <- 0 until 5) {
        var textL = jq("@listitem").eq(i).find("div").text()
        verifyContains(textL, "A" + i)
        verifyContains(textL, "B" + i)
      }
      verifyEquals("5", y.nChildren())
    })
  }
}