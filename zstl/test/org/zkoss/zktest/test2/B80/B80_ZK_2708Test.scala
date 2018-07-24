package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-2708.zul")
class B80_ZK_2708Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var rowlayout = jq(".z-rowlayout").eq(0);
        var totalWidth = rowlayout.outerWidth();
        for (i <- 0 to 11) {
          var rowchildren = rowlayout.children().eq(i);
          if (i > 0) {
            var rowchildrenpre = rowlayout.children().eq(i - 1);
            verifyTrue(getEval("Math.abs(" + rowchildren.width() + "-" + rowchildrenpre.width() + ") < 2"))
          }
        }
        verifyTrue("total width must be equal to sum of children width", getEval("Math.abs(" + totalWidth + "-" + getEval("sumRowChildrenWidth(0, 12)") + ") < 15"))

        rowlayout = jq(".z-rowlayout").eq(6);
        totalWidth = rowlayout.outerWidth();
        for (i <- 0 to 1) {
          var rowchildren = rowlayout.children().eq(i);
          if (i > 0) {
            var rowchildrenpre = rowlayout.children().eq(i - 1);
            verifyTrue(getEval("Math.abs(" + rowchildren.width() + "-" + rowchildrenpre.width() + ") < 2"))
            //test offset
            verifyTrue(rowchildren.outerWidth(true) < rowchildrenpre.outerWidth(true));
          }
        }
        verifyTrue("total width must be equal to sum of children width", getEval("Math.abs(" + totalWidth + "-" + getEval("sumRowChildrenWidth(6, 2)") + ") < 15"))

        rowlayout = jq(".z-rowlayout").eq(9);
        totalWidth = rowlayout.outerWidth();
        for (i <- 0 to 11) {
          var rowchildren = rowlayout.children().eq(i);
          if (i > 0) {
            var rowchildrenpre = rowlayout.children().eq(i - 1);
            verifyTrue(getEval("Math.abs(" + rowchildren.width() + "-" + rowchildrenpre.width() + ") < 2"))
          }
        }
        verifyTrue("total width must be equal to sum of children width", getEval("Math.abs(" + totalWidth + "-" + getEval("sumRowChildrenWidth(9, 12)") + ") < 15"))

        var spinner = jq(".z-spinner-input");
        sendKeys(spinner, Keys.ARROW_DOWN);
        waitResponse();
        totalWidth = rowlayout.outerWidth();
        verifyTrue(rowlayout.children().length() == 11);
        for (i <- 0 to 10) {
          var rowchildren = rowlayout.children().eq(i);
          if (i > 0) {
            var rowchildrenpre = rowlayout.children().eq(i - 1);
            verifyTrue(getEval("Math.abs(" + rowchildren.width() + "-" + rowchildrenpre.width() + ") < 2"))
          }
        }
        verifyTrue("total width must be equal to sum of children width", getEval("Math.abs(" + totalWidth + "-" + getEval("sumRowChildrenWidth(9, 11)") + ") < 15"))
      })

  }
}