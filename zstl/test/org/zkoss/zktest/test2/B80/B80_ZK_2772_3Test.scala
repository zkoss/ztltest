package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-2772-3.zul")
class B80_ZK_2772_3Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        //save the original column width
        getEval("recordColsWidth()")
        //sort column 6
        clickAt(jq(".z-column").eq(5), "2,2")
        waitResponse()
        //check the new column width
        var cols = jq(".z-column")
        for (i <- 0 to 9) {
          verifyTolerant(getEval("getRecordedColWidth(" + i + ")").toInt, cols.eq(i).outerWidth(), 1)
        }
        //scroll to right
        nativeFrozenScroll(jq(".z-grid"), 400)
        waitResponse()
        //sort the last column
        clickAt(jq(".z-column").last(), "2,2")
        waitResponse()
        //check the new column width remains the same
        //skip index 5~8
        var i = 0
        cols = jq(".z-column")
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
        dragdropTo(column7, column7.outerWidth() + "," + (column7.outerHeight() / 2), (column7.outerWidth() + 100) + "," + (column7.outerHeight() / 2))
        waitResponse()
        //save column width
        getEval("recordColsWidth()")
        //sort column 7
        clickAt(column7, "2,2")
        waitResponse()
        //check width should be the same
        cols = jq(".z-column")
        for (i <- 0 to 9) {
          verifyTolerant(getEval("getRecordedColWidth(" + i + ")").toInt, cols.eq(i).outerWidth(), 1)
        }
      })
  }
}