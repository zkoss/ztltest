/* Z60_F00995ValidationMessagesTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 23, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00995ValidationMessagesTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/F00995ValidationMessages.zul"/>
"""
    runZTL(zul, () => {
      var l1 = jq("$l1")
      var t1 = jq("$t1")

      var msg11 = jq("$msg11")
      var msg12 = jq("$msg12")
      var msg13 = jq("$msg13")

      var msg21 = jq("$msg21")
      var msg22 = jq("$msg22")

      var msg31 = jq("$msg31")
      var msg32 = jq("$msg32")
      var msg33 = jq("$msg33")
      var msg34 = jq("$msg34")

      var msg41 = jq("$msg41")
      var msg42 = jq("$msg42")
      var msg43 = jq("$msg43")
      var msg44 = jq("$msg44")

      var msggrid1 = jq("$msggrid1")
      var msggrid2 = jq("$msggrid2")
      var msggrid3 = jq("$msggrid3")

      verifyEquals("ABC", l1.toWidget().get("value"))
      verifyEquals("ABC", t1.toWidget().get("value"))

      verifyEquals("", msg11.toWidget().get("value"))
      verifyEquals("", msg12.toWidget().get("value"))
      verifyEquals("", msg13.toWidget().get("value"))

      verifyEquals("", msg21.toWidget().get("value"))
      verifyEquals("", msg22.toWidget().get("value"))

      verifyEquals("true", msg31.toWidget().get("value"))
      verifyEquals("true", msg32.toWidget().get("value"))
      verifyEquals("false", msg33.toWidget().get("value"))
      verifyEquals("false", msg34.toWidget().get("value"))

      verifyEquals("", msg41.toWidget().get("value"))
      verifyEquals("", msg42.toWidget().get("value"))
      verifyEquals("", msg43.toWidget().get("value"))
      verifyEquals("", msg44.toWidget().get("value"))

      verifyEquals(0, msggrid1.find("@row").length())
      verifyEquals(0, msggrid2.find("@row").length())
      verifyEquals(0, msggrid3.find("@row").length())

      `type`(t1.toWidget(), "ABCa")
      waitResponse()

      verifyEquals("ABC", l1.toWidget().get("value"))
      verifyEquals("ABCa", t1.toWidget().get("value"))

      verifyEquals("[1] value must equals ignore case 'abc', but is ABCa", msg11.toWidget().get("value"))
      verifyEquals("[1] value must equals ignore case 'abc', but is ABCa", msg12.toWidget().get("value"))
      verifyEquals("[1] value must equals ignore case 'abc', but is ABCa", msg13.toWidget().get("value"))

      verifyEquals("", msg21.toWidget().get("value"))
      verifyEquals("", msg22.toWidget().get("value"))

      verifyEquals("false", msg31.toWidget().get("value"))
      verifyEquals("false", msg32.toWidget().get("value"))
      verifyEquals("true", msg33.toWidget().get("value"))
      verifyEquals("true", msg34.toWidget().get("value"))

      verifyEquals("[2] value must equals ignore case 'abc', but is ABCa", msg41.toWidget().get("value"))
      verifyEquals("[2] value must equals ignore case 'abc', but is ABCa", msg42.toWidget().get("value"))
      verifyEquals("[2] value must equals ignore case 'abc', but is ABCa", msg43.toWidget().get("value"))
      verifyEquals("[2] value must equals ignore case 'abc', but is ABCa", msg44.toWidget().get("value"))

      verifyEquals(3, msggrid1.find("@row").length())
      verifyEquals(3, msggrid2.find("@row").length())
      verifyEquals(3, msggrid3.find("@row").length())

      var i = 1
      var rows = msggrid1.find("@row")
      for (j <- 0 until 3) {
        var row = rows.eq(j)
        verifyEquals("[" + i + "] value must equals ignore case 'abc', but is ABCa", row.find("@label").toWidget().get("value"))
        i = i + 1
      }

      i = 1
      rows = msggrid2.find("@row")
      for (j <- 0 until 3) {
        var row = rows.eq(j)
        verifyEquals("[" + i + "] value must equals ignore case 'abc', but is ABCa", row.find("@label").toWidget().get("value"))
        i = i + 1
      }

      i = 1
      rows = msggrid3.find("@row")
      for (j <- 0 until 3) {
        var row = rows.eq(j)
        verifyEquals("[" + i + "] value must equals ignore case 'abc', but is ABCa", row.find("@label").toWidget().get("value"))
        i = i + 1
      }

    })
  }
}

