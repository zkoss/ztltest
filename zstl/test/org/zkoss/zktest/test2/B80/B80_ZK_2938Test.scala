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
        var w1 = jq("$w1").toWidget()
        var w1uuid = w1.uuid()
        var w1width = getElementWidth(w1uuid)
        dragdropTo(w1, w1width + ",30", w1width.intValue() - 100 + ",30")
        waitResponse()
        verifyEquals(getElementWidth(w1uuid), 280)
        var w1height = getElementHeight(w1uuid)
        dragdropTo(w1, "30," + w1height, "30," + (w1height.intValue() - 100))
        waitResponse()
        verifyEquals(getElementHeight(w1uuid), 248)
      })
  }
}
