package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2574.zul")
class B70_ZK_2574Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var btn = jq("$btn");
        var btn2 = jq("$btn2");
        var status = jq("$status");
        click(btn);
        waitResponse();
        verifyEquals("started", status.html());
        sleep(2000);
        verifyEquals("finished", status.html());

        click(btn2);
        waitResponse();
        verifyEquals("started", status.html());
        sleep(2000);
        verifyEquals("finished", status.html());
      })

  }
}
