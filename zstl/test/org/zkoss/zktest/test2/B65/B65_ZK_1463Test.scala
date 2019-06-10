
package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1463.zul")
class B65_ZK_1463Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
        click(jq("@button:contains(1)"))
        waitResponse()

        val btn = jq("@button:contains(Save)")
        val disabled = jq(btn).attr("disabled")
        click(btn)
        waitResponse()
        val clickWork = jq("@window").isVisible()

        verifyFalse("should be enabled", disabled)
        verifyTrue("should be click-able", clickWork)
      })

  }
}