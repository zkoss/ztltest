package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1308.zul")
class B65_ZK_1308Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<window apply="org.zkoss.zktest.test2.B65_ZK_1308_1">
You should see Super and Subclass without <label value="null" style="font-weight:bold"/> value.
<separator/>
</window>
    """;

    runZTL(zscript,
      () => {
        verifyTrue("You should see Super and Subclass without 'null' value", !jq(".z-label:contains(Super):eq(1)").text().contains("null"))
        verifyTrue("You should see Super and Subclass without 'null' value", !jq(".z-label:contains(Subclass):eq(1)").text().contains("null"))
      })

  }
}