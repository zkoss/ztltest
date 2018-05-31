/* B30_1886788Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1886788Test extends ZTL4ScalaTestCase {
  @Test
  def testWidth() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>Grid rows not follow columns's widths when it has the auxhead component.</n:p>
				<grid height="100px">
					<auxhead>
						<auxheader label="Selecteds Items (Grid)" colspan="9"
							align="center" />
					</auxhead>
					<columns>
						<column id="column0" label="70px" width="70px" />
						<column id="column1" label="75px" width="75px" />
						<column id="column2" label="75px" width="75px" />
						<column id="column3" label="150px" width="150px" />
						<column id="column4" label="107px" width="107px" />
						<column id="column5" label="120px" width="120px" />
						<column id="column6" label="115px" width="115px" />
						<column id="column7" label="50px" width="50px" />
						<column id="column8" label="80px" width="80px" />
					</columns>
					<rows>
						<row>
							<label id="label0" value="1" />
							<label id="label1" value="2" />
							<label id="label2" value="3" />
							<label id="label3" value="4" />
							<label id="label4" value="5" />
							<label id="label5" value="6" />
							<label id="label6" value="7" />
							<label id="label7" value="8" />
							<label id="label8" value="9" />
						</row>
					</rows>
				</grid>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val column0 = ztl$engine.$f("column0")
    val column1 = ztl$engine.$f("column1")
    val column2 = ztl$engine.$f("column2")
    val column3 = ztl$engine.$f("column3")
    val column4 = ztl$engine.$f("column4")
    val column5 = ztl$engine.$f("column5")
    val column6 = ztl$engine.$f("column6")
    val column7 = ztl$engine.$f("column7")
    val column8 = ztl$engine.$f("column8")
    val label0 = ztl$engine.$f("label0")
    val label1 = ztl$engine.$f("label1")
    val label2 = ztl$engine.$f("label2")
    val label3 = ztl$engine.$f("label3")
    val label4 = ztl$engine.$f("label4")
    val label5 = ztl$engine.$f("label5")
    val label6 = ztl$engine.$f("label6")
    val label7 = ztl$engine.$f("label7")
    val label8 = ztl$engine.$f("label8")
    runZTL(zscript, () => {
      var w = jq("@row").toWidget().firstChild()
      for (i <- 0 until 9) {
        verifyTolerant(jq("$column" + i).width(), jq(w.$n("chdextr")).width(), 5)
        w = w.nextSibling()
      }
    })
  }
}



