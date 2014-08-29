package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2363.zul")
class B70_ZK_2363Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<zk>
	<div>
		Maximize the window and restore it, you should be able to resize the window without any error
	</div>
	<window title="Test Max" border="normal" position="center" sizable="true" maximizable="true" minimizable="true" closable="true" width="488px">
	  <menubar>
	    <menu label="File" >
	      <menupopup>
	        <menu label="Test"></menu>
	      </menupopup> 
	    </menu>
	  </menubar>
	</window>
</zk>

"""  
  runZTL(zscript,
    () => {
      clickAt(jq(".z-window-maximize"), "1,1");
      waitResponse();
      clickAt(jq(".z-window-maximized"), "1,1");
      waitResponse();
      val win = jq("@window");
      val width = win.width();
      println(width);
      mouseDownAt(win, "0,20");
      waitResponse();
      mouseMoveAt(win, "50,20");
      waitResponse();
      mouseUpAt(win, "50,20");
      waitResponse();
      verifyFalse("you shouldn't see any js error.", jq(".z-error").exists());
    })
    
  }
}