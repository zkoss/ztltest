package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-2691.zul")
class B80_ZK_2691Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        //open the chosenbox menu
        click(jq(".z-chosenbox"))
        waitResponse()
        //select "Item 2"
        click(jq(".z-chosenbox-option:visible").eq(1))
        waitResponse()
        //open the chosenbox menu again
        click(jq(".z-chosenbox"))
        waitResponse()
        //select "Item 11"
        click(jq(".z-chosenbox-option:visible").eq(8))
        waitResponse()
        //open the chosenbox menu again
        click(jq(".z-chosenbox"))
        waitResponse()
        //select "Item 22"
        click(jq(".z-chosenbox-option:visible").eq(18))
        waitResponse()
        //make sure selected options are rendered correctly
        val expected = Array[String]("item0", "item121", "item10", "item2", "item11", "item22")
        for (i <- 0 to 5) {
          verifyEquals(expected(i), jq(".z-chosenbox-item-content").eq(i).text())
        }
        //click the invalidate button
        click(jq("button"))
        waitResponse()
        //check again
        for (i <- 0 to 5) {
          verifyEquals(expected(i), jq(".z-chosenbox-item-content").eq(i).text())
        }
      })
  }
}