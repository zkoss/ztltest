package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2892.zul")
class B70_ZK_2892Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var windows = jq("@window")
        val w1 = windows.eq(0)
        val w1pw = w1.parent().innerWidth
        val w1w = w1.outerWidth
        val w1pl = w1.positionLeft
        val w1pt = w1.positionTop
        val w1zi = w1.css("z-index")

        val w2 = windows.eq(1)
        val w2pw = w2.parent().innerWidth
        val w2w = w2.outerWidth
        val w2pl = w2.positionLeft
        val w2pt = w2.positionTop
        val w2zi = w2.css("z-index")
        val w3 = windows.eq(2)
        val w3pw = w3.parent().innerWidth
        val w3w = w3.outerWidth
        val w3pl = w3.positionLeft
        val w3pt = w3.positionTop
        val w3zi = w3.css("z-index")
        verifyEquals("position top should be the same", w1pt, w2pt)
        verifyEquals("position top should be the same", w2pt, w3pt)
        verifyEquals(parseInt(w1zi) + 1, parseInt(w2zi))
        verifyEquals(parseInt(w2zi) + 1, parseInt(w3zi))
        verifyTolerant(w1pw - w1w, w1pl * 2, 2)
        verifyTolerant(w2pw - w2w, w2pl * 2, 2)
        verifyTolerant(w3pw - w3w, w3pl * 2, 2)
      })
  }
}