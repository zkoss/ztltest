/* B30_1881550Test.java

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


class B30_1881550Test extends ZTL4ScalaTestCase {
  @Test
  def testStripe() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>Error Stripe with Grid and Listbox in Modal Mode</n:p>
				<window title="Grid Demo" border="normal" width="360px" closable="true">
					<grid>
						<rows>
							<row>
								<label value="File:"/>
								<textbox width="99%"/>
							</row>
							<row>
								<label value="Type:"/>
								<hbox>
									<listbox rows="1" mold="select">
										<listitem label="Java Files,(*.java)"/>
										<listitem label="All Files,(*.*)"/>
									</listbox>
									<button label="Browse..."/>
								</hbox>
							</row>
							<row>
								<label value="Options:"/>
								<textbox rows="3" width="99%"/>
							</row>
						</rows>
					</grid>
					<button id="doModal" label="doModal" onClick="self.parent.doModal();"/>
				</window>	
			</zk>
		"""
    val ztl$engine = engine()
    val doModal = ztl$engine.$f("doModal")
    runZTL(zscript, () => {
      var rowId_01 = jq(".z-rows tr.z-row:eq(1)").attr("id")
      var rowId_02 = jq(".z-grid-odd").attr("id")
      verifyEquals(rowId_01, rowId_02)
      click(doModal)
      waitResponse()
      rowId_01 = jq(".z-rows tr.z-row:eq(1)").attr("id")
      rowId_02 = jq(".z-grid-odd").attr("id")
      verifyEquals(rowId_01, rowId_02)
    })
  }
}



