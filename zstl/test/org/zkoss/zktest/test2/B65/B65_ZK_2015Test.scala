package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-2015.zul")
class B65_ZK_2015Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<window title="IE10 Only" xmlns:n="native" border="normal">
	Click show and hide, BB and CC will show and hide normally.
	<button label="show">
		<attribute name="onClick"><![CDATA[
			cell1.setVisible(true);
			cell2.setVisible(true);
		]]></attribute>
	</button>
	<button label="hide">
		<attribute name="onClick"><![CDATA[
			cell1.setVisible(false);
			cell2.setVisible(false);
		]]></attribute>
	</button>

	<grid width="300px" id="grid">
		<columns>
			<column label="col" />
			<column label="col" />
			<column label="col" />
		</columns>
		<rows>
			<row>
				<cell>AA</cell>
				<cell id="cell1">BB</cell>
				<cell id="cell2">CC</cell>
			</row>
		</rows>
	</grid>
</window>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(show)"))
        waitResponse()
        click(jq(".z-button:contains(hide)"))
        waitResponse()
        verifyContains("BB and CC will hide", jq(".z-cell:contains(BB)").attr("style"), "none")
        verifyContains("BB and CC will hide", jq(".z-cell:contains(CC)").attr("style"), "none")
        click(jq(".z-button:contains(show)"))
        waitResponse()
        verifyNotContains("BB and CC will show", jq(".z-cell:contains(BB)").attr("style"), "none")
        verifyNotContains("BB and CC will show", jq(".z-cell:contains(CC)").attr("style"), "none")
      })

  }
}