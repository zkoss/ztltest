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
class Z60_GridTest extends ZTL4ScalaTestCase {
  def testGridGroupOpen() = {
    val zul = """
	<include src="bind/comp/grid.zul"/>
"""
    runZTL(zul, () => {
    
      //button
      
      val detailOpen = engine.$f("detailOpen")
      val groupOpen = engine.$f("groupOpen")
      
      //test open
      verifyEquals("false", getText(detailOpen));
      click(widget(jq("@detail")).$n("icon"));
      waitResponse();
      verifyEquals("true", getText(detailOpen));
      
      verifyEquals("false", getText(groupOpen));
      click(widget(jq("@group")).$n("img"));
      waitResponse();
      verifyEquals("true", getText(groupOpen));
    })
  }
}