package org.zkoss.zktest.test2.B95

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author rudyhuang
  */
class B95_ZK_4741Test extends ZTL4ScalaTestCase {
  @Test
  def test() {
    runZTL(() => {
      val tree = widget("@tree")
      verScrollAbs(tree, 10000)
      waitResponse()

      click(tree) // to select an item
      waitResponse()
      click(jq("@button"))
      waitResponse()
      verifyTolerant(jq(tree.$n("body")).scrollHeight(),
        jq(tree.$n("tpad")).height() +
        jq(tree.$n("cave")).height() +
        jq(tree.$n("bpad")).height(), 2)
    })
  }
}
