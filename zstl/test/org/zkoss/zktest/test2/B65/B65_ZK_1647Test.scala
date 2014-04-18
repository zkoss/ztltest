package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1647.zul")
class B65_ZK_1647Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	1. Should not see horizontal scrollbar showed.
	2. Pink area should be twice as wide as the blue area.
	</label>
	<separator />
	<hbox width="400px">
		<tree hflex="1">
			<treecols>
				<treecol hflex="1" />
				<treecol hflex="2" />
				<treecol width="50px"/>
			</treecols>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="Item 1" style="background: cyan" />
						<treecell label="Item 1" style="background: pink" />
						<treecell label="Item 1" />
					</treerow>
				</treeitem>
			</treechildren>
		</tree>
	</hbox>
</zk>"""
    runZTL(zscript,
      () => {
        verifyTrue("Should not see horizontal scrollbar showed.", jq(".z-tree-body").width() >= jq("z-treerow").width())
        val diff = (jq(".z-treecell[style*=pink]").outerWidth() - 2 * jq(".z-treecell[style*=cyan]").outerWidth())
        verifyTrue("Pink area should be twice as wide as the blue area.", diff <= 1)
      })

  }
}