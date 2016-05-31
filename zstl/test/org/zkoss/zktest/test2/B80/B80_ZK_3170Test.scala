package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenning on 5/30/16.
  */
class B80_ZK_3170Test extends ZTL4ScalaTestCase {

  @Test
  def test() = {
    runZTL(
      () => {
        click(jq(".z-icon-caret-down").get(0))
        waitResponse(true)
        click(jq("@button").get(0))
        waitResponse(true)
        click(jq(".z-icon-caret-right").get(0))
        waitResponse(true)
        System.out.println(jq(".z-treecell-text").get(2).eval("innerHTML"))
      }
    )
  }

}
