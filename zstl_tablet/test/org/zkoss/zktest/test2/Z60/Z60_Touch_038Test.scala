package org.zkoss.zktest.test2.Z60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_038Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
        <vlayout hflex="1" vflex="1">
          <div>
            iPad/Android Only<separator/>
            1. Should see Option 100 in Listbox 1 initially.<separator/>
            2. Should see Option 50 in Listbox 2 initially.
          </div>
          <hlayout hflex="1" vflex="1">
            <listbox id="lbx1" hflex="1" vflex="1">
              <custom-attributes org.zkoss.zul.listbox.rod="true"/>
              <listhead>
                <listheader label="Listbox 1"/>
              </listhead>
            </listbox>
            <listbox id="lbx2" hflex="1" vflex="1">
              <custom-attributes org.zkoss.zul.listbox.rod="false"/>
              <listhead>
                <listheader label="Listbox 2"/>
              </listhead>
            </listbox>
            <zscript><![CDATA[
				org.zkoss.zul.ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(250);
				lbx1.setModel(strset);
				lbx1.setSelectedIndex(100);
				lbx2.setModel(strset);
				lbx2.setSelectedIndex(50);
			]]></zscript>
          </hlayout>
        </vlayout>
      </zk>"""

    runZTL(zscript,
      () => {
        verifyEquals("Should see Option 100 in Listbox 1 initially.", jq(".z-listbox-body:eq(0)").scrollTop(), 3000)
        verifyEquals("Should see Option 50 in Listbox 2 initially.", jq(".z-listbox-body:eq(1)").scrollTop(), 1079)
      })

  }
}
