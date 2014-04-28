package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.By
import org.openqa.selenium.interactions.internal.Coordinates
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.interactions.HasTouchScreen
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_016Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() {
		val zscript = {
<zk>
	<vlayout width="100%" height="100%">
	<vlayout hflex="1" vflex="1">
		1. Should see scrollbar inside tree component.
		<separator spacing="0"/>
		2. Open and close tree node, should see scroll bar size changed.
		<tree id="tree" height="200px">
			<treecols sizable="true">
				<treecol label="Tree-no-rod" />
			</treecols>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 2" />
					</treerow>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="Item 2.1" />
							</treerow>
						</treeitem>
						<treeitem>
							<treerow>
								<treecell label="Item 2.2" />
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
				<treeitem label="Item 3" />
				<treeitem>
					<treerow>
						<treecell label="Item 4" />
					</treerow>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="Item 4.1" />
							</treerow>
						</treeitem>
						<treeitem>
							<treerow>
								<treecell label="Item 4.2" />
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
				<treeitem label="Item 5" />
			</treechildren>
			<treefoot>
				<treefooter label="Count" />
			</treefoot>
		</tree>
	</vlayout>
	<vlayout hflex="1" vflex="1">
		1. Open the tree node 'Item 1' and click button to add 'Item 1-3'
		<separator spacing="0" />
		2. Should see scroll bar appeared.
		<tree height="170px">
			<treecols>
				<treecol label="Tree-rod" />
			</treecols>
			<treechildren>
				<treeitem open="false">
					<treerow>
						<treecell label="Item 1" />
					</treerow>
					<treechildren id="treechildren1">
						<treeitem open="false">
							<treerow>
								<treecell label="Item 1-1" />
							</treerow>
						</treeitem>
						<treeitem open="false">
							<treerow>
								<treecell label="Item 1-2" />
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
				<treeitem id="treeitem2" open="false">
					<treerow id="treerow2">
						<treecell label="Item 2" />
					</treerow>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="Item 2-1" />
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
				<treeitem open="false">
					<treerow>
						<treecell label="Item 3" />
					</treerow>
				</treeitem>
			</treechildren>
		</tree>
		<button label="Add Item 1-3">
			<attribute name="onClick">
				Treeitem item = new Treeitem();
				item.setParent(treechildren1);
				Treerow row = new Treerow();
				row.setParent(item);
				row.appendChild(new Treecell("Item 1-3"));
			</attribute>
		</button>
	</vlayout>
	</vlayout>
</zk>			
		};
		
		runZTL(zscript,
			() => {
				var treebodies = jq(".z-tree-body");

				// --------------------------------------------------------
				// Tree-no-rod
				// --------------------------------------------------------
				
				// Should have scroll bar
				var scroll_outer = treebodies.eq(0).find("> div:last-child");
				verifyNotEquals(0, scroll_outer.length());
				
				var scroll_inner  = scroll_outer.find("> div");
				var scroll_height = scroll_inner.height();
				
				// Close tree node
				singleTap(treebodies.find(".z-treerow:contains(Item 2)").toWidget().$n("open"));
				waitResponse();
				
				// Scroll bar should now be longer
				verifyTrue(scroll_inner.height() > scroll_height);
				
				// --------------------------------------------------------
				// Tree-rod
				// --------------------------------------------------------
				
				// Should have no scroll bar
				scroll_outer = treebodies.eq(1).find("> div:last-child");
				verifyEquals(0, scroll_outer.length());
				
				// Open tree node and click on 'button'
				singleTap(treebodies.eq(1).find(".z-treerow:contains(Item 1)").toWidget().$n("open"));
				waitResponse();
				
				singleTap(jq("@button"));
				waitResponse();
				
				// Should now see the scroll bar
				scroll_outer = treebodies.eq(1).find("> div:last-child");
				verifyEquals(1, scroll_outer.length());
			}
		);
	}
}