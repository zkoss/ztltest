package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2987.zul")
class B70_ZK_2987Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var listbox = jq(".z-listbox");
        var listboxBody = listbox.find(".z-listbox-body");
        verScroll(listboxBody, 100);

        val nextButton = listbox.find(".z-paging-next");
        click(nextButton);
        waitResponse();
        click(nextButton);
        waitResponse();

        listbox = jq(".z-listbox");
        listboxBody = listbox.find(".z-listbox-body");
        val lastItem = listbox.find(".z-listitem").last();
        verifyTrue(lastItem.positionTop() <= (listboxBody.height() - lastItem.height()));

        val prevButton = listbox.find(".z-paging-previous");
        click(prevButton);
        waitResponse();

        listbox = jq(".z-listbox");
        listboxBody = listbox.find(".z-listbox-body");
        verifyTrue(listbox.find(".z-listitem").eq(40).positionTop() < 0);
        verifyTrue(listbox.find(".z-listitem").eq(41).positionTop() >= 0);

      })
  }
}