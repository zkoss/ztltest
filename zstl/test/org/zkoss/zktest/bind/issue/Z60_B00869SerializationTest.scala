/* Z60_B00869SerializationTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 24, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00869SerializationTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00869Serialization.zul"/>
    }

    runZTL(zul, () => {

      var msg = jq("$msg")
      var selected = jq("$selected")
      var listbox = jq("$listbox")
      var tb1 = jq("$tb1")
      var save = jq("$save")
      var serialize = jq("$serialize")
      var children = jq("$children")

      verifyEquals("A", selected.toWidget().get("value"))
      verifyEquals("A", tb1.toWidget().get("value"))
      verifyEquals("B", children.find("@label").eq(1).toWidget().get("value"))

      click(listbox.find("@listitem").eq(1).toWidget())
      waitResponse()
      verifyEquals("B", selected.toWidget().get("value"))
      verifyEquals("B", tb1.toWidget().get("value"))

      `type`(tb1.toWidget(), "BX")
      waitResponse()
      click(save.toWidget())
      waitResponse()
      verifyEquals("BX", selected.toWidget().get("value"))
      verifyEquals("BX", children.find("@label").eq(1).toWidget().get("value"))
      verifyEquals("BX", listbox.find("@listitem").eq(1).find("@listcell").eq(1).toWidget().get("label"))

      click(serialize.toWidget())
      waitResponse()

      // refine
      msg = jq("$msg")
      selected = jq("$selected")
      listbox = jq("$listbox")
      tb1 = jq("$tb1")
      save = jq("$save")
      serialize = jq("$serialize")
      children = jq("$children")

      verifyTrue(msg.toWidget().get("value").toString().startsWith("done deserialize:"))

      click(listbox.find("@listitem").eq(2).toWidget())
      waitResponse()
      verifyEquals("C", selected.toWidget().get("value"))
      verifyEquals("C", tb1.toWidget().get("value"))

      `type`(tb1.toWidget(), "CY")
      waitResponse()
      click(save.toWidget())
      waitResponse()
      verifyEquals("CY", selected.toWidget().get("value"))
      verifyEquals("CY", children.find("@label").eq(2).toWidget().get("value"))
      verifyEquals("CY", listbox.find("@listitem").eq(2).find("@listcell").eq(1).toWidget().get("label"))

    })
  }
}
