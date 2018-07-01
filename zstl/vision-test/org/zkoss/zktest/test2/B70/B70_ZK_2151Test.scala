package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2151.zul")
class B70_ZK_2151Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<div>
		hover the outer listitem / treeitem, then the inner listitem /
		treeitem should not have hover color
	</div>
	<div>
		select the outer listitem / treeitem, then the inner listitem /
		treeitem should not be selected
	</div>

	<listbox checkmark="true" width="400px">
		<listitem>
			<listcell>col 1 row 1 (click)</listcell>
			<listcell>
				<listbox checkmark="true">
					<listitem>
						<listcell>nested item 1</listcell>
					</listitem>
					<listitem>
						<listcell>nested item 2</listcell>
					</listitem>
					<listitem>
						<listcell>nested item 3</listcell>
					</listitem>
				</listbox>
			</listcell>
		</listitem>
	</listbox>
	<listbox multiple="true" checkmark="true" width="400px">
		<listitem>
			<listcell>col 1 row 1 (click)</listcell>
			<listcell>
				<listbox multiple="true" checkmark="true">
					<listitem>
						<listcell>nested item 1</listcell>
					</listitem>
					<listitem>
						<listcell>nested item 2</listcell>
					</listitem>
					<listitem>
						<listcell>nested item 3</listcell>
					</listitem>
				</listbox>
			</listcell>
		</listitem>
	</listbox>
	<tree  checkmark="true" width="400px">
		<treechildren>
			<treeitem>
				<treerow>
					<treecell>col 1 row 1 (click)</treecell>
					<treecell>
						<tree checkmark="true">
							<treechildren>
								<treeitem>
									<treerow>
										<treecell>
											nested item 1
										</treecell>
									</treerow>
								</treeitem>
								<treeitem>
									<treerow>
										<treecell>
											nested item 2
										</treecell>
									</treerow>
								</treeitem>
								<treeitem>
									<treerow>
										<treecell>
											nested item 3
										</treecell>
									</treerow>
								</treeitem>
							</treechildren>
						</tree>
					</treecell>
				</treerow>
			</treeitem>
		</treechildren>
	</tree>
	<tree multiple="true" checkmark="true" width="400px">
		<treechildren>
			<treeitem>
				<treerow>
					<treecell>col 1 row 1 (click)</treecell>
					<treecell>
						<tree multiple="true" checkmark="true">
							<treechildren>
								<treeitem>
									<treerow>
										<treecell>
											nested item 1
										</treecell>
									</treerow>
								</treeitem>
								<treeitem>
									<treerow>
										<treecell>
											nested item 2
										</treecell>
									</treerow>
								</treeitem>
								<treeitem>
									<treerow>
										<treecell>
											nested item 3
										</treecell>
									</treerow>
								</treeitem>
							</treechildren>
						</tree>
					</treecell>
				</treerow>
			</treeitem>
		</treechildren>
	</tree>
</zk>"""
    runZTL(zscript,
      () => {
        0 to 1 foreach { index =>
          click(jq(".z-listbox").eq(index * 2).find(".z-listitem-checkable"))
          waitResponse()
          verifyImage()
        }
        0 to 1 foreach { index =>
          click(jq(".z-tree").eq(index * 2).find(".z-treerow-checkable"))
          waitResponse()
          verifyImage()
        }
      })

  }
}