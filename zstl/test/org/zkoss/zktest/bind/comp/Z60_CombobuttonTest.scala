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
import org.junit.Test

/**
 * @author Hawk
 */
@Tags(tags = "zbind")
class Z60_CombobuttonTest extends ZTL4ScalaTestCase {
  @Test
  def testContainer() = {
    val zul = {
    		<include src="bind/comp/combobutton.zul"/>
    }
    runZTL(zul, () => {
    
      //button
      val open = engine $f "open"
      verifyEquals("false", getText(open));
      click(jq(".z-combobutton").toWidget().$n("btn"))
      waitResponse()
      verifyEquals("true", getText(open));
    })
  }
}