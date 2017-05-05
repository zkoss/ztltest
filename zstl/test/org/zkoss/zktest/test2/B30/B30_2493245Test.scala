/* B30_2493245Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 16, 2012 11:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element
import org.zkoss.ztl.ZK
import org.zkoss.ztl.util.Scripts

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-2493245.zul,B,E,Window,Button")
class B30_2493245Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = """
      <window id="main">
        You shall see a modal window on top of this
        <zscript><![CDATA[
zoom = new HtmlMacroComponent();
zoom.setDynamicProperty("idColumn", 123);
zoom.setMacroURI("/test2/B30-2493245_macro.zul");
zoom.setParent(main);
zoom.afterCompose();
	]]></zscript>
      </window>
    """
runZTL(zscript, () => {

      // Record modal mask z-index
      var winZindex = jq(".z-modal-mask").css("z-index");

      // Record popup z-index
      var popupZindex = jq(".z-window-modal").css("z-index");

      verifyTrue("The z-index of the main window should be more or equal than the z-index of the mask", popupZindex >= winZindex);
    })
  }
}