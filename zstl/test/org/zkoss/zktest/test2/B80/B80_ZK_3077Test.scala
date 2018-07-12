package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 17/10/2017.
  */
class B80_ZK_3077Test extends ZTL4ScalaTestCase {

  @Test
  def test() = {
    runZTL(
      () => {
        clickAll()
        clickAll()
        verifyTrue(jq(".z-listitem-focus").length() == 1)
        verifyEquals(jq(".z-listitem").get(3).toElement.attr("id"), jq(".z-listitem-focus").toElement.attr("id"))
      }
    )
  }

  def clickAll() = {
    click(jq(".z-listitem-checkbox").get(0))
    waitResponse()
    click(jq(".z-listitem-checkbox").get(1))
    waitResponse()
    click(jq(".z-listitem-checkbox").get(2))
    waitResponse()
    click(jq(".z-listitem-checkbox").get(3))
    waitResponse()
  }

}
