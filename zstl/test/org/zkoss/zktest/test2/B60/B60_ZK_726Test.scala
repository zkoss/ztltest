package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-726.zul")
class B60_ZK_726Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk xmlns:w="client">
                    <div>
                      You should see the busy loading sign on the dummy div.
                    </div>
                    <borderlayout vflex="1">
                      <center autoscroll="true">
                        <div id="loading_div" width="100px" height="100px" style="position: absolute; z-index: 1; border: 1px solid black">
                          Dummy Div
                        </div>
                      </center>
                    </borderlayout>
                    <script defer="true">
                      var div = zk.Widget.$('$loading_div');
		zAu.cmd0.showBusy(div.uuid, 'loading');
                    </script>
                  </zk>"""

    runZTL(zscript,
      () => {
        val div = jq(".z-apply-mask")
        val loading = jq(".z-apply-loading")
        val divLeft = div.offsetLeft()
        val divTop = div.offsetTop()
        val loadingLeft = loading.offsetLeft()
        val loadingTop = loading.offsetTop()

        verifyTrue(divLeft < loadingLeft)
        verifyTrue(divTop < loadingTop)
        verifyTrue(loadingLeft + loading.width() < divLeft + div.width())
        verifyTrue(loadingTop + loading.height() < divTop + div.height())
      })

  }
}
