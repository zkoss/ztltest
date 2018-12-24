package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author rudyhuang
  */
class B86_ZK_4178Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val input = "Aug 32, 2018"
      val dateInput1 = jq("$d1 > input")
      val dateInput2 = jq("$d2 > input")

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
    })
  }
}
