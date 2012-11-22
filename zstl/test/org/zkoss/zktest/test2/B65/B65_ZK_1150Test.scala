package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1150.zul")
class B65_ZK_1150Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    You should not see any space ("nbsp") after "Help", please use browser "inspector" tool to see its HTML for the result.
                    <menubar id="menubar" width="100%">
                      <menu label="Project">
                        <menupopup>
                          <menuitem label="New"/>
                          <menuitem label="Open"/>
                        </menupopup>
                      </menu>
                      <menuitem label="Help" style="text-decoration:underline;"/>
                      <menu>
                        <menupopup>
                          <menuitem label="Index"/>
                        </menupopup>
                      </menu>
                    </menubar>
                  </zk>"""

    runZTL(zscript,
      () => {
        waitResponse()
        var text = jq("@menuitem").text();
        verifyEquals("should not see any space {nbsp} after [Help] ", jq("@menuitem").text(), "Help");
      })
  }
}