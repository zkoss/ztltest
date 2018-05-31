package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "F70-ZK-112.zul")
class F70_ZK_112Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var vsplitter = jq(".z-splitter-icon.z-icon-ellipsis-v").eq(0);
        var startL = vsplitter.positionLeft();
        var startT = vsplitter.positionTop();
        var endL = startL - 200;
        dragdropTo(vsplitter, startL + "," + startT, endL + "," + startT);
        waitResponse(true);
        var oldWidth = jq(".z-vbox").width();
        startL = vsplitter.positionLeft();
        startT = vsplitter.positionTop();
        dragdropTo(vsplitter, startL + "," + startT, (startL + 30) + "," + startT);
        waitResponse(true);
        println(">>>" + jq(".z-vbox").width());
        println(">>>" + oldWidth);
        verifyTrue(jq(".z-vbox").width() - oldWidth > 0);

        var hsplitter = jq(".z-splitter-icon.z-icon-ellipsis-h").eq(0);
        var oldHeight = jq(jq(".z-div").first().toWidget().$n("chdex")).height();
        startL = hsplitter.positionLeft();
        startT = hsplitter.positionTop();
        var endT = startT - 100;
        dragdropTo(hsplitter, startL + "," + startT, startL + "," + endT);
        waitResponse(true);
        println(">>>" + jq(jq(".z-div").first().toWidget().$n("chdex")).height());
        println(">>>" + oldHeight);
        verifyTrue(jq(jq(".z-div").first().toWidget().$n("chdex")).height() - oldHeight < 0);
      })

  }
}