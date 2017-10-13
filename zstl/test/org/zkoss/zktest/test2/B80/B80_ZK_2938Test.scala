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
        var w1 = jq("$w1")
        var w1width = w1.outerWidth()
        System.out.println("w1width = " + w1width)
        dragdropTo(w1, w1width + ",30", w1width.intValue() - 100 + ",30")
      waitResponse()
      verifyEquals(w1.outerWidth(), 234)
      var w1height = w1.outerHeight()
      System.out.println("w1height = " + w1height)
      dragdropTo(w1, "30," + w1height, "30," + (w1height.intValue() - 100))
        waitResponse()
        verifyEquals(w1.outerHeight(), 194)
      })
  }
}
