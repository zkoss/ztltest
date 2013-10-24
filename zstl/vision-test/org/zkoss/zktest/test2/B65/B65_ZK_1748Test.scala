package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1748.zul")
class B65_ZK_1748Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?script content="zk.useStackup='auto'"?>
<zk>
when click menubar, then the menupopup should be in front of pdf
<menubar width="100%">
    <menu label="test">
    <menupopup>
    <menuitem label="test"/>
    <menuitem label="test"/>
    </menupopup>
    </menu>
</menubar>
<window title="iframe/pdf" border="normal" width="500px" sizable="true">
    <iframe style="background-color:transparent" src="http://jp.zkoss.org/doc/ZK-devref.pdf" width="100%" autohide="true"/>
</window>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-menu:contains(test)"))
      waitResponse()
      verifyImage()
    })
    
  }
}