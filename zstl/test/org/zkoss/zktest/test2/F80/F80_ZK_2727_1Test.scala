package org.zkoss.zktest.test2.F80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

@Tags(tags = "F80-ZK-2727.zul")
@IgnoreBrowsers("desktop")
class F80_ZK_2727_1Test extends ZTL4ScalaTestCase{
  @Test
  def testClickMobile() = {
    val zscript =
      """<include src="/test2/F80-ZK-2727.zul"/>
      """
    runZTL(zscript, () => {
      val sv = jq("@scrollview");
      var count = jq("@window").length();
      var times = 0;
      while (times < 10) {
        dragdrop(sv, "-200,0");
        waitResponse();
        times += 1;
      }
      verifyTrue(jq("@window").length() > count);

      click(jq(".z-button"));
      waitResponse();
      count = jq("@window").length();
      times = 0;
      while (times < 10) {
        dragdrop(sv, "0,-200");
        waitResponse();
        times += 1;
      }
      verifyTrue(jq("@window").length() > count);
    })
  }
}