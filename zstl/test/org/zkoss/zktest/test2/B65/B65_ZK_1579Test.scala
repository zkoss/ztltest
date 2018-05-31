package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1579.zul")
class B65_ZK_1579Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
        <label multiline="true">
          1. Click "toggle" button.
		2. See "Listbox B" showed.
		3. Click "toggle" button again.
		4. Should see "Listbox A" resized to match hflex="1".
        </label>
        <window title="Window1" border="normal" id="win" width="500px">
          <hlayout hflex="1" vflex="min">
            <vlayout hflex="1" vflex="min">
              <label value="Listbox A"/>
              <listbox hflex="1">
                <listitem label="A1"/>
                <listitem label="A2"/>
              </listbox>
            </vlayout>
            <vlayout hflex="1" vflex="min" id="d" visible="false">
              <label value="Listbox B"/>
              <listbox hflex="1">
                <listitem label="B1"/>
                <listitem label="B2"/>
              </listbox>
            </vlayout>
          </hlayout>
          <button label="toggle" onClick="d.visible = !d.visible;"/>
        </window>
      </zk>"""

    runZTL(zscript,
      () => {
        val window = jq(".z-window-embedded")
        val hlayout = window.find(".z-hlayout-inner")
        val wd0 = hlayout.width()
        val toggle = jq(".z-button:contains(toggle)")
        click(toggle)
        waitResponse()
        verifyTrue("See 'Listbox B' showed.", window.find(".z-label:contains(Listbox B)").exists())
        verifyTrue("See 'Listbox B' showed.", window.find(".z-listbox").exists())

        click(toggle)
        waitResponse()
        verifyEquals("Should see 'Listbox A' resized to match hflex='1'.", wd0, hlayout.width())

      })

  }
}
