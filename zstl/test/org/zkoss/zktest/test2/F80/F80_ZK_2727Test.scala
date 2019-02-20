package org.zkoss.zktest.test2.F80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F80-ZK-2727.zul")
class F80_ZK_2727Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      var sv = jq("@scrollview");
      var count = jq("@window").length();
      horScrollNoBody(sv, 100);
      verifyTrue(jq("@window").length() > count);

      count = jq("@window").length();
      click(jq(".z-button"));
      waitResponse()
      verScrollNoBody(sv, 100);
      waitResponse()
      verifyTrue(jq("@window").length() > count);
    })
  }
}