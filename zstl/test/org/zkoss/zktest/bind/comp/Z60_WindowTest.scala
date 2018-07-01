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
import org.zkoss.ztl.annotation.Tags

/**
 * @author Hawk
 */
@Tags(tags = "zbind")
class Z60_WindowTest extends ZTL4ScalaTestCase {
  def testContainer() = {
    val zul = """
    		<include src="bind/comp/window.zul"/>
"""
    runZTL(zul, () => {
    
      val maximized = engine.$f("maximized")
      click(jq("@window:eq(0)").toWidget().$n("max"))
      waitResponse()
      verifyEquals("true", getText(maximized));
      
      val window1Zindex = engine.$f("window1Zindex")
      val window2Zindex = engine.$f("window2Zindex")
      var zindex1= getText(window1Zindex).toInt
      var zindex2= getText(window2Zindex).toInt
      val window1 = engine.$f("window1")
      println(window1.exists())
      verifyTrue(zindex2<zindex1);
      //click to make it top
      click(jq("@window:eq(1)").toWidget().$n("max"))
      click(jq("@window:eq(1)").toWidget().$n("max"))
      waitResponse()
      zindex1= getText(window1Zindex).toInt
      zindex2= getText(window2Zindex).toInt
      verifyTrue(zindex2>zindex1);
    })
  }
}