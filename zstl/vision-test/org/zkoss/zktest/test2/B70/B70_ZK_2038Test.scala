package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2038.zul")
class B70_ZK_2038Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk xmlns:n="native">
	<div>should see the border-bottom of grid</div>
	<vlayout height="100px">
		<div>123</div>
		<grid vflex="1" />
	</vlayout>
	<vlayout height="100px">
		<label value="123" />
		<grid vflex="1" />
	</vlayout>
	<vlayout height="100px">
		<a>123</a>
		<grid vflex="1" />
	</vlayout>
	<vlayout height="100px">
		<span>123</span>
		<grid vflex="1" />
	</vlayout>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}