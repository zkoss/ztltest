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
import org.zkoss.ztl._
/**
 * @author Hawk
 */
@Tags(tags = "zbind")
class Z60_MenuitemTest extends ZTL4ScalaTestCase {
  def testComponent() = {
    val zul = """
    		<include src="bind/comp/menuitem.zul"/>
"""
    runZTL(zul, () => {
    
      //button
      val checked = engine.$f("checked")
      verifyEquals("false", getText(checked));
      click(jq("@menu"))
      waitResponse()
      click(jq("@menuitem"))
      waitResponse()
      verifyEquals("true", getText(checked));
    })
  }
}