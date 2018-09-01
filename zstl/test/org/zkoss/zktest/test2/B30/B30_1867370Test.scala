/* B30_1867370Test.java

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


class B30_1867370Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
[ 1867370 ] If column hid, each cell should be hidden at paging mold

	<grid id="grid" mold="paging" pageSize="2">
		<columns sizable="true">
			<column label="Type" />
			<column id="col1" label="Content1" />
			<column label="Content2" />
		</columns>
		<rows>
			<row>
				<label value="File:" />
				<textbox width="99%" />
				<label value="File:" />
			</row>
			<row>
				<label value="Type:" />
				<hbox>
					<listbox rows="1" mold="select">
						<listitem label="Java Files,(*.java)" />
						<listitem label="All Files,(*.*)" />
					</listbox>
					<button label="Browse..." />
				</hbox>
				<label value="File:" />
			</row>
			<row>
				<label value="Options:" />
				<textbox rows="3" width="99%" />
				<label value="File:" />
			</row>
		</rows>
	</grid>
	<button id="mybutton" label="hide/show" onClick='col1.visible = !col1.visible;' />
</zk>


		"""
    val ztl$engine = engine()
    val grid = ztl$engine.$f("grid")
    val col1 = ztl$engine.$f("col1")
    val mybutton = ztl$engine.$f("mybutton")
    runZTL(zscript, () => {
      click(mybutton)
      waitResponse()
      verifyEquals(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth())
      verifyEquals(0, jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth())
      click(jq("@paging").find(".z-paging-next"))
      waitResponse()
      verifyEquals(1, jq(".z-row").length())
      verifyEquals(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth())
      click(jq("@paging").find(".z-paging-previous"))
      waitResponse()
      verifyEquals(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth())
      verifyEquals(0, jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth())
      click(mybutton)
      waitResponse()
      verifyNotEquals(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth())
      verifyNotEquals(0, jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth())
      click(jq("@paging").find(".z-paging-next"))
      waitResponse()
      verifyNotEquals(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth())
      click(jq("@paging").find(".z-paging-previous"))
      waitResponse()
      verifyNotEquals(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth())
      verifyNotEquals(0, jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth())
    })
  }
}



