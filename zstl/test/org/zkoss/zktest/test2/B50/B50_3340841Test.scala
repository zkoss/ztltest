/* B50_3340841Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct 12 13:01:21 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3340841
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3340841.zul,A,M,Listbox,Tree")
class B50_3340841Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				The first Listitem/Treeitem should be selected (and the checkmark should be checked).
				<listbox id="listbox" multiple="true" checkmark="true" width="200px"
					sclass="readonly-listbox">
					<listhead>
						<listheader>Population</listheader>
					</listhead>
					<listitem selected="true" disabled="true">
						<listcell>A. Graduate</listcell>
					</listitem>
					<listitem disabled="true">
						<listcell>B. College</listcell>
					</listitem>
				</listbox>
				<tree id="tree" multiple="true" checkmark="true" width="200px">
					<treecols>
						<treecol>Population</treecol>
					</treecols>
					<treechildren>
						<treeitem selected="true" disabled="true">
							<treerow>
								<treecell>A. Graduate</treecell>
							</treerow>
						</treeitem>
						<treeitem disabled="true">
							<treerow>
								<treecell>B. College</treecell>
							</treerow>
						</treeitem>
					</treechildren>
				</tree>
			</zk>

    """

    def executor = () => {
      verifyTrue(jq(".z-listitem:eq(0)").hasClass("z-listitem-selected"));
      verifyTrue(jq(".z-treerow:eq(0)").hasClass("z-treerow-selected"));
    }

    runZTL(zscript, executor);

  }
}