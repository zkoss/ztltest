package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2222.zul")
class B70_ZK_2222Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window>
	<div>listhead should align with listitem</div>
	<listbox span="true" width="200px">
		<listhead sizable="true">
			<listheader label="1" width="40px" />
			<listheader label="2" width="40px" visible="false" />
			<listheader label="3" width="40px" />
		</listhead>
		<listitem height="28px">
			<listcell label="1" />
			<listcell label="2" />
			<listcell label="3" />
		</listitem>
	</listbox>
</window>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}