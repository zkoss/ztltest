package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1578.zul")
class B65_ZK_1578Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
        Should see window width is around 200px.
        <window title="Window" border="normal" hflex="min">
          <vlayout hflex="min">
            <grid hflex="min">
              <columns>
                <column hflex="min"/>
              </columns>
              <rows>
                <row>
                  <textbox width="157px"/>
                </row>
              </rows>
            </grid>
            <button label="Login" width="100px"/>
          </vlayout>
        </window>
        <div style="width:200px; background: blue; color: white">200px</div>
      </zk>"""

    runZTL(zscript,
      () => {
        verifyEquals(jq(".z-window-embedded").width(), jq(".z-div").width())
      })

  }
}
