package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-2772-2.zul")
class B80_ZK_2772_2Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        //save the original column width
        var originalWidths = List[Int]()
        var cols = jq(".z-column")
        var index = 0
        while (index < cols.length()) {
          originalWidths :+= cols.eq(index).next().width() //append in place
          index += 1
        }
        //sort column 6
        if (!isSafari)
          click(jq(".z-column").eq(5));
        else
          clickAt(jq(".z-column").eq(5), "2,2");
        waitResponse()
        //check the new column width
        cols = jq(".z-column")
        index = 0
        for (width <- originalWidths) {
          verifyTolerant(width, cols.eq(index).outerWidth(), 1)
          index += 1
        }
        //scroll to right
        nativeFrozenScroll(jq(".z-grid"), 1000)
        waitResponse()
        //sort the last column
        if (!isSafari)
          click(jq(".z-column").last());
        else
          clickAt(jq(".z-column").last(), "2,2");
        waitResponse()
        //check the new column width remains the same
        cols = jq(".z-column")
        //skip index 5~18
        var i = 0
        for (width <- originalWidths) {
          println(i)
          if (i < 5 || i > 18)
            verifyTolerant(width, cols.eq(i).outerWidth(), 1)
          i += 1
        }
        //scroll to left
        nativeFrozenScroll(jq(".z-grid"), -1000)
        waitResponse()
        //resize column 7
        val column7 = jq(".z-column").eq(6)
        val width_0 = column7.outerWidth()
        mouseMoveAt(column7, column7.outerWidth() + "," + (column7.outerHeight() / 2))
        waitResponse()
        mouseDownAt(column7, column7.outerWidth() + "," + (column7.outerHeight() / 2))
        waitResponse()
        mouseMoveAt(column7, (column7.outerWidth() - 150) + "," + (column7.outerHeight() / 2))
        waitResponse()
        mouseUp(column7)
        waitResponse()
        //save column width
        var newWidths = List[Int]()
        cols = jq(".z-column")
        index = 0
        while (index < cols.length()) {
          newWidths :+= cols.eq(index).width()
          index += 1
        }
        //sort column 7
        if (!isSafari)
          click(column7);
        else
          clickAt(column7, "2,2");
        waitResponse()
        //check width should be the same
        cols = jq(".z-column")
        index = 0
        for (width <- newWidths) {
          verifyTolerant(width, cols.eq(index).outerWidth(), 1)
          index += 1
        }
      })
  }
}