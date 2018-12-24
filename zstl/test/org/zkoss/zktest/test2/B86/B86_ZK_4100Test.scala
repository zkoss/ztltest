package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author rudyhuang
  */
class B86_ZK_4100Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val input = "31.11.2018"
      val dateInput1 = jq("@datebox:eq(0) > input")
      val dateInput2 = jq("@datebox:eq(1) > input")
      val dateInput3 = jq("@datebox:eq(2) > input")
      val dateInput4 = jq("@datebox:eq(3) > input")

      `type`(dateInput1, input)
      waitResponse()
      verifyEquals(input, dateInput1.`val`())
      verifyTrue(hasError)
      `type`(dateInput1, "")
      waitResponse()

      `type`(dateInput2, input)
      waitResponse()
      verifyEquals(input, dateInput2.`val`())
      verifyTrue(hasError)
      `type`(dateInput2, "")
      waitResponse()

      `type`(dateInput3, input)
      waitResponse()
      verifyEquals("01.12.2018", dateInput3.`val`())
      verifyFalse(hasError)

      `type`(dateInput4, input)
      waitResponse()
      verifyEquals(input, dateInput4.`val`())
      verifyTrue(hasError)
    })
  }
}
