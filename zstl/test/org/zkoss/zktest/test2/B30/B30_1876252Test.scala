/* B30_1876252Test.java

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
import org.zkoss.ztl.Widget


class B30_1876252Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
	<div>
		<label value="This case tests height of listbox is properly or not. First listbox's rows=1, it means height of this listbox
		equals one row's height." />
		<separator height="8px" />
		<listbox rows="1">
			<listitem label="Rows=1" />
		</listbox>
		<separator height="20px" />
		<label value="If height of the following listbox can contain 2 rows, it is correct. You can use mouse over 'Rows=2' to 
		check a row's height of this listbox." />
		<separator height="8px" />
		<listbox rows="2">
			<listitem label="Rows=2" />
		</listbox>
	</div>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      var rowHeight = jq(".z-listitem").height()
      //make sure the row height in second listbox is same as first.
      verifyEquals(rowHeight, jq(".z-listitem:eq(1)").height())
      //breeze ie8's height will bigger then listrow for 2px .
      //I am not sure it's a spec or not.
      verifyTolerant(rowHeight, jq(".z-listbox:eq(0)").height(), 2)
      //something the rowHeight will be odd, so have a tolerant 1.
      verifyTolerant(rowHeight * 2, jq(".z-listbox:eq(1)").height(), 2)
    })
  }
}



