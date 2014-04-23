package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2157.zul")
class B70_ZK_2157Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<div>should see 'Header 1' and 'Header 2' in mesh components</div>
	<listbox sizedByContent="true">
		<listhead>
			<listheader label="Header 1" />
			<listheader label="Header 2" />
		</listhead>
	</listbox>
	<grid sizedByContent="true">
		<columns>
			<column label="Header 1" />
			<column label="Header 2" />
		</columns>
	</grid>
	<tree sizedByContent="true">
		<treecols>
			<treecol label="Header 1" />
			<treecol label="Header 2" />
		</treecols>
	</tree>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}