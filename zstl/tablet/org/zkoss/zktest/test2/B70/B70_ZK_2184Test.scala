package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2184.zul")
class B70_ZK_2184Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window title="Click Navitem Label" border="normal" width="400px" height="300px">
<navbar id="nb" collapsed="false">
	<navitem label="Click me!" onClick='msg.appendChild(new Label("[click]"));' iconSclass="z-icon-flag"/>
</navbar>
Click on the "Click me!" in tablet, it would show [click].
<separator />
<div id="msg">
</div>
</window>"""  
  runZTL(zscript,
    () => {
      singleTap(jq(".z-navitem:contains(Click)"))
      waitResponse()
      verifyTrue("it would show [click].", jq(".z-div .z-label:contains([click])").exists)
    })
    
  }
}