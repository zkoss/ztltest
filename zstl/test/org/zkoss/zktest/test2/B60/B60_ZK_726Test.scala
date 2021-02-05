package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-726.zul")
class B60_ZK_726Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
        sleep(1000)
        val div = jq(".z-apply-mask")
        val loading = jq(".z-apply-loading")
        val divLeft = div.offsetLeft()
        val divTop = div.offsetTop()
        val loadingLeft = loading.offsetLeft()
        val loadingTop = loading.offsetTop()

        verifyTrue(divLeft <= loadingLeft)
        verifyTrue(divTop <= loadingTop)
        verifyTrue(loadingLeft + loading.width() <= divLeft + div.width())
        verifyTrue(loadingTop + loading.height() <= divTop + div.height())
      })

  }
}
