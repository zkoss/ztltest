package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1712.zul")
class B65_ZK_1712Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	Open the calendar, click next month arrow button, should see input value keep blank.
	<datebox width="150px" constraint="no future" />
</zk>"""  
  runZTL(zscript,
    () => {
      val db = jq(".z-datebox").toWidget()
      click(db.$n("btn"))
      waitResponse()
      click(jq(db.$n("pp")).find(".z-calendar").toWidget().$n("tdr"))
      waitResponse()
      
      verifyTrue("should see input value keep blank.", db.$n("real").get("value")  == "")
    })
    
  }
}