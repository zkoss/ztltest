package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1732.zul")
class B65_ZK_1732Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	Click <button label="show/hide">
		<attribute name="onClick"><![CDATA[
			lb.setVisible(!lb.isVisible());
			lb.invalidate();
		]]></attribute>
	</button> button, should see a listbox show/hide accordingly.
	<hlayout>
		<listbox id="lb" visible="false">
			<listhead>
				<listheader label="column" />
			</listhead>
			<listitem forEach="1,2,3" label="item ${each}" />
		</listbox>
	</hlayout>
</zk>
"""
    runZTL(zscript,
      () => {
        val btn = jq(".z-button:eq(0)")
        click(btn)
        waitResponse()

        verifyTrue("should see a listbox show", jq(".z-listbox").exists)

        click(btn)
        waitResponse()

        verifyTrue("should see a listbox hide", !jq(".z-listbox").isVisible())
      })

  }
}