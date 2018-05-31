/* B50_2971982Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 14:59:49 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug 2971982
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-2971982.zul,A,E,Treefooter,Listfooter")
class B50_2971982Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

			<zk>
				Check "Second footer" is in third column
				<hbox>
					<listbox id="listbox" width="300px">
						<listhead>
							<listheader label="First" />
							<listheader label="Second" />
							<listheader label="Third" />
						</listhead>
						<listitem>
							<listcell label="test1" />
							<listcell label="test2" />
							<listcell label="test3" />
						</listitem>
						<listfoot>
							<listfooter span="2" label="2 span footer" />
							<listfooter label="Second footer" />
						</listfoot>
					</listbox>
					<separator />
					<tree id="tree" width="300px">
						<treecols>
							<treecol label="First" />
							<treecol label="Second" />
							<treecol label="Third" />
						</treecols>
						<treechildren>
							<treeitem>
								<treerow>
									<treecell label="test1" />
									<treecell label="test2" />
									<treecell label="test3" />
								</treerow>
							</treeitem>
						</treechildren>
						<treefoot>
							<treefooter span="2" label="2 span footer" />
							<treefooter label="Second footer" />
						</treefoot>
					</tree>
				</hbox>
			</zk>

    """
    runZTL(zscript,
      () => {

        val listfootleft = jq(".z-listfooter:contains(Second)").offsetLeft()
        val listcellleft = jq(".z-listcell:contains(test3)").offsetLeft()
        val treefootleft = jq(".z-treefooter:contains(Second)").offsetLeft()
        val treecellleft = jq(".z-treecell:contains(test3)").offsetLeft()
        verifyTrue("Check 'Second footer' is in third column",
          (listfootleft == listcellleft) && (treefootleft == treecellleft))
      }
    );

  }
}