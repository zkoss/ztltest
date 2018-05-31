package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1612.zul")
class B65_ZK_1612Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
<zk>

<zscript><![CDATA[
void changeTitle(org.zkoss.zul.Panel thePanel)
{
   thePanel.setTitle("Dropped!");
}

   ]]>
    </zscript>  
<label multiline="true">
1. Please click the "Button Image"
2. You should see a dialog and close it.
3. Please drag the "Button Image" into the window of the right side panel.
4. You should see the title of the right side panel is changed.
</label>
    <window width="800px" height="800px" border="normal" title="test">
    <grid>
    <rows>
    <row>
    <panel id="panel1" title="PANEL1" droppable="ABC" onDrop="changeTitle(panel1);">
    <panelchildren>
    <window width="200px" height="200px" border="normal" draggable="ABC">
    <toolbarbutton image="/img/button.png" onClick="alert(1)">

    </toolbarbutton>
    </window>
    </panelchildren>
    </panel>

    <panel id="panel2"  title="PANEL2" droppable="ABC" onDrop="changeTitle(panel2);">
    <panelchildren>
    <window width="200px" height="200px" border="normal" draggable="ABC" />
    </panelchildren>
    </panel>
    </row>
    </rows>
    </grid>
    </window>

</zk>
"""
    runZTL(zscript,
      () => {
        val img = jq("img[src*=button]")

        click(img)
        waitResponse()
        verifyTrue("You should see a dialog", jq(".z-messagebox-window").exists())

        click(jq(".z-button"))
        waitResponse()

        val header = jq(".z-panel-header:eq(1)")
        val headerText = header.text()

        val position = "2,2"
        val target = jq(".z-panel-body:eq(1)")
        mouseMoveAt(img, position)
        waitResponse

        mouseDownAt(img, position)
        waitResponse

        mouseMoveAt(target, position)
        waitResponse

        mouseUpAt(target, position)
        waitResponse

        verifyTrue("You should see the title of the right side panel is changed.", header.text() != headerText)
      })

  }
}