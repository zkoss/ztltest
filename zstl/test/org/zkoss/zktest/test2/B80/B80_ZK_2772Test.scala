package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{JQuery, Tags, ZK}
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-2772.zul")
class B80_ZK_2772Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      //save the original column width
      var originalWidths = List[Int]()
      var jqi = jq(".z-column").iterator()
      while(jqi.hasNext()) {
        originalWidths :+= jqi.next().width() //append in place
      }
      //scroll to right
      nativeFrozenScroll(jq(".z-grid"), 400)
      waitResponse()
      //sort the last column
      if (!ZK.is("safari"))
        click(jq(".z-column").last())
      else
        clickAt(jq(".z-column").last(), "2,2")
      waitResponse()
      //check the new column width
      var cols = jq(".z-column")
      //skip index 5~8
      var i = 0
      for (width <- originalWidths) {
        println(i)
        if (i < 5 || i > 8)
         verifyTolerant(width, cols.eq(i).outerWidth(), 1)
        i += 1
      }
      //scroll to left
      nativeFrozenScroll(jq(".z-grid"), -400)
      waitResponse()
      //resize column 7
      val column7 = jq(".z-column").eq(6)
      val width_0 = column7.outerWidth()
      mouseMoveAt(column7, column7.outerWidth() + "," + (column7.outerHeight() / 2))
      waitResponse()
      mouseDownAt(column7, column7.outerWidth() + "," + (column7.outerHeight() / 2))
      waitResponse()
      mouseMoveAt(column7, (column7.outerWidth() - 100) + "," + (column7.outerHeight() / 2))
      waitResponse()
      mouseUp(column7)
      waitResponse()
      //save column width
      var newWidths = List[Int]()
      jqi = jq(".z-column").iterator()
      while(jqi.hasNext()) {
    	  newWidths :+= jqi.next().width()
      }
      //sort column 7
      if (!ZK.is("safari"))
        click(column7);
      else
        clickAt(column7, "2,2")
      waitResponse()
      //check width should be the same
      jqi = jq(".z-column").iterator()
      for (width <- newWidths) {
        verifyTolerant(width, jqi.next().outerWidth(), 1)
      }
    })
  }
}