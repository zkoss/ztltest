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
class Z60_ListboxTest extends ZTL4ScalaTestCase {
  def testListbox() = {
    val zul = """
	<include src="bind/comp/listbox.zul"/>
"""
    runZTL(zul, () => {
    
      val listbox = engine.$f("listbox")
      
      val itemLabel = engine.$f("itemLabel")
      val indexLabel = engine.$f("indexLabel")
      
      click(jq("@listitem").eq(1));
      waitResponse()
      verifyEquals("item02", getText(itemLabel));
      verifyEquals("1", getText(indexLabel));
      click(jq("@listitem").eq(2));
      waitResponse()
      verifyEquals("item03", getText(itemLabel));
      verifyEquals("2", getText(indexLabel));
      
      val open = engine.$f("open")
      verifyEquals("false", getText(open));
      click(jq("@listgroup").toWidget().$n("img"))
      waitResponse()
      verifyEquals("true", getText(open));
      
    })
  }
}