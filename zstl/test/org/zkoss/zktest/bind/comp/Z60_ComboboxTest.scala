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
class Z60_ComboboxTest extends ZTL4ScalaTestCase {
  @Test
  def testContainer() = {
    val zul = """
    		<include src="bind/comp/combobox.zul"/>
"""
    runZTL(zul, () => {
    
      //button
      val open = engine.$f("open")
      verifyEquals("false", getText(open));
      click(jq(".z-combobox").toWidget().$n("btn"))
      waitResponse()
      verifyEquals("true", getText(open));
    })
  }
}