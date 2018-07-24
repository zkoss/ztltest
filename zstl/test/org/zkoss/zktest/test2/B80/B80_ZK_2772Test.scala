package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-2772.zul")
class B80_ZK_2772Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      //save the original column width
      getEval("recordColsWidth()")
      //scroll to right
      nativeFrozenScroll(jq(".z-grid"), 400)
      waitResponse()
      //sort the last column
      click(jq(".z-column").last())
      waitResponse()
      //check the new column width
      var cols = jq(".z-column")
      //skip index 5~8
      for (i <- 0 to 9) {
        if (i < 5 || i > 8)
          verifyTolerant(getEval("getRecordedColWidth(" + i + ")").toInt, cols.eq(i).outerWidth(), 1)
      }
      //scroll to left
      nativeFrozenScroll(jq(".z-grid"), -400)
      waitResponse()
      //resize column 7
      val column7 = jq(".z-column").eq(6)
      val width_0 = column7.outerWidth()
      dragdropTo(column7, column7.outerWidth() + "," + (column7.outerHeight() / 2), (column7.outerWidth() - 100) + "," + (column7.outerHeight() / 2))
      waitResponse()
      mouseUp(column7)
      waitResponse()
      cols = jq(".z-column")
      //save column width
      getEval("recordColsWidth()")
      //sort column 7
      click(column7);
      waitResponse()
      //check width should be the same
      cols = jq(".z-column")
      for (i <- 0 to 9) {
        verifyTolerant(getEval("getRecordedColWidth(" + i + ")").toInt, cols.eq(i).outerWidth(), 1)
      }
    })
  }
}