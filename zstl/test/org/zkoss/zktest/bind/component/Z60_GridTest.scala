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
class Z60_GridTest extends ZTL4ScalaTestCase {
  def testGridGroupOpen() = {
    val zul = {
	<include src="bind/component/grid.zul"/>
    }
    runZTL(zul, () => {
    
      //button
      val open = engine $f "open"
      
      val brandLabel = engine $f "brandLabel"
      val pcNameLabel = engine $f "pcNameLabel"
      
      //test open
      ZKSeleneseTestCase.assertEquals(false, jq(brandLabel).isVisible());
      ZKSeleneseTestCase.assertEquals(false, jq(pcNameLabel).isVisible());
      click(open);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(true, jq(brandLabel).isVisible());
      ZKSeleneseTestCase.assertEquals(true, jq(pcNameLabel).isVisible());
      
    })
  }
}