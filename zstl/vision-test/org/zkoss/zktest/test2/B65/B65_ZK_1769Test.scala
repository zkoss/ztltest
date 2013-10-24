package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1769.zul")
class B65_ZK_1769Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	when click menu, menuitem and menu agian, then the menuitem should not be on focus in ie 10.
	<menubar>
		<menu label="File">
			<menupopup>
				<menuitem label="1" />
				<menuitem label="1" />
				<menuitem label="1" />
			</menupopup>
		</menu>
	</menubar>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-menu"))
      waitResponse()
      click(jq(".z-menuitem"))
      waitResponse()
      click(jq(".z-menu"))
      waitResponse()
      verifyImage()
    })
    
  }
}