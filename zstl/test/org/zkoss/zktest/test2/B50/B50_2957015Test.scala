/* B50_2957015Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2957015Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<window title="Hello World!!" border="normal" width="300px"
	height="200px">
	<grid id="grid1">
		<rows>
			<row>
				<detail id="detail">
					<grid id="grid">
						<columns>
							<column width="15%" />
							<column width="35%" />
							<column width="15%" />
							<column width="35%" />
						</columns>
						<rows>
							<row>
								<label value="Sender:" />
								<bandbox id="bd" width="98%">
									<bandpopup>
										<listbox width="200px"
											onSelect="bd.value=self.selectedItem.label; bd.close();">
											<listitem>
												<listcell label="John" />
											</listitem>
											<listitem>
												<listcell label="Joe" />
											</listitem>
											<listitem>
												<listcell label="Mary" />
											</listitem>
										</listbox>
									</bandpopup>
								</bandbox>
								<label value="Receiver:" />
								<textbox width="98%" />
							</row>
						</rows>
					</grid>
				</detail>
				<label value="Query" />
			</row>
		</rows>
	</grid>
	1.(IE8 only)Please open the detail via (+/-), and then press the magnifier icon.
	<separator/>
	2. The grid's height should not increase.
</window>

			"""
    val ztl$engine = engine()
    val grid1 = ztl$engine.$f("grid1")
    val detail = ztl$engine.$f("detail")
    val grid = ztl$engine.$f("grid")
    val bd = ztl$engine.$f("bd")
    runZTL(zscript, () => {
      click(detail.$n("icon"))
      var x = jq(grid1).height()
      click(bd.$n("btn"))
      waitResponse()
      verifyEquals(x, jq(grid1).height())
    })
  }
}



