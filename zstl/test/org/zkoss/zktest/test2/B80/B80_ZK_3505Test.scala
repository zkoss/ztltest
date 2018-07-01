package org.zkoss.zktest.test2.B80

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 01/11/2017.
  */
class B80_ZK_3505Test extends ZTL4ScalaTestCase {

  def test() = {
    runZTL(() => {
      val pn1captionid = jq(".z-panel .z-caption").get(0).eval("id")
      val pn2captionid = jq(".z-panel .z-caption").get(1).eval("id")
      val gb1captionid = jq(".z-groupbox .z-caption").get(0).eval("id")
      val gb2captionid = jq(".z-groupbox .z-caption").get(1).eval("id")
      val wd1captionid = jq(".z-window .z-caption").get(0).eval("id")
      val wd2captionid = jq(".z-window .z-caption").get(1).eval("id")
      var a = ""
      for (i <- 0 to 20) {
        keyPressNative("9")
        a += getEval("document.activeElement.id") + " "
      }
      verifyNotContains("panel caption 1 should not be selected", a, pn1captionid)
      verifyNotContains("panel caption 2 should be selected", a, pn2captionid)
      verifyNotContains("groupbox caption 1 should not be selected", a, gb1captionid)
      verifyNotContains("groupbox caption 2 should be selected", a, gb2captionid)
      verifyNotContains("window caption 1 should not be selected", a, wd1captionid)
      verifyNotContains("window caption 2 should be selected", a, wd2captionid)
    })
  }
}
