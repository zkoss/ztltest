package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * Created by wenning on 1/19/16.
  */
@Tags(tags = "B80-ZK-2938.zul")
class B80_ZK_2938Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      val w1 = jq("$w1")
      val w1width = w1.outerWidth()
      val w1height = w1.outerHeight()
      println(s"w1width = $w1width, w1height = $w1height")

      dragdropTo(w1, s"$w1width,30", s"${w1width - 100},30")
      waitResponse()
      verifyTolerant(w1width - 100, w1.outerWidth(), 2)

      dragdropTo(w1, s"30,$w1height", s"30,${w1height - 100}")
      waitResponse()
      verifyTolerant(w1height - 100, w1.outerHeight(), 2)
    })
  }
}
