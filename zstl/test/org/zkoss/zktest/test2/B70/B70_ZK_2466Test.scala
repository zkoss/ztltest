package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2466.zul")
class B70_ZK_2466Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var btn = jq(".z-button");
        click(btn);
        waitResponse();
        val AAA = jq(".z-column-content").first().text();
        verifyTrue("AAA".equals(AAA));

      })

  }
}