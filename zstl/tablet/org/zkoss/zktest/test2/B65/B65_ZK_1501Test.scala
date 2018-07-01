package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1501.zul,Tablet")
class B65_ZK_1501Test extends ZTL4ScalaTestCase {

  @Test
def testClick() = {
  val zscript = """<zk>
	<label multiline="true">
	iPad/Android Only
	1. Scroll the grid horizontally.
	2. The footer should scroll too.
	</label>
	<grid>
		<zscript>Object[] o = new Object[20];</zscript>
		<columns>
			<column forEach="${o}" width="100px">Column</column>
		</columns>
		<rows>
			<row>
				<label forEach="${o}">Label</label>
			</row>
			<row>
				<label forEach="${o}">Label</label>
			</row>
			<row>
				<label forEach="${o}">Label</label>
			</row>
		</rows>
		<foot>
			<footer forEach="${o}">Footer</footer>
		</foot>
	</grid>
</zk>
"""  
  runZTL(zscript,
    () => {
      val body = jq(".z-grid-body")
      body.toElement().set("scrollLeft", 100)
      verifyEquals("The footer should scroll too.", body.scrollLeft() == jq(".z-grid-footer").scrollLeft())
    })
    
  }
}