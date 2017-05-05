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
package org.zkoss.zktest.bind.comp

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author Hawk
 */
@Tags(tags = "zbind")
class Z60_PanelTest extends ZTL4ScalaTestCase {
  def testContainer() = {
    val zul = """
    		<include src="bind/comp/panel.zul"/>
"""
    runZTL(zul, () => {
    
      //button
      val open = engine $f "open"
      val maximized = engine $f "maximized"
      
      //test open
//      System.out.println(jq("#open").exists()); false
      click(jq(".z-panel").toWidget().$n("exp"))
      waitResponse()
      ZKSeleneseTestCase.assertEquals("true", getText(open));
      
      click(jq(".z-panel").toWidget().$n("max"))
      waitResponse()
      ZKSeleneseTestCase.assertEquals("true", getText(maximized));
      
      val panel1Zindex = engine $f "panel1Zindex"
      val panel2Zindex = engine $f "panel2Zindex"
      var zindex1= getText(panel1Zindex).toInt
      var zindex2= getText(panel2Zindex).toInt
      verifyTrue(zindex2>zindex1);
      click(jq(".z-panel:eq(1)").toWidget().$n("exp"))
      waitResponse();
      zindex1= getText(panel1Zindex).toInt
      zindex2= getText(panel2Zindex).toInt
      verifyTrue(zindex2<zindex1);
      
    })
  }
}