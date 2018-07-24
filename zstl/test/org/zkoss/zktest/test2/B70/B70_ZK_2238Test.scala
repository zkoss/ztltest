package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2238.zul")
class B70_ZK_2238Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<div>1. scroll to the bottom of tree</div>
	<div>2. open last tree node</div>
	<div>3. the tree should not out of view</div>
	<div height="400px" width="300px">
		<custom-attributes org.zkoss.zul.nativebar="true" />
		<zscript>
			List items = Collections.nCopies(100, "tree cell");
		</zscript>
		<tree model="@load(vm.dataObject.treeModel)" id="tree" hflex="1"
			vflex="1">
			<treechildren>
				<treeitem open="false" forEach="${items}">
					<treerow>
						<treecell>
							<label
								value="${each} ${forEachStatus.index}" />
						</treecell>
					</treerow>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell>
									<label
										value="${each} ${forEachStatus.index} - nested" />
								</treecell>
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
			</treechildren>
		</tree>
	</div>
</zk>"""
    runZTL(zscript,
      () => {
        val tree = jq(".z-tree")
        verScroll(tree, 100)
        click(jq(".z-treerow:contains(99)").toWidget().$n("open"))
        waitResponse()
        verifyTrue("the tree should not out of view", tree.isVisible())
      })

  }
}