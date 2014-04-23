package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2067.zul")
class B70_ZK_2067Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window id="wd" border="normal" width="400px" title="Popup in Overlapping and Modaling Window">
	<tree onClick="wd.doOverlapped();wd.doModal();">
			<treecols>
				<treecol/>
			</treecols>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="Click me should not show any error." popup="pp"/>
					</treerow>
				</treeitem>
			</treechildren>
	</tree>
	<popup id="pp">
		<label value="Popup"/>
	</popup>
</window>
"""  
  runZTL(zscript,
    () => {
      click(jq(".z-treecell"))
      waitResponse()
      verifyFalse("should see no javascript error", jq(".z-error").exists())
    })
    
  }
}