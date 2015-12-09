package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "F70-ZK-112.zul")
class F70_ZK_112Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """
    
<zk>
	<label multiline="true">
		1. drag vertical and horizontal splitter
		2. you should be able to resize those columns
	</label>
    <panel title="Splitter" border="normal" width="500px" >
        <panelchildren>
            <hbox spacing="0" width="100%" height="300px">
                <vbox spacing="0" hflex="1" heights="150px,150px">
                	<div vflex="1">
                    Column 1-1: The left-top box. To know whether a splitter
                    is collapsed, you can listen to the onOpen event.
                    </div>
                    <splitter id="s1" collapse="before"/>
                    <div vflex="1">
                    Column 1-2: You can enforce to open or collapse programming
                    by calling setOpen method.
                    </div>
                </vbox>
                <splitter id="s2" collapse="before"/>
              	<div hflex="1">
                  Column 2: Whether a splitter allows users to open or collapse
                  depending on the collapse attribute.
              	</div>
            </hbox>
        </panelchildren>
    </panel>
</zk>
  
"""  
  runZTL(zscript,
    () => {
      var vsplitter = jq(".z-splitter-icon.z-icon-ellipsis-vertical").eq(0);
      var startL = vsplitter.positionLeft();
      var startT = vsplitter.positionTop();
      var endL = startL - 200;
      dragdropTo(vsplitter, startL + "," + startT, endL + "," + startT);
      waitResponse(true);
      var oldWidth = jq(".z-vbox").width();
      startL = vsplitter.positionLeft();
      startT = vsplitter.positionTop();
      dragdropTo(vsplitter, startL + "," + startT, (startL + 30) + "," + startT);
      waitResponse(true);
      verifyTrue(jq(".z-vbox").width() - oldWidth > 0);
      
      var hsplitter = jq(".z-splitter-icon.z-icon-ellipsis-horizontal").eq(0);
      var oldHeight = jq(jq(".z-div").first().toWidget().$n("chdex")).height();
      startL = hsplitter.positionLeft();
      startT = hsplitter.positionTop();
      var endT = startT - 100;
      dragdropTo(hsplitter, startL + "," + startT, startL + "," + endT);
      waitResponse(true);
      verifyTrue(jq(jq(".z-div").first().toWidget().$n("chdex")).height() - oldHeight < 0);
    })
    
  }
}