package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1305.zul")
class B60_ZK_1305Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <div>
                      1. Click on the first listitem, should see "select index: 0" message showed.<separator/>
                      2. Should be able to drag test0 item.
                    </div>
                    <listbox height="200px" onSelect='lbl.value="select index: " + self.selectedIndex'>
                      <listitem label="test0" draggable="true"/>
                      <listitem label="test" draggable="true"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                      <listitem label="test"/>
                    </listbox>
                    <label id="lbl"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        val test0 = jq(".z-listitem:contains(test0)")
        click(test0)
        waitResponse()

        verifyTrue("should see 'select index: 0' message showed.", jq(".z-label:contains(select index: 0)").exists())

        val position = "2,2"
        val test = jq(".z-listitem:contains(test):eq(1)")

        dragdropToObject(test0, test, position, position);
        waitResponse()

        verifyTrue("Should be able to drag test0 item.", jq(".z-drop-ghost").exists())
      })

  }
}
