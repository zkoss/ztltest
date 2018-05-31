package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * Created by wenning on 1/21/16.
  */
@Tags(tags = "B70-ZK-2935.zul")
class B70_ZK_2935Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      verifyEquals("null", getEval("zk.currentFocus"));
      keyPressNative("9")
      waitResponse(true)
      verifyEquals("null", getEval("zk.currentFocus"));
    })
  }

}
