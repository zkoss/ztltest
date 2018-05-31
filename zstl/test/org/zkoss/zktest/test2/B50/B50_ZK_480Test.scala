/* B50_ZK_480Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Oct 11, 2011 18:15:14 PM , Created by benbai
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
  * A test class for bug ZK-480
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-480.zul,A,E,Tree,ROD,DragDrop")
class B50_ZK_480Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<div>Open the Treeitem. You should NOT see javascript error.</div>
				<tree id="tree">
					<treechildren>
						<treeitem id="ti" label="Item 1" open="false">
							<treechildren>
								<treeitem draggable="true" label="Item 2" />
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
			</zk>
    """

    def executor = () => {
      click(jq(".z-treerow").toWidget().$n("icon"));
      waitResponse();
      verifyFalse(jq(".z-error").exists());
    }

    runZTL(zscript, executor);

    // Run syntax 2
    /**
      * runZTL(zscript,
      * () => {
      * var l1: Widget = engine.$f("l1");
      * var l2: Widget = engine.$f("l2");
      * waitResponse();
      * var strClickBefor = getText(l1);
      * click(l1);
      * waitResponse();
      * verifyNotEquals(strClickBefor, getText(l1));
      * strClickBefor = getText(l2);
      * click(l2);
      * waitResponse();
      * verifyNotEquals(strClickBefor, getText(l2));
      * }
      * );
      */
  }
}