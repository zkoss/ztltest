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
import org.zkoss.ztl.Widget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00889ChildrenBindingConverterTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/F00889ChildrenBindingConverter.zul"/>
    }

    runZTL(zul, () => {

      var item1 = jq("$item1")
      var set1 = jq("$set1")
      var list1 = jq("$list1")
      var array1 = jq("$array1")
      var enum1 = jq("$enum1")
      var item2 = jq("$item2")
      var set2 = jq("$set2")
      var list2 = jq("$list2")
      var array2 = jq("$array2")
      var enum2 = jq("$enum2")

      var ls = item1.find("@label")
      verifyEquals(1, ls.length())
      verifyEquals("A", ls.eq(0).toWidget().get("value"))

      ls = set1.find("@label")
      verifyEquals(3, ls.length())

      ls = list1.find("@label")
      verifyEquals(3, ls.length())
      verifyEquals("A", ls.eq(0).toWidget().get("value"))
      verifyEquals("B", ls.eq(1).toWidget().get("value"))
      verifyEquals("C", ls.eq(2).toWidget().get("value"))

      ls = array1.find("@label")
      verifyEquals(3, ls.length())
      verifyEquals("A", ls.eq(0).toWidget().get("value"))
      verifyEquals("B", ls.eq(1).toWidget().get("value"))
      verifyEquals("C", ls.eq(2).toWidget().get("value"))

      ls = enum1.find("@label")
      verifyEquals(3, ls.length())
      verifyEquals("A", ls.eq(0).toWidget().get("value"))
      verifyEquals("B", ls.eq(1).toWidget().get("value"))
      verifyEquals("C", ls.eq(2).toWidget().get("value"))

      // for 2
      ls = item2.find("@label")
      verifyEquals(1, ls.length())
      verifyEquals("D", ls.eq(0).toWidget().get("value"))

      ls = set2.find("@label")
      verifyEquals(3, ls.length())

      ls = list2.find("@label")
      verifyEquals(3, ls.length())
      verifyEquals("D", ls.eq(0).toWidget().get("value"))
      verifyEquals("E", ls.eq(1).toWidget().get("value"))
      verifyEquals("F", ls.eq(2).toWidget().get("value"))

      ls = array2.find("@label")
      verifyEquals(3, ls.length())
      verifyEquals("D", ls.eq(0).toWidget().get("value"))
      verifyEquals("E", ls.eq(1).toWidget().get("value"))
      verifyEquals("F", ls.eq(2).toWidget().get("value"))

      ls = enum2.find("@label")
      verifyEquals(3, ls.length())
      verifyEquals("D", ls.eq(0).toWidget().get("value"))
      verifyEquals("E", ls.eq(1).toWidget().get("value"))
      verifyEquals("F", ls.eq(2).toWidget().get("value"))

    })
  }
}

