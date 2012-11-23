package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.util.Scripts

@Tags(tags = "B65-ZK-1315.zul")
class B65_ZK_1315Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk>
                    <div>
                      1. Hide 'Title' column by menupopup.<separator/>
                      2. Click 'Publisher' column to sort.<separator/>
                      3. Show 'Title' column by menupopup. 'Title' column should show correctly.<separator/>
                    </div>
                    <grid sizedByContent="true">
                      <auxhead>
                        <auxheader colspan="4" label="Grid"/>
                      </auxhead>
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
                    <listbox sizedByContent="true">
                      <auxhead>
                        <auxheader colspan="4" label="Listbox"/>
                      </auxhead>
                      <listhead menupopup="auto">
                        <listheader label="Author" sort="auto"/>
                        <listheader label="Title" sort="auto"/>
                        <listheader label="Publisher" sort="auto"/>
                        <listheader label="Hardcover" sort="auto"/>
                      </listhead>
                      <listitem>
                        <listcell label="Philip Hensher"/>
                        <listcell label="The Northern Clemency"/>
                        <listcell label="Knopf (October 30, 2008)"/>
                        <listcell label="608 pages"/>
                      </listitem>
                      <listitem>
                        <listcell label="Philip Hensher"/>
                        <listcell label="The Fit"/>
                        <listcell label="HarperPerennial (April 4, 2005)"/>
                        <listcell label="240 pages"/>
                      </listitem>
                    </listbox>
                  </zk>

    runZTL(zscript,
      () => {

        Scripts.triggerMouseEventAt(getWebDriver(), jq(".z-column"), "mouseover", "");
        waitResponse()
        val menupopupLink = jq(".z-column-btn:eq(1)")
        Scripts.triggerMouseEventAt(getWebDriver(), menupopupLink, "click", "");
        waitResponse()
        val titleDisplay = jq(".z-menuitem-cnt:contains(Title):eq(0)")
        Scripts.triggerMouseEventAt(getWebDriver(), titleDisplay, "click", "");
        waitResponse()

        val titleColumn = jq(".z-column.z-column-sort:contains(Title):eq(0)")
        verifyEquals("Hide 'Title' column by menupopup.", titleColumn.css("display"), "none")

        val publisher = jq(".z-column.z-column-sort:contains(Publisher):eq(0)")
        click(publisher)
        waitResponse()
        verifyTrue("Click 'Publisher' column to sort.", publisher.hasClass("z-column-sort-asc"))

        Scripts.triggerMouseEventAt(getWebDriver(), jq(".z-column"), "mouseover", "");
        waitResponse()
        Scripts.triggerMouseEventAt(getWebDriver(), menupopupLink, "click", "");
        waitResponse()
        Scripts.triggerMouseEventAt(getWebDriver(), titleDisplay, "click", "");
        waitResponse()
        verifyNotEquals("Show 'Title' column by menupopup.", titleColumn.css("display"), "none")

      })

  }
}
