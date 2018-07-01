package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1728.zul")
class B65_ZK_1728Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	when you key up or down in combobox, you should not see 'test1' or 'test2'
	<combobox>
		<comboitem label="test1" visible="false" />
		<comboitem label="test2" visible="false" />
	</combobox>
</zk>"""
    runZTL(zscript,
      () => {
        val cb = jq(".z-combobox").toWidget()
        sendKeys(cb.$n("real"), Keys.UP)
        waitResponse()
        sendKeys(cb.$n("real"), Keys.DOWN)
        waitResponse()

        val bothVisible = jq(".z-comboitem:contains(test1)").isVisible()
        verifyTrue("you should not see 'test1' or 'test2'", !bothVisible)
      })

  }
}