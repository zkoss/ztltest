package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1649.zul")
class B65_ZK_1649Test extends ZTL4ScalaTestCase {

  @Test
def testClick() = {
  val zscript = """<zk>
	<label multiline="true">
	Chrome/Safari/IE only
	Scroll the horizontal scroll bar, should not see content blinking.
	</label>
	<separator />
	<listbox width="300px">
		<listhead>
			<listheader width="120px" />
			<listheader width="120px" />
			<listheader width="120px" />
			<listheader width="120px" />
		</listhead>
		<listitem>
			<listcell label="Item 1" />
			<listcell label="Item 1" />
			<listcell label="Item 1" />
			<listcell label="Item 1" />
		</listitem>
		<listitem>
			<listcell label="Item 1" />
			<listcell label="Item 1" />
			<listcell label="Item 1" />
			<listcell label="Item 1" />
		</listitem>
		<listitem>
			<listcell label="Item 1" />
			<listcell label="Item 1" />
			<listcell label="Item 1" />
			<listcell label="Item 1" />
		</listitem>
	</listbox>
</zk>"""  
  runZTL(zscript,
    () => {
      
      horScroll(jq(".z-listbox"), 1)
      verifyImage()
    })
    
  }
}