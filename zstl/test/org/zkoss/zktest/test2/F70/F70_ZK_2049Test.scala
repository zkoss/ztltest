package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-2049.zul")
class F70_ZK_2049Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?page title="F70-ZK-2049" contentType="text/html;charset=UTF-8"?>
<zk>
<window title="F70-ZK-2049" border="normal">
	<vlayout>
		Click the button will open the menupopup, click again it will close.
		<button label="left click" popup="mp, type=toggle"/>
		<button label="right click" context="ct, type=toggle"/>
	</vlayout>
	<menupopup id="mp">
		<menuitem label="popup"/>
	</menupopup>
	<menupopup id="ct">
		<menuitem label="context"/>
	</menupopup>
</window>
</zk>"""  
  runZTL(zscript,
    () => {
      val btn = jq(".z-button").eq(0)
      val btn1 = jq(".z-button").eq(1)
      click(btn)
      waitResponse()
      verifyTrue("open the menupopup", jq(".z-menupopup").exists)
      
      clickAt(btn, "0,0")
      waitResponse()
      verifyTrue("it will close", !jq(".z-menupopup").isVisible())
      
      contextMenu(btn1)
      waitResponse()
      verifyTrue("open the menupopup", jq(".z-menupopup").exists)
      contextMenuAt(btn1, "0,0")
      waitResponse()
      verifyTrue("it will close", !jq(".z-menupopup").isVisible())
    })
    
  }
}