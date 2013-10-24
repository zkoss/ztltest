package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1726.zul")
class B65_ZK_1726Test extends ZTL4ScalaTestCase {

  val zscript = """<zk>
	<html><![CDATA[
		Test 1:
		<ol>
			<li>Open "Row A 0" node.</li>
			<li>Click "c1" column of "SubRow A 0 X" node. Browser should not freeze.</li>
		</ol>
		Test 2:
		<ol>
			<li>Refresh Browser</li>
			<li>Open "Row A 0" node and close.</li>
			<li>Click "c1" column of "Row A 0" node.</li>
			<li>Open "Row A 0" node again, should see its children nodes place on correct position.</li>
			<li>Repeat step 2-4 for "Row A 1" node.</li>
		</ol>
	]]></html>
	<tabbox vflex="1" id="myTab" apply="org.zkoss.zktest.test2.B65_ZK_1726_Composer">
		<tabs>
			<tab label="A" id="tab_a"/>
		</tabs>
		<tabpanels vflex="1">
			<tabpanel id="tabp_a" >
				<tree id="myTreeA"  vflex="1" hflex="1" >
					<treecols sizable="true">
				        <treecol label="c0" id="c0" hflex="1" />
				        <treecol label="c1" id="c1" hflex="1" />
					</treecols>
				</tree>
			</tabpanel>
		</tabpanels>
	</tabbox>
</zk>"""

  @Test
  def test1() = {
    runZTL(zscript,
      () => {
        val switch = jq(".z-treerow:contains(Row A 0)").toWidget().$n("open")
        click(switch)
        waitResponse()
        click(jq(".z-treerow:contains(Row A 0)").find(".z-treecell:eq(1)"))
        waitResponse()
        verifyImage()
      })
  }

  @Test
  def test2() = {
    runZTL(zscript,
      () => {

        val doCaptrue = (txt: String) => {
          val switch = jq(".z-treerow:contains(" + txt + ")").toWidget().$n("open")
          click(switch)
          waitResponse()
          click(switch)
          waitResponse()
          click(jq(".z-treerow:contains(" + txt + ")").find(".z-treecell:eq(1)"))
          waitResponse()
          click(switch)
          waitResponse()
          verifyImage()
        }

        doCaptrue("Row A 0")
        doCaptrue("Row A 1")
      })
  }
}