/* B50_3314143Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 14:41:55 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3314143
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3314143.zul,A,M,Tree")
class B50_3314143Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				Open the Treeitem. The dotted line should rendered correctly (NOT T shape).
				<tree id="tree" zclass="z-dottree">
					<treechildren>
						<treeitem label="Item" open="false">
							<treechildren>
								<treeitem label="Child Item" />
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
			</zk>

    """
    runZTL(zscript,
      () => {
        var tree: Widget = engine.$f("tree");

        click(jq(".z-treerow").toWidget().$n("open"));
        verifyTrue(jq(".z-treerow:contains(Child)").exists());
      }
    );

  }
}