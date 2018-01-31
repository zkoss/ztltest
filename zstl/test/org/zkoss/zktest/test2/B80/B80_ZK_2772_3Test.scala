package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper
import org.zkoss.ztl.JQuery

@Tags(tags = "B80-ZK-2772-3.zul")
class B80_ZK_2772_3Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      //save the original column width
      var originalWidths = List[Int]()
      var jqi = jq(".z-column").iterator()
      while(jqi.hasNext()) {
        originalWidths :+= jqi.next().width()
      }
      //sort column 6
      clickAt(jq(".z-column").eq(5), "2,2")
      waitResponse()
      //check the new column width
      jqi = jq(".z-column").iterator()
      for (width <- originalWidths) {
    	  verifyEquals(width, jqi.next().width())
      }
      //scroll to right
      nativeFrozenScroll(jq(".z-grid"), 400)
      waitResponse()
      //sort the last column
      clickAt(jq(".z-column").last(), "2,2")
      waitResponse()
      //check the new column width remains the same
      jqi = jq(".z-column").iterator()
      //skip index 5~8
      var i = 0
      for (width <- originalWidths) {
        if (i < 5 || i > 8)
    	    verifyEquals(width, jqi.next().width())
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
      mouseMoveAt(column7, (column7.outerWidth() + 100) + "," + (column7.outerHeight() / 2))
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
      clickAt(column7, "2,2")
      waitResponse()
      //check width should be the same
      jqi = jq(".z-column").iterator()
      for (width <- newWidths) {
        println(width)
        verifyEquals(width, jqi.next().width())
      }
    })
  }
}