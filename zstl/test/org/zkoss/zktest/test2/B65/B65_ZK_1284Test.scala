package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1284.zul")
class B65_ZK_1284Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<html>
		Testing instructions:
		<ol>
			<li>Scroll grid to the right-most position</li>
			<li>Click on the textbox in the first column -OR- <br/>
			    Press tab to move focus to it
			</li>
		</ol>
		
		Expected results:
		<ul>
			<li>If the header scrolls to the left, the body should scroll along with it.</li>
			<li>Column headings should match the row content. (e.g. Jan &lt;-&gt; Jan)</li>
		</ul>
	</html>
	<grid width="400px">
		<auxhead>
			<auxheader label="Q1" colspan="3">
				<textbox id="t1" width="200px" />
			</auxheader>
			<auxheader label="Q2" colspan="3">
				<textbox width="200px" />
			</auxheader>
		</auxhead>
		<columns>
			<column	label="Jan"	width="100px" />
			<column	label="Feb"	width="100px" />
			<column	label="Mar"	width="100px" />
			<column	label="Apr"	width="100px" />
			<column	label="May"	width="100px" />
			<column	label="Jun"	width="100px" />
		</columns>
		<rows>
			<row>
				<label value="Jan" />
				<label value="Feb" />
				<label value="Mar" />
				<label value="Apr" />
				<label value="May" />
				<label value="Jun" />
			</row>
		</rows>
	</grid>
</zk>
"""
    runZTL(zscript,
      () => {
        val grid = jq("@grid").toWidget()
        horScroll(grid, 1)
        focus(jq(".z-textbox:eq(0)"))
        waitResponse()
        
        val bodyLeft = jq(grid.$n("body")).scrollLeft();
        val headLeft = jq(grid.$n("head")).scrollLeft();
        
        verifyTrue("If the header scrolls to the left, the body should scroll along with it.", bodyLeft > 30 )
        verifyTrue("Column headings should match the row content.", bodyLeft == headLeft)
      })

  }
}