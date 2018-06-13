/* B36_2805177Test.java

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


class B36_2805177Test extends ZTL4ScalaTestCase {
  @Test
  def testbodyHeight() = {
    var zscript =
      """
			<zk>
			<div><label style='font-size:20px;' value="You should see the two headers only, no body's height are displayed (IE only)"/> </div>
			
			<listbox>
			<listhead>
			<listheader label='column 1'/>
			<listheader label='column 2'/>
			<listheader label='column 3'/>
			<listheader label='column 4'/>
			<listheader label='column 5'/>
			</listhead>
			</listbox>
			
			<separator/>
			
			<grid>
			<columns>
			<column label='column 1'/>
			<column label='column 2'/>
			<column label='column 3'/>
			<column label='column 4'/>
			<column label='column 5'/>
			</columns>
			<rows>
			</rows>
			</grid>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyTolerant(0, jq("div.z-listbox-body").outerHeight(), 1)
      verifyTolerant(0, jq("div.z-grid-body").outerHeight(), 1)
    })
  }
}



