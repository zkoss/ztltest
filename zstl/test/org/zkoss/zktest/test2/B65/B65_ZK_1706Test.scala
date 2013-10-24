package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1706.zul")
class B65_ZK_1706Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<div>
		the textboxs, buttons 'Go' inside the toolbar or panelchildren should have same width
	</div>
	<panel border="normal" width="360px" height="360px" title="Panel A">
		<toolbar hflex="1">
			<button label="Add" />
			<button label="Delete" />
			<textbox hflex="1" value="Enter something to search..." />
			<button label="Go" hflex="1" />
		</toolbar>
		<panelchildren>
			<hlayout hflex="1">
				<button label="Add" />
				<button label="Delete" />
				<textbox hflex="1" value="Enter something to search..." />
				<button label="Go" hflex="1" />
			</hlayout>
		</panelchildren>
	</panel>
</zk>"""
    runZTL(zscript,
      () => {

        verifyTolerant(jq(".z-button:contains(Go):eq(0)").width(), jq(".z-button:contains(Go):eq(1)").width(), 2)
      })

  }
}