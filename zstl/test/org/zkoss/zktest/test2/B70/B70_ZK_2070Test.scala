package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2070.zul")
class B70_ZK_2070Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?page title="Grid onScroll" contentType="text/html;charset=UTF-8"?>
<zk>
	<window title="Grid onScroll" border="normal">
		<zscript>Object[] o = new Object[50];</zscript>
		<label>
			scroll down "Grid1", then "Grid2" scroll position should synchronized.
		</label>
		<hlayout>
			<grid id="grid1" width="100px" height="150px">
				<columns>
					<column label="Grid1" />
				</columns>
				<rows>
					<row forEach="${o}">
						<label value="item ${forEachStatus.index}"/>
					</row>
				</rows>
			</grid>
			<grid id="grid2" width="100px" height="150px">
				<columns>
					<column label="Grid2" />
				</columns>
				<rows>
					<row forEach="${o}">
						<label value="item ${forEachStatus.index}"/>
					</row>
				</rows>
			</grid>
		</hlayout>
		<zscript><![CDATA[
			grid1.setWidgetListener("onScroll", "this.$f('grid2').ebody.scrollTop = this.ebody.scrollTop;");
		]]></zscript>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        val g0 = jq(".z-grid").eq(0)
        val g1 = jq(".z-grid").eq(1)

        verScroll(g0.toWidget(), 1)
        verifyTrue("then Grid2 scroll position should synchronized.", g0.find(".z-row:contains(49)").exists() && g1.find(".z-row:contains(49)").exists())
      })

  }
}