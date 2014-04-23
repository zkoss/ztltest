package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-1996.zul")
class B70_ZK_1996Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window title="Click Navitem Label" border="normal" width="300px" height="300px">
<navbar id="nb" collapsed="false">
	<navitem label="Click me!" onClick='msg.appendChild(new Label("[click]"));' iconSclass="z-icon-flag"/>
</navbar>
Click on the "Click me!", it would show [click] once:
<div id="msg">
</div>
</window>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-navitem"))
      waitResponse()
      verifyTrue("it would show [click] once", jq(".z-div .z-label:contains([click])").length() == 1)
    })
    
  }
}