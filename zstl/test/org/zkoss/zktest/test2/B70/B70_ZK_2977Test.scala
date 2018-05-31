package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2977.zul")
class B70_ZK_2977Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val combobox = jq(".z-combobox").eq(1);
        val comboboxButton = jq(".z-combobox-button").eq(1);
        val window = driver.manage().window();
        val clientHeight = window.getSize().height;
        val comboboxBottom = combobox.offsetTop() + combobox.height();
        runScript("window.scrollTo(0," + (comboboxBottom + clientHeight) + ")");
        runScript("window.scrollBy(0,-" + combobox.height() + ")");
        click(comboboxButton);
        waitResponse(true);
        runScript("window.scrollBy(0," + combobox.height() + ")");
        val popup = jq(".z-combobox-popup");
        verifyTrue(popup.offsetTop() >= comboboxBottom);
      })
  }
}