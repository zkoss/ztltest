
/* Z60_B01188MixingELWithRef2Test.scala

	Purpose:
		
	Description:
		
	History:
		Jul 3, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01188MixingELWithRef2Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01188MixingELWithRefAll.zul"/>
"""
    runZTL(zul, () => {

      var items = jq("$halyout1").find("@label")
      verifyEquals("0.Item 1", items.eq(0).toWidget().get("value"))
      verifyEquals("1.Item 2", items.eq(1).toWidget().get("value"))

      items = jq("$listbox1").find("@listitem")
      verifyEquals("0.Item 1", items.eq(0).find("@listcell @label").toWidget().get("value"))
      verifyEquals("1.Item 2", items.eq(1).find("@listcell @label").toWidget().get("value"))

      items = jq("$grid1").find("@row")
      verifyEquals("0.Item 1", items.eq(0).find("@label").toWidget().get("value"))
      verifyEquals("1.Item 2", items.eq(1).find("@label").toWidget().get("value"))

      jq("$combobox1").toWidget().eval("open()")
      waitResponse()
      items = jq("$combobox1").find("@comboitem")
      verifyEquals("0.Item 1", items.eq(0).toWidget().get("label"))
      verifyEquals("1.Item 2", items.eq(1).toWidget().get("label"))

      items = jq("$radiogroup1").find("@radio")
      verifyEquals("0.Item 1", items.eq(0).toWidget().get("label"))
      verifyEquals("1.Item 2", items.eq(1).toWidget().get("label"))

      // cannot verify selectbox items yet
      // items = jq("$selectbox1").find("@label")
      // verifyEquals("0.Item 1",items.eq(0).toWidget().get("value"))
      // verifyEquals("1.Item 2",items.eq(1).toWidget().get("value"))

      items = jq("$tree1").find("@treecell")
      verifyEquals("0.Item 1", items.eq(0).toWidget().get("label"))
      verifyEquals("0.Item 1-1", items.eq(1).toWidget().get("label"))
      verifyEquals("1.Item 1-2", items.eq(2).toWidget().get("label"))
      verifyEquals("1.Item 2", items.eq(3).toWidget().get("label"))

    })
  }
}
