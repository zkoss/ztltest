package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2977.zul")
class B70_ZK_2977Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val combobox = jq(".z-combobox").eq(1);
        val comboboxButton = jq(".z-combobox-button").eq(1);
        val comboboxBottom = combobox.offsetTop() + combobox.height();
        evalScript("window.scrollTo(0, 1005)");
        evalScript("window.scrollBy(0,-" + combobox.height() + ")");
        click(comboboxButton);
        waitResponse(true);
        evalScript("window.scrollBy(0," + combobox.height() + ")");
        val pp = jq(".z-combobox-popup");
        verifyTrue(pp.offsetTop() >= comboboxBottom);
      })
  }
}