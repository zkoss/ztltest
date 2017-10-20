package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper
import org.zkoss.ztl.JQuery

@Tags(tags = "B80-ZK-2772-2.zul")
class B80_ZK_2772_2Test extends ZTL4ScalaTestCase {

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
      if(!isSafari)
        click(jq(".z-column").eq(5));
      else
        clickAt(jq(".z-column").eq(5), "2,2");
      waitResponse()
      //check the new column width
      jqi = jq(".z-column").iterator()
      for (width <- originalWidths) {
    	  verifyEquals(width, jqi.next())
      }
      //scroll to right
      nativeFrozenScroll(jq(".z-grid"), 1000)
      waitResponse()
      //sort the last column
      if(!isSafari)
        click(jq(".z-column").last());
      else
        clickAt(jq(".z-column").last(), "2,2");
      waitResponse()
      //check the new column width remains the same
      jqi = jq(".z-column").iterator()
      for (width <- originalWidths) {
    	  verifyEquals(width, jqi.next())
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
      jqi = jq(".z-column").iterator()
      while(jqi.hasNext()) {
    	  newWidths :+= jqi.next().width()
      }
      //sort column 7
      if(!isSafari)
        click(column7);
      else
        clickAt(column7, "2,2");
      waitResponse()
      //check width should be the same
      jqi = jq(".z-column").iterator()
      for (width <- newWidths) {
        verifyEquals(width, jqi.next())
      }
    })
  }
}