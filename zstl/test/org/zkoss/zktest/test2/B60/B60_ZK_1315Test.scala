package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.util.Scripts

@Tags(tags = "B60-ZK-1315.zul")
class B60_ZK_1315Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <div>
                      1. Hide 'Title' column by menupopup.<separator/>
                      2. Click 'Publisher' column to sort.<separator/>
                      3. Show 'Title' column by menupopup. 'Title' column should show correctly.<separator/>
                    </div>
                    <grid sizedByContent="true">
                      <columns menupopup="auto">
                        <column label="Author" sort="auto"/>
                        <column label="Title" sort="auto"/>
                        <column label="Publisher" sort="auto"/>
                        <column label="Hardcover" sort="auto"/>
                      </columns>
                      <rows>
                        <row>
                          <label value="Philip Hensher"/>
                          <label value="The Northern Clemency"/>
                          <label value="Knopf (October 30, 2008)"/>
                          <label value="608 pages"/>
                        </row>
                        <row>
                          <label value="Philip Hensher"/>
                          <label value="The Fit"/>
                          <label value="HarperPerennial (April 4, 2005)"/>
                          <label value="240 pages"/>
                        </row>
                      </rows>
                    </grid>
                  </zk>"""

    runZTL(zscript,
      () => {
        val zcolumn = jq(".z-column:contains(Author)")
        Scripts.triggerMouseEventAt(getWebDriver(), zcolumn, "mouseover", "")
        waitResponse()
        val zcolumnbtn = zcolumn.find(".z-column-btn")
        Scripts.triggerMouseEventAt(getWebDriver(), zcolumnbtn, "click", "")
        waitResponse()
        val zmenuitem = jq(".z-menuitem:contains(Title)")
        Scripts.triggerMouseEventAt(getWebDriver(), zmenuitem, "click", "")
        waitResponse()
        val title = jq(".z-column:contains(Title)")
        verifyEquals("Hide 'Title' column by menupopup.", title.css("display"), "none")

        val publisher = jq(".z-column:contains(Publisher)")
        click(publisher)
        waitResponse()
        verifyTrue("Click 'Publisher' column to sort.", publisher.hasClass("z-column-sort-asc"))

        Scripts.triggerMouseEventAt(getWebDriver(), zcolumn, "mouseover", "")
        waitResponse()
        Scripts.triggerMouseEventAt(getWebDriver(), zcolumnbtn, "click", "")
        waitResponse()
        Scripts.triggerMouseEventAt(getWebDriver(), zmenuitem, "click", "")
        waitResponse()
        verifyNotEquals("Show 'Title' column by menupopup.", title.css("display"), "none")

        verifyEquals(jq("."), "")
      })

  }
}
