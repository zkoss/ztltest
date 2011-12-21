/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.component

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author Hawk
 */
@Tags(tags = "zbind")
class Z60_ContainerTest extends ZTL4ScalaTestCase {
  def testContainer() = {
    val zul = {
    		<include src="bind/component/container.zul"/>
    }
    runZTL(zul, () => {
    
      //button
      val toggle = engine $f "toggle"
      val max = engine $f "max"
      val min = engine $f "min"
      val lower = engine $f "lower"
      
      
      
      val gbLabel = engine $f "gbLabel"
      val panelLabel = engine $f "panelLabel"
      
      //test open
      ZKSeleneseTestCase.assertEquals(false, jq(gbLabel).isVisible());
      ZKSeleneseTestCase.assertEquals(false, jq(panelLabel).isVisible());
      click(toggle);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(true, jq(gbLabel).isVisible());
      ZKSeleneseTestCase.assertEquals(true, jq(panelLabel).isVisible());
      
      //container
      val panel = engine $f "panel"
      val window = engine $f "window"
      val panelWidth = jq(panel).width()
      val windowWidth = jq(window).width()
      click(max)
      waitResponse();
      val panelMaxWidth = jq(panel).width()
      val windowMaxWidth = jq(window).width()
      verifyTrue(panelMaxWidth>panelWidth);
      verifyTrue(windowMaxWidth>windowWidth)
      
      val bottomPanelLabel = engine $f "bottomPanelLabel"
      val topPanelLabel = engine $f "topPanelLabel"
      ZKSeleneseTestCase.assertEquals(false, jq(bottomPanelLabel).isVisible());
      ZKSeleneseTestCase.assertEquals(true, jq(topPanelLabel).isVisible());
      click(lower)
      ZKSeleneseTestCase.assertEquals(true, jq(bottomPanelLabel).isVisible());
      ZKSeleneseTestCase.assertEquals(false, jq(topPanelLabel).isVisible());
    })
  }
}