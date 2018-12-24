package org.zkoss.zktest.test2.F86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author rudyhuang
  */
class F86_ZK_4023Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val dateInput1 = jq("$d1 > input")
      val dateInput2 = jq("$d2 > input")

      `type`(dateInput1, "Jan 0, 2018")
      waitResponse()
      verifyEquals("Dec 31, 2017", dateInput1.`val`())
      verifyFalse(hasError)

      `type`(dateInput1, "Feb 30, 2018")
      waitResponse()
      verifyEquals("Mar 2, 2018", dateInput1.`val`())
      verifyFalse(hasError)

      `type`(dateInput1, "Dec 20, 2018")
      waitResponse()
      verifyEquals("Dec 20, 2018", dateInput1.`val`())
      verifyFalse(hasError)

      `type`(dateInput2, "Jan 0, 2018")
      waitResponse()
      verifyEquals("Jan 0, 2018", dateInput2.`val`())
      verifyTrue(hasError)
      `type`(dateInput2, "")
      waitResponse()

      `type`(dateInput2, "Feb 30, 2018")
      waitResponse()
      verifyEquals("Feb 30, 2018", dateInput2.`val`())
      verifyTrue(hasError)
      `type`(dateInput2, "")
      waitResponse()

      `type`(dateInput2, "Dec 20, 2018")
      waitResponse()
      verifyEquals("Dec 20, 2018", dateInput2.`val`())
      verifyFalse(hasError)
    })
  }
}
