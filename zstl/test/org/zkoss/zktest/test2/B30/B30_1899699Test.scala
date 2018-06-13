/* B30_1899699Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{JQuery, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._


class B30_1899699Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
	<zk:window xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:zk="http://www.zkoss.org/2005/zul"
		xmlns:a="http://www.zkoss.org/2005/zk/annotation"
		xsi:schemaLocation="http://www.zkoss.org/2005/zul
http://www.zkoss.org/2005/zul/zul.xsd "
		id="prova" border="normal" width="100%" height="250"
		contentStyle="position:relative;">
		<zk:label value="Check column size in listbox is correct"></zk:label>
		<zk:listbox id="vociPreventivoList" rows="10" width="100%">
			<zk:listhead>
				<zk:listheader width="20%" label="Descrizione (20%)"
					align="right" />
				<zk:listheader width="10%" label="Quantita(10" align="right" />
				<zk:listheader width="20%" label="Imponibile (20%)"
					align="right" />
				<zk:listheader width="20%" label="Iva(20%)" align="right" />
				<zk:listheader width="20%" label="Totale (20%)" align="right" />
			</zk:listhead>
			<zk:listitem>
				<zk:listcell>aaa</zk:listcell>
				<zk:listcell>aaa</zk:listcell>
				<zk:listcell>aaa</zk:listcell>
				<zk:listcell>aaa</zk:listcell>
				<zk:listcell>aaa</zk:listcell>
			</zk:listitem>
			<zk:listitem>
				<zk:listcell>bbb</zk:listcell>
				<zk:listcell>bbb</zk:listcell>
				<zk:listcell>bbb</zk:listcell>
				<zk:listcell>bbb</zk:listcell>
				<zk:listcell>bbb</zk:listcell>
			</zk:listitem>
		</zk:listbox>
	</zk:window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val prova = ztl$engine.$f("prova")
    val vociPreventivoList = ztl$engine.$f("vociPreventivoList")
    runZTL(zscript, () => {
      var fullwidth = jq("@listhead").width()
      var percents = Array(20, 10, 20, 20, 20)
      for (i <- 0 until jq("@listheader").length) {
        var jq$header: JQuery = jq("@listheader").eq(i)
        verifyTolerant(percents(i), jq$header.width() * 100 / fullwidth, 2)
      }
      for (k <- 0 until 2) {
        var jqselector = "@listitem:eq(" + k + ") @listcell"
        var m = 0
        for (m <- 0 until jq(jqselector).length) {
          var jq$listcell: JQuery = jq(jqselector).eq(m)
          verifyTolerant(percents(m), jq$listcell.width() * 100 / fullwidth, 2)
        }
      }
    })
  }
}



