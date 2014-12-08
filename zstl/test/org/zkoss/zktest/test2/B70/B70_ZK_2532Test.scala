package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2532.zul")
class B70_ZK_2532Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk xmlns:w="client">
	<label multiline="true">
		1. try to type to each textbox
		2. you should see zk.log
	</label>
	textbox with onOK/onCancel listener
	<separator />
	<textbox onOK='alert("OK")' w:onKeyDown="zk.log('onOK');" />
	<textbox onCancel='alert("Cancel")' w:onKeyDown="zk.log('onCancel');"/>
	<textbox ctrlKeys="^k" onCtrlKey='alert("ctrl key")' w:onKeyDown="zk.log('onCtrlKey');"/>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      var text = jq(".z-textbox");
      var it = text.iterator();
      while (it.hasNext()) {
        var t = it.next();
        keyPress(t, "a");
        waitResponse();
      }
      var log = jq("#zk_log").eval("val()");
      verifyTrue(log.contains("onOK") && log.contains("onCancel") && log.contains("onCtrlKey"));
      
    })
    
  }
}