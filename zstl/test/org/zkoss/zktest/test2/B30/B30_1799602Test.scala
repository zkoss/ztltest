/* B30_1799602Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1799602Test extends ZTL4ScalaTestCase {
  @Test
  def testForEach() = {
    var zscript =
      """
<window>
If the popup of combox out of position, that is wrong.
	<tabbox width="100%">
		<tabs>
			<tab label="Geral" />
		</tabs>
		<tabpanels>
			<tabpanel height="240px">
				<grid>
					<rows>
						<row>
							<combobox id="cb" width="150px" readonly="true">
								<comboitem label="Pessoa Física" />
								<comboitem label="Pessoa Jurídica" />
							</combobox>
						</row>
					</rows>
				</grid>
			</tabpanel>
		</tabpanels>
	</tabbox>
</window>
		"""
    val ztl$engine = engine()
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      var offset1x = zk(cb).eval("revisedOffset()[0]")
      var offset1y = zk(cb).eval("revisedOffset()[1]")
      click(cb.$n("btn"))
      var offset2x = zk(cb.$n("pp")).eval("revisedOffset()[0]")
      var offset2y = zk(cb.$n("pp")).eval("revisedOffset()[1]")
      verifyEquals(offset1x, offset2x);
      verifyTolerant(parseInt(offset1y) + jq(cb).outerHeight(), offset2y, 2)
    })
  }
}



