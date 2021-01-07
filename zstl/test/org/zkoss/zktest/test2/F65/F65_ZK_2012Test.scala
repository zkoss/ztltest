package org.zkoss.zktest.test2.F65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

@Tags(tags = "F65-ZK-2012.zul")
@IgnoreBrowsers("chrome,ff,safari,edge_legacy,ie10,ie9")
class F65_ZK_2012Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
        val log = jq("#zk_log").`val`()
        verifyContains("should see 'zk.ie: 11, zk.ff: false' in zk.log", log, "zk.ie: 11")
        verifyContains("should see 'zk.ie: 11, zk.ff: false' in zk.log", log, "zk.ff: false")
        click(jq(".z-button"))
        waitResponse()
        verifyTrue(jq(".z-textbox").eq(0).`val`() == "true")
        verifyTrue(jq(".z-textbox").eq(1).`val`() == "false")
        verifyTrue(jq(".z-textbox").eq(2).`val`() == "true")
        verifyTrue(jq(".z-textbox").eq(3).`val`() == "ie")
        verifyTrue(jq(".z-textbox").eq(4).`val`() == "[11.0, 7.0, 11.0]")
        verifyTrue(jq(".z-vlayout:eq(1) .z-label:contains({version=11.0, name=ie}), " +
          ".z-vlayout:eq(1) .z-label:contains({name=ie, version=11.0})").exists())
        verifyTrue(jq(".z-vlayout:eq(1) .z-label:contains(11)").length() == 2)
      })
  }
}