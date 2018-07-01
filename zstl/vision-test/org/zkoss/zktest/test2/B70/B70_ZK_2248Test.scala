package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2248.zul")
class B70_ZK_2248Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<div>should see groupbox inside window</div>
	<window border="normal" hflex="min" vflex="min">
		<script>console.log("hello 1");</script>
		<script>console.log("hello 2");</script>
		<groupbox id="box" width="200px">
			<div id="image" />
		</groupbox>
	</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}