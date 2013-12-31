package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2035.zul")
class B65_ZK_2035Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?page title="Panel button" contentType="text/html;charset=UTF-8"?>
<zk>
	<window title="Panel button" border="normal">
		click panel button, then content will hide with no error message.
		<panel title="Panel" border="normal"
			collapsible="true" width="150px">
			<attribute name="onOpen"><![CDATA[
				self.invalidate();
			]]></attribute>
			<panelchildren>
				<button label="test button" />
			</panelchildren>
		</panel>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-panel").toWidget().$n("exp"))
        waitResponse
        verifyTrue("should not see error message", !jq(".z-error").exists)
      })

  }
}