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
class Z60_GridTest extends ZTL4ScalaTestCase {
  def testGridGroupOpen() = {
    val zul = {
	<include src="bind/component/grid.zul"/>
    }
    runZTL(zul, () => {
    
      //button
      
      val detailOpen = engine $f "detailOpen"
      val groupOpen = engine $f "groupOpen"
      
      //test open
      ZKSeleneseTestCase.assertEquals("false", getText(detailOpen));
      click(jq(".z-detail-img"));
      waitResponse();
      ZKSeleneseTestCase.assertEquals("true", getText(detailOpen));
      
      ZKSeleneseTestCase.assertEquals("false", getText(groupOpen));
      click(jq(".z-group-img"));
      waitResponse();
      ZKSeleneseTestCase.assertEquals("true", getText(groupOpen));
    })
  }
}