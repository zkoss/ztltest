/* B36_2820527Test.java

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


class B36_2820527Test extends ZTL4ScalaTestCase {
  @Test
  def testdisableColumn() = {
    var zscript =
      """
			<zk>
			<window title="test" mode="modal" border="normal" height="95%" width="95%"
			  maximizable="true" closable="true" sizable="true" top="0px">Mouse-over the "Author" label to click the extra menu icon, and uncheck one of the menu-items, and then it should work as expected
			  <grid>
			    <columns menupopup="auto">
			      <column id="col0" label="Author"/>
			      <column id="col1" label="Title"/>
			      <column id="col2" label="Publisher"/>
			      <column id="col3" label="Hardcover"/>
			    </columns>
			    <rows>
			      <row>
			        <label value="Philip Hensher"/>
			        <label value="The Northern Clemency"/>
			        <label value="Knopf (October 30, 2008)"/>
			        <label value="608 pages"/>
			      </row>
			      <row>
			        <label value="Philip Hensher"/>
			        <label value="The Fit"/>
			        <label value="HarperPerennial (April 4, 2005)"/>
			        <label value="240 pages"/>
			      </row>
			    </rows>
			  </grid>
			  <grid>
			    <columns menupopup="auto">
			      <column id="col4" label="Author"/>
			      <column label="Title"/>
			    </columns>
			    <rows>
			      <row>
			        <label>test</label>
			        <textbox/>
			      </row>
			    </rows>
			  </grid>
			</window>
			</zk>
		"""
    val ztl$engine = engine()
    val col0 = ztl$engine.$f("col0")
    val col1 = ztl$engine.$f("col1")
    val col2 = ztl$engine.$f("col2")
    val col3 = ztl$engine.$f("col3")
    val col4 = ztl$engine.$f("col4")
    runZTL(zscript, () => {
      mouseOver(col0.$n("btn"))
      click(col0.$n("btn"))
      waitResponse()
      click(jq("@menuitem[label=\"Hardcover\"]").toWidget().$n("a"))
      waitResponse()
      verifyEquals("collapse", jq(jq("@column[label=\"Hardcover\"]").toWidget().$n("hdfaker")).css("visibility"))
      mouseOver(col0.$n("btn"))
      click(col0.$n("btn"))
      waitResponse()
      click(jq("@menuitem[label=\"Publisher\"]").toWidget().$n("a"))
      waitResponse()
      verifyEquals("collapse", jq(jq("@column[label=\"Publisher\"]").toWidget().$n("hdfaker")).css("visibility"))
      mouseOver(col0.$n("btn"))
      click(col0.$n("btn"))
      waitResponse()
      click(jq("@menuitem[label=\"Title\"]").toWidget().$n("a"))
      waitResponse()
      verifyEquals("collapse", jq(jq("@column[label=\"Title\"]:eq(0)").toWidget().$n("hdfaker")).css("visibility"))
      mouseOver(col4.$n("btn"))
      click(col4.$n("btn"))
      waitResponse()
      click(jq("@menuitem[label=\"Title\"]").toWidget().$n("a"))
      waitResponse()
      verifyEquals("collapse", jq(jq("@column[label=\"Title\"]:eq(1)").toWidget().$n("hdfaker")).css("visibility"))
    })
  }
}



