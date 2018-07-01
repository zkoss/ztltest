/* B30_1884112Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 10, 2011 22:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-1884112.zul,B,E,Window,Button")
class B30_1884112Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
      <zk>
        <window title="dynamic tree" border="normal" id="win">
          <zscript>
            import org.zkoss.zktest.test2.tree.*;
		
		
		HostTreeModel model = new HostTreeModel();
		HostIconTreeRenderer renderer = new HostIconTreeRenderer();
          </zscript>
          <tree treeitemRenderer="${renderer}" model="${model}">
          </tree>
          Please open "Group0->host-0" and then test each button.
          <button label="add process icon at 0/0/3" onClick='model.addProcessType(0,0,3,"C")'/>
          <button label="remove process icon at 0/0/0" onClick='model.removeProcessType(0,0,0,"C")'/>
          <button label="update process icon at 0/0/0" onClick='model.updateProcessType(0,0,0,"C")'/>
        </window>
      </zk>
    """
    runZTL(zscript, () => {
      // Get the first node
      click(jq(".z-treerow:contains(Group0)").toWidget().$n("icon"));
      waitResponse();

      // Get the first cell of the open node
      click(jq(".z-treerow:contains(host-0)").toWidget().$n("icon"));
      waitResponse();

      // Click on first button
      click(jq(".z-button"));
      waitResponse();

      // Verify the new element
      click(jq(".z-label").get(3));
      verifyTrue(jq(".z-label:contains(p1000_10000_)").get(0).exists());

      // Remove 0/0/0
      // Click on second button. I search for .z-button because of a Selenium issue
      click(jq(".z-button").get(1));
      waitResponse();

      // Verify deleted element
      verifyTrue(!jq(".z-label:contains(p-0_0)").exists());

      // Remove 0/0/0
      // Click on third button. I search for .z-button because of a Selenium issue
      click(jq(".z-button").get(2));
      waitResponse();

      // Verify the modified label
      verifyTrue(jq(".z-label:contains(AAAAA)").exists());

    })
  }
}