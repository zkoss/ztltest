package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2514.zul")
class B70_ZK_2514Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
<label multiline="true">
	1. drag vertical splitter to left most position and drag to right
	2. you should see the width of Column 1 increase
	3. drag horizontal splitter to up most position
	4. you should see the total height of Column 1-1 plus Column 1-2 remains the same 
</label>
<panel title="Splitter" border="normal" width="500px">
    <panelchildren>
        <hbox spacing="0" width="100%" height="100%">
            <vbox spacing="0" width="100%"  heights="130px,130px">
                Column 1-1: The left-top box. To know whether a splitter
                is collapsed, you can listen to the onOpen event.
                <splitter id="s1" collapse="before" />
                Column 1-2: You can enforce to open or collapse programming
                by calling setOpen method.
            </vbox>
            <splitter id="s2" collapse="before"/>
             Column 2: Whether a splitter allows users to open or collapse
             depending on the collapse attribute.
        </hbox>
    </panelchildren>
</panel>
</zk>

"""  
  runZTL(zscript,
    () => {
      val vsplitter = jq(".z-splitter-horizontal")
      var startL = vsplitter.positionLeft()
      var startT = vsplitter.positionTop()
      val endL = startL - 200;
      dragdropTo(vsplitter, startL + "," + startT, endL + "," + startT)
      waitResponse(true)
      val oldWidth = jq(".z-vbox").width()
      startL = vsplitter.positionLeft()
      startT = vsplitter.positionTop()
      dragdropTo(vsplitter, startL + "," + startT, (startL + 30) + "," + startT)
      verifyTrue(jq(".z-vbox").width() - oldWidth > 0)
      waitResponse(true)
      val hsplitter = jq(".z-splitter-vertical")
      val oldHeight = jq(".z-vbox").height()
      startL = hsplitter.positionLeft()
      startT = hsplitter.positionTop()
      val endT = startT - 100
      dragdropTo(hsplitter, startL + "," + startT, startL + "," + endT)
      verifyTrue(jq(".z-vbox").height() - oldHeight == 0)
      
    })
    
  }
}