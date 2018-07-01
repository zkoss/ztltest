package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2020.zul")
class B70_ZK_2020Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<div>
		input '123' into textbox and press 'enter' then should be able
		to edit textbox value
	</div>
	<window apply="org.zkoss.zktest.test2.B70_ZK_2020_Composer">
		<grid id="myGrid" hflex="">
			<columns id="record">
				<column>
					<textbox id="myFilter" />
				</column>
			</columns>
		</grid>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        val tb = jq(".z-textbox")
        sendKeys(tb, "123")
        waitResponse()
        verifyTrue("should be able to edit textbox value", tb.toElement().get("value") == "123")
      })

  }
}