package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1527.zul")
class B65_ZK_1527Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	Chrome/Safari Only
	1. Open datebox's popup.
	2. Click arrow button of the timebox directly (do not focus on input node), should see the value in datebox changed.
	</label>
	<datebox id="db" cols="20" format="yyyy/MM/dd HH:mm" onCreate="self.value = new Date()" />
</zk>
    """

    runZTL(zscript,
      () => {
        click(jq(jq(".z-datebox").toWidget().$n("btn")))
        waitResponse()

        val before = jq(".z-timebox").toWidget().$n("real").get("value");
        click(jq(".z-timebox").toWidget().$n("btn-down"))
        waitResponse()
        val after = jq(".z-timebox").toWidget().$n("real").get("value");
        verifyNotEquals("should see the value in datebox changed", before, after)
      })

  }
}
