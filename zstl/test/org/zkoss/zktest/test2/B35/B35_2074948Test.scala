/* B35_2074948Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 10, 2011 12:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2074948.zul,B,E,Window,Button")
class B35_2074948Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
      <window title="Menu Demo" border="normal">
        <label value="Vertical Menu Popup position shall be correct"/>
        <window>
          <menubar orient="vertical">
            <menu id="menu" label="12321434564212347897413135498794123154678454674899765131549789451374897942134897">
              <menupopup>
                <menuitem label="1"/>
              </menupopup>
            </menu>
            <menu label="1">
              <menupopup>
                <menuitem label="1"/>
              </menupopup>
            </menu>
            <menu label="href">
              <menupopup>
                <menu label="popup">
                  <menupopup>
                    <menuitem label="item" checkmark="true">
                    </menuitem>
                  </menupopup>
                </menu>
                <menuitem label="checked" autocheck="true" checked="true"/>
                <menuitem label="unchecked, disabled" autocheck="true" checked="false" disabled="true"/>
                <menuitem label="checked, disable" autocheck="true" checked="true" disabled="true"/>
              </menupopup>
            </menu>
          </menubar>
        </window>
      </window>
    """
    runZTL(zscript, () => {
      var item = engine.$f("menu")
      var popup = jq(".z-menupopup");

      // Click on first menu item
      click(item);
      waitResponse();

      // Record Menu Item position
      var xMenu: Int = jq(item).offsetLeft()
      var yMenu: Int = jq(item).offsetTop()

      // Record Menu Popup position
      var xPopup: Int = jq(popup).offsetLeft()
      var yPopup: Int = jq(popup).offsetTop()

      // The popup must be at the right of the menu item
      verifyTrue("The popup must be at right and below of the menu item", xPopup > xMenu)
      var result = getEval("Math.abs(" + yPopup + "-" + yMenu + ") <= 1")
      verifyTrue("The popup must be at right and below of the menu item",
        result)


    })
  }
}