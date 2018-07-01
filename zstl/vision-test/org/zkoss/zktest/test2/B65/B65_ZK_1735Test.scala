package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1735.zul")
class B65_ZK_1735Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<?page id="mypage" ?>
<window id="mywindow" border="none"
	apply="org.zkoss.zktest.test2.B65_ZK_1735_Composer">
	<div>
		when open and click 'Row A 0' node, then the tree should not overlap parent container. (ie6, 7 only) 
	</div>
	<tree id="myTreeA" vflex="1">
		<treecols>
			<treecol label="c0" id="c0A" />
			<treecol label="c1" id="c1A" />
		</treecols>
	</tree>
</window>
"""  
  runZTL(zscript,
    () => {
      click(jq(".z-treerow:contains(Row A 0)").toWidget().$n("open"))
      waitResponse()
      verifyImage()
    })
    
  }
}