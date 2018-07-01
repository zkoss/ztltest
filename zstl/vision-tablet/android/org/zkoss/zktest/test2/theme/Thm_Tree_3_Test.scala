package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Tree_3_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	Paging with Tree
	<radiogroup
		onCheck="tree4.pagingPosition = self.selectedItem.label;">
		<radio label="top" />
		<radio label="bottom" checked="true" />
		<radio label="both" />
	</radiogroup>
	<button label="Change Paging Mold">
		<attribute name="onClick">
		tree4.pagingChild.mold = "os".equals(tree4.pagingChild.mold) ? "default" : "os";
		</attribute>
	</button>

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

	<tree id="tree4" mold="paging" pageSize="15" model="${btm}">
		<attribute name="onCreate">
		tree4.renderItemByPath(new int[]{1,1,1,1,1,1,1,1,1,1,1,1});
		tree4.renderItemByPath(new int[]{0,0,0,0,0,0,0,0,0,0,0,0});
		</attribute>
	</tree>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Paging on Top
				singleTap(jq("input[type=radio]:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Paging on both
				singleTap(jq("input[type=radio]:eq(2)"));
				sleep(500);
				verifyImage();
				
				// Paging back to bottom
				singleTap(jq("input[type=radio]:eq(1)"));
				sleep(500);
				
				// Change Paging Mold
				singleTap(jq("@button:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Switch to Page 2
				singleTap(jq(".z-paging-os a:eq(1)"));
				sleep(500);
				verifyImage();
			});
	}
}