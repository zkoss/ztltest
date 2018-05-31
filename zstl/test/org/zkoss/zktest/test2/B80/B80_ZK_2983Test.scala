package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-2983.zul")
class B80_ZK_2983Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val button = jq("button:contains(Modify text and select Bob)");
        click(button);

        waitResponse();

        val textbox = jq(".z-textbox");
        val chosenItems = jq(".z-chosenbox-item");
        val chosenItemText = jq(".z-chosenbox-item-content").text();

        verifyEquals(textbox.`val`(), "Value 1");
        verifyEquals(chosenItems.length(), 1);
        verifyEquals(chosenItemText, "Bob");
      })

  }
}