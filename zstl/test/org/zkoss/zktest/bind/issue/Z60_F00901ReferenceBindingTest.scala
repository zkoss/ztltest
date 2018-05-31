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
class Z60_F00901ReferenceBindingTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/F00901ReferenceBinding.zul"/>
"""

    runZTL(zul, () => {

      var tb11 = jq("$tb11")
      var tb12 = jq("$tb12")
      var tb13 = jq("$tb13")

      var tb21 = jq("$tb21")
      var tb22 = jq("$tb22")
      var tb23 = jq("$tb23")

      var tb32 = jq("$tb32")
      var tb33 = jq("$tb33")

      var tb43 = jq("$tb43")

      var replace1 = jq("$replace1")
      var replace2 = jq("$replace2")

      verifyEquals("Dennis", tb11.toWidget().get("value"))
      verifyEquals("Dennis", tb21.toWidget().get("value"))

      verifyEquals("1234", tb12.toWidget().get("value"))
      verifyEquals("1234", tb22.toWidget().get("value"))
      verifyEquals("1234", tb32.toWidget().get("value"))

      verifyEquals("11 street", tb13.toWidget().get("value"))
      verifyEquals("11 street", tb23.toWidget().get("value"))
      verifyEquals("11 street", tb33.toWidget().get("value"))
      verifyEquals("11 street", tb43.toWidget().get("value"))

      `type`(tb11.toWidget(), "Ray")
      waitResponse()
      verifyEquals("Ray", tb11.toWidget().get("value"))
      verifyEquals("Ray", tb21.toWidget().get("value"))
      verifyEquals("1234", tb12.toWidget().get("value"))
      verifyEquals("1234", tb22.toWidget().get("value"))
      verifyEquals("1234", tb32.toWidget().get("value"))
      verifyEquals("11 street", tb13.toWidget().get("value"))
      verifyEquals("11 street", tb23.toWidget().get("value"))
      verifyEquals("11 street", tb33.toWidget().get("value"))
      verifyEquals("11 street", tb43.toWidget().get("value"))

      `type`(tb21.toWidget(), "Bluce")
      waitResponse()
      verifyEquals("Bluce", tb11.toWidget().get("value"))
      verifyEquals("Bluce", tb21.toWidget().get("value"))
      verifyEquals("1234", tb12.toWidget().get("value"))
      verifyEquals("1234", tb22.toWidget().get("value"))
      verifyEquals("1234", tb32.toWidget().get("value"))
      verifyEquals("11 street", tb13.toWidget().get("value"))
      verifyEquals("11 street", tb23.toWidget().get("value"))
      verifyEquals("11 street", tb33.toWidget().get("value"))
      verifyEquals("11 street", tb43.toWidget().get("value"))

      `type`(tb12.toWidget(), "111")
      waitResponse()
      verifyEquals("Bluce", tb11.toWidget().get("value"))
      verifyEquals("Bluce", tb21.toWidget().get("value"))
      verifyEquals("111", tb12.toWidget().get("value"))
      verifyEquals("111", tb22.toWidget().get("value"))
      verifyEquals("111", tb32.toWidget().get("value"))
      verifyEquals("11 street", tb13.toWidget().get("value"))
      verifyEquals("11 street", tb23.toWidget().get("value"))
      verifyEquals("11 street", tb33.toWidget().get("value"))
      verifyEquals("11 street", tb43.toWidget().get("value"))

      `type`(tb22.toWidget(), "222")
      waitResponse()
      verifyEquals("Bluce", tb11.toWidget().get("value"))
      verifyEquals("Bluce", tb21.toWidget().get("value"))
      verifyEquals("222", tb12.toWidget().get("value"))
      verifyEquals("222", tb22.toWidget().get("value"))
      verifyEquals("222", tb32.toWidget().get("value"))
      verifyEquals("11 street", tb13.toWidget().get("value"))
      verifyEquals("11 street", tb23.toWidget().get("value"))
      verifyEquals("11 street", tb33.toWidget().get("value"))
      verifyEquals("11 street", tb43.toWidget().get("value"))

      `type`(tb32.toWidget(), "333")
      waitResponse()
      verifyEquals("Bluce", tb11.toWidget().get("value"))
      verifyEquals("Bluce", tb21.toWidget().get("value"))
      verifyEquals("333", tb12.toWidget().get("value"))
      verifyEquals("333", tb22.toWidget().get("value"))
      verifyEquals("333", tb32.toWidget().get("value"))
      verifyEquals("11 street", tb13.toWidget().get("value"))
      verifyEquals("11 street", tb23.toWidget().get("value"))
      verifyEquals("11 street", tb33.toWidget().get("value"))
      verifyEquals("11 street", tb43.toWidget().get("value"))

      `type`(tb13.toWidget(), "street1")
      waitResponse()
      verifyEquals("Bluce", tb11.toWidget().get("value"))
      verifyEquals("Bluce", tb21.toWidget().get("value"))
      verifyEquals("333", tb12.toWidget().get("value"))
      verifyEquals("333", tb22.toWidget().get("value"))
      verifyEquals("333", tb32.toWidget().get("value"))
      verifyEquals("street1", tb13.toWidget().get("value"))
      verifyEquals("street1", tb23.toWidget().get("value"))
      verifyEquals("street1", tb33.toWidget().get("value"))
      verifyEquals("street1", tb43.toWidget().get("value"))

      `type`(tb23.toWidget(), "street2")
      waitResponse()
      verifyEquals("Bluce", tb11.toWidget().get("value"))
      verifyEquals("Bluce", tb21.toWidget().get("value"))
      verifyEquals("333", tb12.toWidget().get("value"))
      verifyEquals("333", tb22.toWidget().get("value"))
      verifyEquals("333", tb32.toWidget().get("value"))
      verifyEquals("street2", tb13.toWidget().get("value"))
      verifyEquals("street2", tb23.toWidget().get("value"))
      verifyEquals("street2", tb33.toWidget().get("value"))
      verifyEquals("street2", tb43.toWidget().get("value"))

      `type`(tb33.toWidget(), "street3")
      waitResponse()
      verifyEquals("Bluce", tb11.toWidget().get("value"))
      verifyEquals("Bluce", tb21.toWidget().get("value"))
      verifyEquals("333", tb12.toWidget().get("value"))
      verifyEquals("333", tb22.toWidget().get("value"))
      verifyEquals("333", tb32.toWidget().get("value"))
      verifyEquals("street3", tb13.toWidget().get("value"))
      verifyEquals("street3", tb23.toWidget().get("value"))
      verifyEquals("street3", tb33.toWidget().get("value"))
      verifyEquals("street3", tb43.toWidget().get("value"))

      `type`(tb43.toWidget(), "street4")
      waitResponse()
      verifyEquals("Bluce", tb11.toWidget().get("value"))
      verifyEquals("Bluce", tb21.toWidget().get("value"))
      verifyEquals("333", tb12.toWidget().get("value"))
      verifyEquals("333", tb22.toWidget().get("value"))
      verifyEquals("333", tb32.toWidget().get("value"))
      verifyEquals("street4", tb13.toWidget().get("value"))
      verifyEquals("street4", tb23.toWidget().get("value"))
      verifyEquals("street4", tb33.toWidget().get("value"))
      verifyEquals("street4", tb43.toWidget().get("value"))

      click(replace1.toWidget())
      waitResponse()
      verifyEquals("Alex", tb11.toWidget().get("value"))
      verifyEquals("Alex", tb21.toWidget().get("value"))
      verifyEquals("888", tb12.toWidget().get("value"))
      verifyEquals("888", tb22.toWidget().get("value"))
      verifyEquals("888", tb32.toWidget().get("value"))
      verifyEquals("888 st", tb13.toWidget().get("value"))
      verifyEquals("888 st", tb23.toWidget().get("value"))
      verifyEquals("888 st", tb33.toWidget().get("value"))
      verifyEquals("888 st", tb43.toWidget().get("value"))

      click(replace2.toWidget())
      waitResponse()
      verifyEquals("Alex", tb11.toWidget().get("value"))
      verifyEquals("Alex", tb21.toWidget().get("value"))
      verifyEquals("999", tb12.toWidget().get("value"))
      verifyEquals("999", tb22.toWidget().get("value"))
      verifyEquals("999", tb32.toWidget().get("value"))
      verifyEquals("999 st", tb13.toWidget().get("value"))
      verifyEquals("999 st", tb23.toWidget().get("value"))
      verifyEquals("999 st", tb33.toWidget().get("value"))
      verifyEquals("999 st", tb43.toWidget().get("value"))

    })
  }
}

