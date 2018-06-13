/* B36_2779453Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2779453Test extends ZTL4ScalaTestCase {
  @Test
  def testcheck() = {
    var zscript =
      """
			<zk>
				Please open the item, and check some checkboxes, then close and open the item, all of the checkboxes you checked should be checked. (IE 6 Only)
				<window title="Detail demo" border="normal" width="450px">
					<grid sizedByContent="true">
						<columns>
							<column label=""></column>
							<column label=""></column>
						</columns>
						<rows>
							<row>
								<label value="Non detail"></label>
								<detail>
									<listbox checkmark="true" multiple="true" sizedByContent="true">
										<listhead>
											<listheader label="Select All"></listheader>
										</listhead>
										<listitem>
											<listcell label="aaaaaaa"></listcell>
										</listitem>
										<listitem>
											<listcell label="ffffffff"></listcell>
										</listitem>
									</listbox>
								</detail>
							</row>
						</rows>
					</grid>
				</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(widget(jq("@detail")).$n("icon"))
      waitResponse()
      click(jq("@listitem:contains(aaaaaaa)").find(".z-listitem-checkbox"))
      waitResponse()
      click(widget(jq("@detail")).$n("icon"))
      waitResponse()
      click(widget(jq("@detail")).$n("icon"))
      waitResponse()
      verifyEquals(1, jq("tr.z-listitem-selected").length())
    })
  }
}



