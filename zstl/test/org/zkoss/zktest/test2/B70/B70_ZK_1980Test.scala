package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-1980.zul")
class B70_ZK_1980Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<div>
		<div>type '123' in first textbox and then click 'toolbarbutton', the label should show 123</div>
		<textbox id="txt" />
		<toolbarbutton label="toolbarbutton" draggable="true"
			width="100px">
			<attribute name="onClick">
				result.setValue(txt.getValue());
			</attribute>
		</toolbarbutton>
		<label id="result" />
	</div>
</zk>"""
    runZTL(zscript,
      () => {
        sendKeys(jq(".z-textbox"), "123")
        waitResponse()
        click(jq(".z-toolbarbutton"))
        waitResponse()
        verifyTrue("the label should show 123", jq(".z-label:contains(123)").exists)
      })

  }
}