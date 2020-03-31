package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.JQuery

@Tags(tags = "B70-ZK-2359.zul")
class B70_ZK_2359Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      var check = (input: JQuery) => {
        val value = input.attr("value");
        for (i <- 1 to 5) {
          sleep(300);
          verifyEquals("value should be the same. it means no flickering.", value, input.attr("value"));
        }
      };

      var btn = jq("@listbox").find(".z-paging-button").eq(2);
      clickAt(btn, "1,1");
      waitResponse();
      clickAt(btn, "1,1");
      waitResponse();
      clickAt(btn, "1,1");
      waitResponse();
      check(jq("@listbox").find(".z-paging-input"));

      btn = jq("@grid").find(".z-paging-button").eq(2);
      clickAt(btn, "1,1");
      waitResponse();
      clickAt(btn, "1,1");
      waitResponse();
      clickAt(btn, "1,1");
      waitResponse();
      check(jq("@grid").find(".z-paging-input"));

      btn = jq("@tree").find(".z-paging-button").eq(2);
      clickAt(btn, "1,1");
      waitResponse();
      clickAt(btn, "1,1");
      waitResponse();
      clickAt(btn, "1,1");
      waitResponse();
      check(jq("@tree").find(".z-paging-input"));
    })

  }
}