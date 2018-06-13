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

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author Hawk
 */
@Tags(tags = "zbind")
class Z60_SelectboxTest extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    val zul = """
	<include src="bind/comp/selectbox.zul"/>
"""
    runZTL(zul, () => {
    
      val selectbox = engine.$f("sbox")
      val selectedLabel = engine.$f("selected")
      
      click(jq("option").eq(1));
      waitResponse()
      verifyEquals("1", getText(selectedLabel));
      click(jq("option").eq(2));
      waitResponse()
      verifyEquals("2", getText(selectedLabel));
 
    })
  }
}