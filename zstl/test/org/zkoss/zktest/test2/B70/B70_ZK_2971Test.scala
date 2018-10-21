package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2971.zul")
class B70_ZK_2971Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var listboxs = jq(".z-listbox");
        var listbox2 = listboxs.eq(1);
        val start = listbox2.find(".z-listitem").eq(6)
        evalScript(start.get(0) + ".scrollIntoView()")
        click(start)
        waitResponse()
        var real = listbox2.toWidget().$n("a")
        for (i <- 6 to 19) {
          sendKeys(real, Keys.DOWN);
          waitResponse();
        }
        waitResponse();
        listboxs = jq(".z-listbox");
        listbox2 = listboxs.eq(1);
        verifyEquals(listbox2.find(".z-paging-input").`val`(), "2");
        verifyEquals(listbox2.find(".z-listbox-body").scrollTop(), 0);
        verifyTrue(listbox2.find(".z-listitem").eq(0).hasClass("z-listitem-selected"));

        val listbox4 = listboxs.eq(3);
        click(listbox4.find(".z-listitem").eq(6));
        waitResponse();

        real = listbox4.toWidget().$n("a")
        val scrollTop4 = listbox4.find(".z-listbox-body").scrollTop();
        for (i <- 7 to 9) {
          sendKeys(real, Keys.SHIFT + "" + Keys.DOWN);
          waitResponse();
        }
        System.out.println(listbox4.find(".z-listbox-body").scrollTop())
        System.out.println(scrollTop4)
        verifyTrue(listbox4.find(".z-listbox-body").scrollTop() > scrollTop4);

        `type`(jq(".z-intbox"), "8");
        val selectButton = jq(".z-button:contains(select)");
        waitResponse();
        click(selectButton);
        waitResponse();

        val listbox1 = listboxs.eq(0);
        var listitem8 = listbox1.find(".z-listitem").eq(8);
        verifyTrue(listitem8.positionTop() > 0);
        verifyTrue(listitem8.positionTop() <= (listbox1.find(".z-listbox-body").height() - listitem8.height()));

        listitem8 = listbox2.find(".z-listitem").eq(8);
        verifyTrue(listitem8.positionTop() > 0);
        verifyTrue(listitem8.positionTop() <= (listbox2.find(".z-listbox-body").height() - listitem8.height()));
      })
  }
}
