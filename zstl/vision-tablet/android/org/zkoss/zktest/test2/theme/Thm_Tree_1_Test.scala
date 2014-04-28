package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

@Tags(tags = "Android,VisionTest")
class Thm_Tree_1_Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
		val zscript = """
<zk>
	<tree id="tree" width="400px" rows="8">
		<treecols sizable="true">
			<treecol label="Name" />
			<treecol label="Description" />
		</treecols>
		<treechildren>
			<treeitem>
				<treerow>
					<treecell label="Item 1" />
					<treecell label="Item 1 description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item 2" />
					<treecell label="Item 2 description" />
				</treerow>
				<treechildren>
					<treeitem>
						<treerow>
							<treecell label="Item 2.1" />
						</treerow>
						<treechildren>
							<treeitem>
								<treerow>
									<treecell label="Item 2.1.1" />
								</treerow>
							</treeitem>
							<treeitem>
								<treerow>
									<treecell label="Item 2.1.2" />
								</treerow>
							</treeitem>
						</treechildren>
					</treeitem>
					<treeitem>
						<treerow>
							<treecell label="Item 2.2" />
						</treerow>
						<treechildren>
							<treeitem>
								<treerow>
									<treecell label="Item 2.2.1" />
								</treerow>
							</treeitem>
						</treechildren>
					</treeitem>
				</treechildren>
			</treeitem>
			<treeitem label="Item 3" />
		</treechildren>
	</tree>
	<separator/>
	Tree with Live Data
	<zscript>
	<![CDATA[
	import java.util.AbstractList;

	public class BigList extends java.util.AbstractList {
		private int _sz;
		
		public BigList(int sz) {
			if (sz < 0)
				throw new IllegalArgumentException("Negative not allowed: "+sz);
			_sz = sz;
		}

		public int size() {
			return _sz;
		}

		public Object get(int j) {
			return new Integer(j);
		}
	}
	
	public class BinaryTreeModel extends AbstractTreeModel {
		private ArrayList _tree =null;
	
		public BinaryTreeModel(List tree){
			super(tree.get(0));
			_tree = (ArrayList)tree;
		}
	
		//-- TreeModel --//
		public Object getChild(Object parent, int index) {
			int i = _tree.indexOf(parent) *2 +1 + index;
			if (i >= _tree.size())
				return null;
			else
				return _tree.get(i);
		}
	
		//-- TreeModel --//
		public int getChildCount(Object parent) {
			int count = 0;
			if (getChild(parent,0) != null)
				count++;
			if (getChild(parent,1) != null)
				count++;
			return count;
		}
	
		//-- TreeModel --//
		public boolean isLeaf(Object node) {
			return (getChildCount(node) == 0);
		}
	}
	
	TreeModel btm = new BinaryTreeModel(new ArrayList(new BigList(1000)));
	]]>
	</zscript>
	<tree id="tree2" model="${btm}"/>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				val tree = jq("$tree")
				// Close 2nd level tree node of 1st tree
				singleTap(tree.find(".z-treerow:contains(2.1)").toWidget().$n("open"));
				sleep(500);
				verifyImage();
				
				// Close 1st level tree node of 1st tree
				singleTap(tree.find(".z-treerow:contains(2)").toWidget().$n("open"));
				sleep(500);
				verifyImage();
				
				val tree2 = jq("$tree2")
				// Expand 1st level tree node of 2nd tree
				singleTap(tree2.find(".z-treerow:contains(1)").toWidget().$n("open"));
				sleep(500);
				singleTap(tree2.find(".z-treerow:contains(2)").toWidget().$n("open"));
				sleep(500);
				verifyImage();
				
				// Expand 2nd level tree node of 2nd tree
				singleTap(tree2.find(".z-treerow:contains(3)").toWidget().$n("open"));
				sleep(500);
				singleTap(tree2.find(".z-treerow:contains(4)").toWidget().$n("open"));
				sleep(500);
				verifyImage();
			});
	}
}