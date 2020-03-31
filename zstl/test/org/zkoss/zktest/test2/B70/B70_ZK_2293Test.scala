package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2293.zul")
class B70_ZK_2293Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      val btn = jq(".z-bandbox-button");
      click(btn);
      waitResponse()
      val w1 = jq(".z-bandbox-popup").width();
      click(btn);
      waitResponse()

      click(btn);
      waitResponse()
      val w2 = jq(".z-bandbox-popup").width();
      click(btn);
      waitResponse()
      verifyTrue("the width of popup in two times should be the same.", w1 == w2);
    })
  }
}