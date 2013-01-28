package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1577.zul")
class B65_ZK_1577Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
        Should see gap between each groupbox.
        <window title="hello" hflex="min" height="150px" border="normal">
          <hlayout hflex="min" vflex="1">
            <zk forEach="1,2,3">
              <groupbox title="groupbox ${each}" vflex="1" hflex="min" mold="3d" closable="false">
                <label value="line 1"/><separator/>
                <label value="line 2"/><separator/>
                <label value="line 3"/>
              </groupbox>
            </zk>
          </hlayout>
        </window>
        <window title="hello" width="300px" vflex="min" border="normal">
          <vlayout vflex="min">
            <zk forEach="1,2,3">
              <groupbox title="groupbox ${each}" vflex="min" hflex="1" mold="3d" closable="false">
                <label value="line 1"/><separator/>
                <label value="line 2"/><separator/>
                <label value="line 3"/>
              </groupbox>
            </zk>
          </vlayout>
        </window>
      </zk>"""

    runZTL(zscript,
      () => {
        verifyEquals("Should see gap between each groupbox.", jq(".z-window:eq(0) .z-hlayout-inner[style*=padding-right]").length(), 3)
        verifyEquals("Should see gap between each groupbox.", jq(".z-window:eq(1) .z-vlayout-inner[style*=padding-bottom]").length(), 3)
      })

  }
}
