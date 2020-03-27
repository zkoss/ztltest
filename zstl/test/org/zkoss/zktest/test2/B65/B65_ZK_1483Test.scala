package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1483.zul")
class B65_ZK_1483Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        click(jq(".z-button:contains(Select All)"))
        waitResponse()
        val listboxBody = jq(".z-listbox-body")
        listboxBody.toElement().set("scrollTop", 360)
        listboxBody.toElement().set("scrollTop", 720)

        sleep(500)
        verifyTrue("The scrollbar position should not vibrate when released.", listboxBody.scrollTop() == 720)
      })

  }
}