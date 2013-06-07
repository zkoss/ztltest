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
class Z60_ComboboxTest extends ZTL4ScalaTestCase {
  def testContainer() = {
    val zul = {
    		<include src="bind/comp/combobox.zul"/>
    }
    runZTL(zul, () => {
    
      //button
      val open = engine $f "open"
      ZKSeleneseTestCase.assertEquals("false", getText(open));
      click(jq(".z-combobox-icon"))
      waitResponse()
      ZKSeleneseTestCase.assertEquals("true", getText(open));
    })
  }
}