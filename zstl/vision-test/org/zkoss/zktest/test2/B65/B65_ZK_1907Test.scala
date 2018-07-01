package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1907.zul")
class B65_ZK_1907Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window>
	<vlayout>
	type 81374562389765913874569283746592837465918645923749238475923745927349572934857 into intbox, 
	the content long number should not overlap the error message container. 
	<intbox/>
	</vlayout>
</window>"""  
  runZTL(zscript,
    () => {
      val box = jq(".z-intbox")
      typeKeys(box, "81374562389765913874569283746592837465918645923749238475923745927349572934857")
      waitResponse()
      clickAt(box, "100,100")
      waitResponse()
      verifyImage()
    })
    
  }
}