/* B30_2125788Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 9, 2012 10:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Element

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-2125788.zul,B,E,Window,Button")
class B30_2125788Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <window>
        <window id="win" title="My First Window" border="normal" width="200px" closable="true">
          Hello, World!
          <button label="2. Click Me" onClick='win.setTitle("If the window is in front of the mask, that is correct!")'/>
        </window>
        <button label="1. Click ME First!" onClick="win.doHighlighted()"/>
      </window>
    """
    runZTL(zscript, () => {
      // Click on first button
      click(jq("@button:eq(1)"));
      waitResponse();

      // Click on second button
      click(jq("@button:eq(0)"));
      waitResponse();

      // Record the z-index of the mask and the highlighted window
      val zIndexMask = jq(".z-modal-mask").css("z-index");
      val zIndexWindow = jq("$win").css("z-index");

      verifyTrue("The z-index of the window should be greater than or equal to the z-index of the mask", zIndexWindow >= zIndexMask);
    })
  }
}