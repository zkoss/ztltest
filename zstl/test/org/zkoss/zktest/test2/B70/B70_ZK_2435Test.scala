package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2435.zul")
class B70_ZK_2435Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      var btn = jq(".z-bandbox-button");
      var input = jq("input");
      click(btn);
      waitResponse();
      var john = jq(".z-listitem").first();
      click(john);
      waitResponse();
      var listbox = jq("@listbox").toWidget();
      val a = listbox.$n("a") //button can be focused and sendKey
      focus(a);
      sendKeys(a, Keys.ENTER);
      waitResponse();
      verifyEquals(input.eval("val()"), "John")
      waitResponse();
      click(btn);
      waitResponse();
      click(john);
      waitResponse();
      focus(a);
      sendKeys(a, Keys.ESCAPE);
      waitResponse();
      verifyEquals(input.eval("val()"), "")

    })

  }
}
