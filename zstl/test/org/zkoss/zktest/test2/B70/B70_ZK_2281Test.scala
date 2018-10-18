package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2306.zul")
class B70_ZK_2281Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val grid = jq("@grid");
        val indicator = jq(".z-scrollbar-indicator");
        evalScript(grid.toWidget() + "._scrollbar._mouseEnter()");
        waitResponse()
        dragdropTo(indicator, "100,2", indicator.width() + ",2")
        waitResponse();
        click(jq(".z-paging-next"));
        waitResponse();
        verifyFalse(jq(".z-error").exists());
      })

  }
}