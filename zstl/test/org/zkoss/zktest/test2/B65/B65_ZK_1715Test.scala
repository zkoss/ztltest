package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1715.zul")
class B65_ZK_1715Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">
	1. Select "item 1".
	2. Press Down key until change page, "item 4" and "item 5" should not be selected.
	3. Go back to page 1.
	4. Select "item 1".
	5. Press Shift + Down key until change page, "item 4" and "item 5" should not be selected.
	6. Go back to page 1.
	7. Select "item 3".
	8. Press PageDown key twice, should not see java error message.
	</label>
	<listbox width="300px" mold="paging" pageSize="3" multiple="true" checkmark="true">
		<listitem label="item 1"/>
		<listitem label="item 2"/>
		<listitem label="item 3"/>
		<listitem label="item 4" disabled="true" />
		<listitem label="item 5" disabled="true" />
		<listitem label="item 6"/>
		<listitem label="item 7"/>
	</listbox>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-listitem:contains(item 0)"))
        waitResponse()
        sendKeys(jq(".z-listitem:contains(item 1)"), Keys.DOWN)
        waitResponse()
        sendKeys(jq(".z-listitem:contains(item 2)"), Keys.DOWN)
        waitResponse()

        val hasOneSeld = jq(".z-listitem:contains(item 3)").hasClass("z-listitem-selected") || jq(".z-listitem:contains(item 4)").hasClass("z-listitem-selected")
        verifyFalse("'item 4' and 'item 5' should not be selected.", hasOneSeld)

        sendKeys(jq(".z-listitem:contains(item 3)"), Keys.UP)
        waitResponse()
        sendKeys(jq(".z-listitem:contains(item 1)"), Keys.SHIFT + "" + Keys.DOWN)
        waitResponse()
        sendKeys(jq(".z-listitem:contains(item 2)"), Keys.SHIFT + "" + Keys.DOWN)
        waitResponse()

        verifyFalse("'item 4' and 'item 5' should not be selected.", hasOneSeld)

        click(jq(".z-listitem:contains(item 2)"))
        waitResponse()
        sendKeys(jq(".z-listitem:contains(item 2)"), Keys.PAGE_DOWN + "" + Keys.PAGE_DOWN)

        verifyFalse("no exception", jq(".z-window-modal").exists());
      })

  }
}