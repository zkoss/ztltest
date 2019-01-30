package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1642.zul")
class B65_ZK_1642Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">
	IE only
	Should see header width of "col2" and "col3" are equal to its content width 
	</label>
	<tree height="180px">
		<treecols>
			<treecol label="col1" hflex="1" />
			<treecol label="col2" />
			<treecol label="col3" />
		</treecols>
		<treechildren>
			<treeitem>
				<treerow>
					<treecell label="Item 1" />
					<treecell label="Item 1 description" />
					<treecell label="Item 1 description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item 2" />
					<treecell label="Item 2 description" />
					<treecell label="Item 1 description" />
				</treerow>
				<treechildren>
					<treeitem>
						<treerow>
							<treecell label="Item 2.1" />
							<treecell label="Item 1 description" />
						</treerow>
						<treechildren>
							<treeitem>
								<treerow>
									<treecell label="Item 2.1.1" />
									<treecell label="Item 1 description" />
								</treerow>
							</treeitem>
							<treeitem>
								<treerow>
									<treecell label="Item 2.1.2" />
									<treecell label="Item 1 description" />
								</treerow>
							</treeitem>
						</treechildren>
					</treeitem>
					<treeitem>
						<treerow>
							<treecell label="Item 2.2" />
							<treecell label="Item 2.2 is something who cares" />
							<treecell label="Item 1 description" />
						</treerow>
					</treeitem>
				</treechildren>
			</treeitem>
			<treeitem label="Item 3" />
		</treechildren>
	</tree>
</zk>"""
    runZTL(zscript,
      () => {
        verifyTolerant(jq(".z-treecol:eq(1)").width(), jq(".z-treecell:eq(1)").width(), 3)
        verifyTolerant(jq(".z-treecol:eq(2)").width(), jq(".z-treecell:eq(2)").width(), 3)
      })

  }
}