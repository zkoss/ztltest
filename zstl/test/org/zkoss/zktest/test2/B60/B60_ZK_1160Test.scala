package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1160.zul")
class B60_ZK_1160Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk xmlns:h="http://www.w3.org/1999/xhtml">
  <borderlayout
    width="100%"
    height="100%"
    style="padding: 0px"
    apply="org.zkoss.zktest.test2.B60_ZK_1160_TabController">
    <north>
      <panel title="Instruction">
        <panelchildren>
          <div>1. Please click on "person" under menu.</div>
          <div>2. A tab labeled "person" with included content should appear on the right panel below.</div>
          <div>3. Close the "person" tab.</div>
          <div>4. Exception should not have occured.</div>
        </panelchildren>
      </panel>
    </north>
    <west
      width="200px"
      splittable="true"
      collapsible="true">
      <vlayout
        spacing="0"
        height="100%"
        style="overflow:auto">
        <panel title="menu">
          <panelchildren>
            <vbox>
              <toolbarbutton
                id="btnPerson"
                label="person" />
            </vbox>
          </panelchildren>
        </panel>
      </vlayout>
    </west>

    <east
      width="18%"
      splittable="true"
      visible="false" />

    <center>
      <tabbox
        id="tabMain"
        width="100%"
        height="100%">
        <tabs></tabs>
        <tabpanels></tabpanels>
      </tabbox>
    </center>
  </borderlayout>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-toolbarbutton:contains(person)"))
        waitResponse()
        sleep(1500)
        val tab = jq(".z-tab")
        verifyTrue(" A tab labeled 'person' should appear on the right panel below.",
          tab.exists)
        click(tab.toWidget().$n("btn"))
        waitResponse()
        verifyFalse("no exception", jq(".z-window-modal").exists());
      })

  }
}