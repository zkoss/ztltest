package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F70-ZK-112.zul")
class F70_ZK_112Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var vsplitter = jq("$s2");
        dragdropTo(vsplitter, "1,1", "-200,1");
        waitResponse(true);
        var oldWidth = jq(".z-vbox").width();
        dragdropTo(vsplitter, "1,1","30,1");
        waitResponse(true);
        verifyTrue(jq(".z-vbox").width() - oldWidth > 0);
        var hsplitter = jq("$s1");
        var oldHeight = jq(jq(".z-div").first().toWidget().$n("chdex")).height();
        dragdropTo(hsplitter, "1,1", "1,-100");
        waitResponse(true);
        verifyTrue(jq(jq(".z-div").first().toWidget().$n("chdex")).height() - oldHeight < 0);
      })

  }
}