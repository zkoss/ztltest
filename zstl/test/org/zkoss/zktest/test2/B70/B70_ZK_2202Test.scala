package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import org.openqa.selenium.Keys

@Tags(tags = "B70-ZK-2202.zul")
class B70_ZK_2202Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<div>1. Click datebox button</div>
	<div>3. Click up arrow of inner timebox to change hour</div>
	<div>4. Press Enter key, then the value of datebox should be updated</div>
	<datebox id="db" cols="20" format="yyyy/MM/dd a hh:mm:ss"
		onCreate="self.value = new Date()" />
</zk>"""
    runZTL(zscript,
      () => {
        val db = jq(".z-datebox").toWidget()
        val value = db.$n("real").get("value")
        click(db.$n("btn"))
        waitResponse()

        sendKeys(jq(".z-timebox").toWidget().$n("real"),
          Keys.HOME + "" + Keys.ARROW_RIGHT + "" + Keys.ARROW_RIGHT + "" + Keys.ARROW_RIGHT + "" + Keys.ARROW_UP
            + "" + Keys.ENTER)
        verifyTrue("the value of datebox should be updated", value != db.$n("real").get("value"))
      })

  }
}