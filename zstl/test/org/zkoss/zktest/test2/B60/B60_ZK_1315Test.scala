package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B60-ZK-1315.zul")
class B60_ZK_1315Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      val zcolumn = jq(".z-column:contains(Author)")
      mouseOver(zcolumn)
      waitResponse()
      val zcolumnbtn = zcolumn.toWidget().$n("btn")
      click(zcolumnbtn)
      val zmenuitem = jq(".z-menuitem:contains(Title)").toWidget().$n("a")
      click(zmenuitem)
      waitResponse()
      val faker = jq(jq(".z-column:contains(Title)").toWidget().$n("hdfaker"))
      verifyEquals("Hide 'Title' column by menupopup.", faker.css("visibility"), "hidden")

      val publisher = jq("$col")
      if (!isSafari)
        click(publisher)
      else
        clickAt(publisher, "2,2")
      waitResponse()
      verifyTrue("Click 'Publisher' column to sort.", jq(publisher.toWidget().$n("sort-icon")).is("[class*=up]"))

      mouseOver(zcolumn)
      waitResponse()
      click(zcolumnbtn)
      waitResponse()
      click(zmenuitem)
      waitResponse()
      verifyNotEquals("Show 'Title' column by menupopup.", faker.css("visibility"), "hidden")

    })

  }
}
