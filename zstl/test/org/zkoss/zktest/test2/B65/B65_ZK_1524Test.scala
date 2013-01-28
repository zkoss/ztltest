package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1524.zul")
class B65_ZK_1524Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
        <label multiline="true">
          Issue : use caption in window will cause hflex="min" doesn't work.
	1. Width of "Title" window and "Caption" window should be the same.
	2. Check groupbox and panel also.
        </label>
        <window title="Title" border="normal" hflex="min">
          <div width="200px" height="50px"/>
        </window>
        <window border="normal" hflex="min">
          <caption label="Caption"/>
          <div width="200px" height="50px"/>
        </window>
        <separator/>
        <groupbox title="Title" hflex="min" mold="3d">
          <div width="200px" height="50px"/>
        </groupbox>
        <groupbox hflex="min" mold="3d">
          <caption label="Caption"/>
          <div width="200px" height="50px"/>
        </groupbox>
        <separator/>
        <panel title="Title" border="normal" hflex="min">
          <panelchildren>
            <div width="200px" height="50px"/>
          </panelchildren>
        </panel>
        <panel border="normal" hflex="min">
          <caption label="Caption"/>
          <panelchildren>
            <div width="200px" height="50px"/>
          </panelchildren>
        </panel>
      </zk>"""

    runZTL(zscript,
      () => {
        List("z-window-embedded", "z-groupbox-3d", "z-panel") foreach { cmpClass =>
          val cnt = jq("." + cmpClass)
          verifyEquals("Width of 'Title' window and 'Caption' container should be the same.", cnt.find(":contains(Title)").width(), cnt.find(":contains(Caption)").width())
        }
      })

  }
}
