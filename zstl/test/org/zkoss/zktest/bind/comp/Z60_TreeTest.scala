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
class Z60_TreeTest extends ZTL4ScalaTestCase {
  @Test
  def testAttribute() = {
    val zul = """
	<include src="bind/comp/tree.zul"/>
"""
    runZTL(zul, () => {
    
      val tree = engine $f "tree"
      
      val selectedLabel = engine $f "selectedLabel"
      
      click(jq("@treerow").eq(1));
      waitResponse()
      ZKSeleneseTestCase.assertEquals("Root.1", getText(selectedLabel));
      
      val open = engine $f "open"
      click(jq(".z-treerow:contains(0)").toWidget().$n("open"))
      waitResponse()
      ZKSeleneseTestCase.assertEquals("true", getText(open));
      
      click(jq("@treechildren").eq(1));
      waitResponse()
      ZKSeleneseTestCase.assertEquals("Root.0.0", getText(selectedLabel));

      click(jq(".z-treerow:contains(1):eq(1)").toWidget().$n("open"))
      waitResponse()
      ZKSeleneseTestCase.assertEquals("false", getText(open));
    })
  }
}