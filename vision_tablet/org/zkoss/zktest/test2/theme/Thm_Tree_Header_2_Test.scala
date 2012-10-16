package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Tree_Header_2_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
<hbox>
<window title="live data" border="normal">
	<radiogroup
		onCheck="tree.pagingPosition = self.selectedItem.label;">
		<radio label="top" />
		<radio label="bottom" checked="true" />
		<radio label="both" />
	</radiogroup>
	<button label="Change Paging Mold">
		<attribute name="onClick">
		tree.pagingChild.mold = "os".equals(tree.pagingChild.mold) ? "default" : "os";
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
	<tree id="tree" model="${btm}" width="400px" mold="paging" pageSize="3">
		<treecols>
			<treecol label="Align Left" align="left" width="100px"/>
		</treecols>
		<treefoot>
			<treefooter label="footer width Image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
		</treefoot>
	</tree>
</window>
</hbox>
<div height="10px"></div>
<hbox>
<window title="Dot Tree" border="normal">
	<radiogroup
		onCheck="tree.pagingPosition = self.selectedItem.label;">
		<radio label="top" />
		<radio label="bottom" checked="true" />
		<radio label="both" />
	</radiogroup>
	<button label="Change Paging Mold">
		<attribute name="onClick">
		tree.pagingChild.mold = "os".equals(tree.pagingChild.mold) ? "default" : "os";
		</attribute>
	</button>
	<tree id="tree" width="400px" zclass="z-dottree" mold="paging" pageSize="7">
		<auxhead>
			<auxheader label="A+B" colspan="2"/>
		</auxhead>
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
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
		</treechildren>
		<auxhead>
			<auxheader label="C" />
			<auxheader label="D" />
		</auxhead>
		<treefoot>
			<treefooter label="footer 1"/>
			<treefooter label="footer width Image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
		</treefoot>
	</tree>
</window>

<window title="XP Explorer" border="normal">
	<radiogroup
		onCheck="tree.pagingPosition = self.selectedItem.label;">
		<radio label="top" />
		<radio label="bottom" checked="true" />
		<radio label="both" />
	</radiogroup>
	<button label="Change Paging Mold">
		<attribute name="onClick">
		tree.pagingChild.mold = "os".equals(tree.pagingChild.mold) ? "default" : "os";
		</attribute>
	</button>
	<tree id="tree" width="400px" zclass="z-filetree" mold="paging" pageSize="7">
		<treecols sizable="true">
			<treecol label="Name" />
			<treecol label="Description" />
		</treecols>
		<auxhead>
			<auxheader label="A+B" colspan="2"/>
		</auxhead>
		<auxhead>
			<auxheader label="C" />
			<auxheader label="D" />
		</auxhead>
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
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
		</treechildren>
		<treefoot>
			<treefooter label="footer 1"/>
			<treefooter label="footer width Image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
		</treefoot>
	</tree>
</window>

<window title="Vista Explorer" border="normal">
	<radiogroup
		onCheck="tree.pagingPosition = self.selectedItem.label;">
		<radio label="top" />
		<radio label="bottom" checked="true" />
		<radio label="both" />
	</radiogroup>
	<button label="Change Paging Mold">
		<attribute name="onClick">
		tree.pagingChild.mold = "os".equals(tree.pagingChild.mold) ? "default" : "os";
		</attribute>
	</button>
	<tree id="tree" width="400px" zclass="z-vfiletree" mold="paging" pageSize="7">
		<auxhead>
			<auxheader label="A+B" colspan="2"/>
		</auxhead>
		<auxhead>
			<auxheader label="C" />
			<auxheader label="D" />
		</auxhead>
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
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
			<treeitem>
				<treerow>
					<treecell label="Item " />
					<treecell label="Item description" />
				</treerow>
			</treeitem>
		</treechildren>
		<treefoot>
			<treefooter label="footer 1"/>
			<treefooter label="footer width Image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
		</treefoot>
	</tree>
</window>
</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}