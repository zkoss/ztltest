package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1702.zul")
class B60_ZK_1702Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	Select any item in the combobox, should not see any java error.
	</label>
	<window id="win" apply="org.zkoss.zktest.test2.B60_ZK_1702_ComboboxComposer">
		<combobox id="cb" model="@{ctl.list}" selectedItem="@{ctl.selItem}"
				forward="onChange=onSelectItem" width="300px" readonly="true">
			<comboitem self="@{each=item}" value="@{item}" label="@{item.name}" />
		</combobox>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(jq(".z-combobox").toWidget().$n("btn")))
        waitResponse()
        click(jq(".z-comboitem:contains(1)"))
        waitResponse()
        verifyFalse("no exception", jq(".z-window-modal").exists());
      })

  }
}