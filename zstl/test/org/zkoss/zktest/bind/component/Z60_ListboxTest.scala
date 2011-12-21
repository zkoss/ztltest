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
class Z60_ListboxTest extends ZTL4ScalaTestCase {
  def testListbox() = {
    val zul = {
	<include src="bind/component/listbox.zul"/>
    }
    runZTL(zul, () => {
    
      val listbox = engine $f "listbox"
      
      val itemLabel = engine $f "itemLabel"
      val indexLabel = engine $f "indexLabel"
      
      click(jq("@listitem").eq(1));
      waitResponse()
      ZKSeleneseTestCase.assertEquals("item02", getText(itemLabel));
      ZKSeleneseTestCase.assertEquals("1", getText(indexLabel));
      click(jq("@listitem").eq(2));
      waitResponse()
      ZKSeleneseTestCase.assertEquals("item03", getText(itemLabel));
      ZKSeleneseTestCase.assertEquals("2", getText(indexLabel));
      
      val nameLabel = engine $f "nameLabel"
      ZKSeleneseTestCase.assertEquals(false, jq(nameLabel).isVisible());
      click(jq("@button"))
      waitResponse()
      ZKSeleneseTestCase.assertEquals(true, jq(nameLabel).isVisible());
      
    })
  }
}