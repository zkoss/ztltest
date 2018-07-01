package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1686.zul")
class B65_ZK_1686Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
	Click next page button, should not see js error.
	<window>
		<tree mold="paging" pageSize="3">
			<treecols>
				<treecol label="Test" />
				<treecol label="Test" />
				<treecol label="Test" />
				<treecol label="Test" />
			</treecols>
			<treechildren>
				<treeitem draggable="true" label="Test" />
				<treeitem draggable="true" label="Test" />
				<treeitem draggable="true" label="Test" />
				<treeitem draggable="true" label="Test" />
			</treechildren>
		</tree>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq("[name=" + jq("@paging").attr("id") + "-next]"))
        waitResponse()
        verifyFalse("should not see js error.", jq(".z-error").exists())
      })

  }
}