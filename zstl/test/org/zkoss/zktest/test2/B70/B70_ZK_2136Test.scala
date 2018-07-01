package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2136.zul")
class B70_ZK_2136Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<zk>
	Dragging the cell label to hover the drop area should work fine
	<tree width="400px">
		<treechildren>
			<treeitem>
				<treerow draggable="true">
					<treecell id="item1" label="First Item" />
					<treecell label="Second Item" />
					<treecell>
						<div>Inner div</div>
					</treecell>
				</treerow>
			</treeitem>
		</treechildren>
	</tree>
	<listbox width="400px">
		<listitem draggable="true">
			<listcell label="First Item" />
			<listcell label="Second Item" />
			<listcell>
				<div>Inner div</div>
			</listcell>
		</listitem>
	</listbox>
	<div id="target" droppable="true" style="background-color: green" width="100px"
		height="100px">
		DROP HERE
	</div>
</zk>
"""
    runZTL(zscript,
      () => {
        // don't support ie9
        mouseDownAt(jq("$item1"), "5,2");
        waitResponse(true);
        mouseMoveAt(jq("$target"), "10,10");
        waitResponse(true);
        sleep(500);

        verifyContains("the detail text of the paging bar should be updated", jq(".z-drop-ghost").eval("attr('class')"), "z-drop-allow")
      })

  }
}