/* B30_1914184Test.java

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


class B30_1914184Test extends ZTL4ScalaTestCase {
  @Test
  def testalert() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk>
				<grid>
					<columns id="cs">
						<column id="gcola" width="100px" label="A" />
						<column label="B" />
						<column label="C" />
						<column label="D" />
						<column label="E" />
						<column label="F" />
						<column label="G" />
					</columns>
					<auxhead>
						<auxheader id="gPhi" label="Phi" rowspan="2" colspan="2"/>
						<auxheader id="gPi" label="Pi" colspan="2" />
						<auxheader id="gKroc" label="Kroc" colspan="3"/>
					</auxhead>
					<auxhead>
						<auxheader label="Pi" colspan="2" />
						<auxheader label="Kroc" colspan="3"/>
					</auxhead>
					<auxhead>
						<auxheader label="Phi" rowspan="2" colspan="2"/>
						<auxheader label="Pi" colspan="2" />
						<auxheader label="Kroc" colspan="3"/>
					</auxhead>
				</grid>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cs = ztl$engine.$f("cs")
    val gcola = ztl$engine.$f("gcola")
    val gPhi = ztl$engine.$f("gPhi")
    val gPi = ztl$engine.$f("gPi")
    val gKroc = ztl$engine.$f("gKroc")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      verifyFalse(jq(".z-error").exists())
    })
  }
}



