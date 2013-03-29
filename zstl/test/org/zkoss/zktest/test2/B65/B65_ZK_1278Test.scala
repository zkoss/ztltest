package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1278.zul")
class B65_ZK_1278Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
<zk>
<script>
zk.afterMount(function () {
setTimeout(function () {
jq('#zk_log')[0].rows = 50;
}, 1000);
});
</script>
<label multiline="true">
1. Please open the "A" and then "B"
2. If the log information are added too much that is a bug. (the log textbox should not appear the scrollbar) 
</label>
<tree id="aggregationTree" zclass="z-dottree" mold="paging"
height="100%" width="100%" multiple="false" vflex="true"
hflex="true" style="border:none" renderdefer="0">
<treecols sizable="true">
<treecol label="Column Lable"/>
</treecols>
</tree>
<zscript><![CDATA[
public class SimpleTreeTestModel extends AbstractTreeModel {
	private static final long serialVersionUID = 1L;

	private static final String ROOT = "root";
	private static final int LEVELS = 6;
	public SimpleTreeTestModel() {
		super(ROOT);
	}

	public Object getChild(Object arg0, int arg1) {
		Clients.log("getChild() - Arg0: " + arg0 + ", Arg1: " +arg1);
		
		if (arg0.equals(ROOT)) {
			switch (arg1) {
				case 0 : return "A";
				case 1 : return "B";
				case 2 : return "C";
				case 3 : return "D";
				case 4 : return "E";
				default : return "IMPOSSIBLE";
			}
		}
		else {
			// E.g. A22222.
			return arg0 + arg1;
		}
	}

	public int getChildCount(Object arg0) {
		Clients.log("getChildCount() - Arg0: " + arg0);
		
		if (arg0.equals(ROOT)) {
			return 5;
		}
		
		if (arg0.length() <= LEVELS) {
			return 3;
		}
		
		// Impossible.
		return 0;
	}

	public boolean isLeaf(Object arg0) {
		//Clients.log("isLeaf() - Arg0: " + arg0);
		
		if (arg0.equals(ROOT)) {
			return false;
		}
		
		// E.g. A00000
		return arg0.length() == LEVELS;
	}
}
aggregationTree.setModel(new SimpleTreeTestModel());
]]></zscript>
</zk>
"""
    runZTL(zscript,
      () => {
        click(jq(".z-treecell:contains(A) .z-dottree-root-close"))
        waitResponse()
        click(jq(".z-treecell:contains(B) .z-dottree-root-close"))
        waitResponse()
        val log = jq("#zk_log")
        verifyEquals("the log textbox should not appear the scrollbar", log.scrollTop() <= log.height())
      })

  }
}