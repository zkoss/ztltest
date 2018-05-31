package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1473.zul")
class B65_ZK_1473Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
        <zscript><![CDATA[
	org.zkoss.zul.ListModel m = new org.zkoss.zktest.test2.grid.FakeListModel(300);
	]]></zscript>
        <label multiline="true">
          1. Click "Option 0" in Listbox.
	2. Hold "down" key by keyboard to scroll down Listbox, should not see it jump back to top.
        </label>
        <window width="300px" height="300px">
          <listbox model="${m}" vflex="1">
            <custom-attributes org.zkoss.zul.listbox.rod="false"/>
            <listhead>
              <listheader label="Listbox"/>
            </listhead>
            <template name="model">
              <listitem label="${each}"/>
            </template>
          </listbox>
        </window>
      </zk>"""

    runZTL(zscript,
      () => {
        val opt = jq(".z-listitem:contains(Option 0)")
        click(opt)
        waitResponse()

        val seld = jq(".z-listitem-selected")

        keyPress(seld, Keys.DOWN + "")
        verifyNotEquals("should not see it jump back to top.", seld.html(), opt.html())

      })

  }
}
