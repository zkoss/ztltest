/* B36_2818308Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2818308Test extends ZTL4ScalaTestCase {
  @Test
  def testscrollIntoView() = {
    var zscript =
      """
			<zk>
			    Please press on the two buttons twice, and then the scroll bar should be placed as the position as the selected item (blue background).
			    <tree id="tree" width="400px" rows="3">
			        <treecols sizable="true">
			            <treecol label="Name" />
			            <treecol label="Description" />
			        </treecols>
			        <treechildren id="t">
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
			                        <treechildren id="tc">
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
			    <button label="add under bottom">
			        <attribute name="onClick">
			            Treeitem ti = new Treeitem();
			Treerow tr = new Treerow();
			tr.appendChild(new Treecell("test"));
			ti.appendChild(tr);
			tc.appendChild(ti);
			ti.setSelected(true);
			        </attribute>
			    </button>
			    <button label="add upon top">
			        <attribute name="onClick">
			            Treeitem ti = new Treeitem();
			Treerow tr = new Treerow();
			tr.appendChild(new Treecell("test"));
			ti.appendChild(tr);
			t.insertBefore(ti, t.firstChild);
			ti.setSelected(true);
			        </attribute>
			    </button>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    val t = ztl$engine.$f("t")
    val tc = ztl$engine.$f("tc")
    runZTL(zscript, () => {
      var body = jq(tree.$n("body"))
      var table = body.find("table")
      click(jq("@button[label=\"add under bottom\"]"))
      waitResponse()
      var scrollTop = getScrollTop(tree)
      verifyTolerant(215, scrollTop, 10)
      click(jq("@button[label=\"add under bottom\"]"))
      waitResponse()
      scrollTop = getScrollTop(tree)
      verifyTolerant(260, scrollTop, 10)
      click(jq("@button[label=\"add upon top\"]"))
      waitResponse()
      click(jq("@button[label=\"add upon top\"]"))
      waitResponse()
      verifyEquals(0, getScrollTop(tree))
    })
  }
}



