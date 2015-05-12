package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2371.zul")
class B70_ZK_2371Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<window mode="modal" closable="true">
	<grid>
	    <rows>
	        <row>
	            <vbox height="1800px">
	                <textbox width="400px" id="tb1Id" value="Please scroll down and click the Validate button"/>
	            </vbox>
	        </row>      
	        <row>
	            <textbox id="tb2Id" width="400px" constraint="no empty" />
	        </row>
	        <row>
	            <separator/>
	        </row>
	        <row>
	            <button label="Validate" width="150px" onClick="tb1Id.value = tb2Id.getValue()"/>
	        </row>
	    </rows>
	</grid>
</window>

"""  
  runZTL(zscript,
    () => {
      val btn = jq("@button");
      zk(btn).eval("scrollIntoView();'test';");
      waitResponse();
      click(btn);
      waitResponse();
      verifyTrue("it should show error box.", jq("@errorbox").isVisible());
    })
    
  }
}