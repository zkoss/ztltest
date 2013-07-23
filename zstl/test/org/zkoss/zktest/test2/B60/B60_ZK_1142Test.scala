package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B60-ZK-1142.zul")
class B60_ZK_1142Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
                    <window id="win_main" title="Hello IPad!!" border="normal" width="100%">
                      <vlayout>
                        <label>1. Try selecting New >> Document/Spreadsheet/Presentation.</label>
                        <label>2. You should see alert message displayed</label>
                      </vlayout>
                      <menubar id="menubar" width="100%">
                        <menu label="File">
                          <menupopup>
                            <menu label="New" style="cursor :pointer">
                              <menupopup id="m" style="cursor :pointer">
                                <menuitem label="Document" style="cursor :pointer" onClick="alert(self.label)"/>
                                <menuitem label="Spreadsheet" style="cursor:pointer" onClick="alert(self.label)"/>
                                <menuitem label="Presentation" style="cursor:pointer" onClick="alert(self.label)"/>
                              </menupopup>
                            </menu>
                            <menuitem label="Open.." onClick="alert(self.label)"/>
                            <menuseparator></menuseparator>
                            <menuitem label="Save" onClick="alert(self.label)"/>
                          </menupopup>
                        </menu>
                        <menuitem label="ZK Web Framework" onClick="alert(self.label)"/>
                      </menubar>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        val strs = List("Document", "Spreadsheet", "Presentation")
        val newMenu = jq(".z-menu:contains(New)")
        strs foreach { str =>
          click(jq("@menu:contains(File)"))
          waitResponse()
          click(newMenu)
          waitResponse()
          mouseOver(newMenu)
          waitResponse()
          mouseOver(jq("@menuitem:contains(" + str + ")"))
          waitResponse()
          click(jq("@menuitem:contains(" + str + ")"))
          waitResponse()
          verifyEquals("should see alert message displayed", jq(".z-messagebox-window @label").text(), str)
          click(jq("@button"))
          waitResponse()
        }

      })

  }
}
