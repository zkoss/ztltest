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
package org.zkoss.zktest.bind.collection

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_C1 extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/collection/c1.zul"/>
"""
    
    runZTL(zul, () => {

      val singleBox = engine.$f("singleBox")
      val contentListbox = engine.$f("contentListbox")

      `type`(singleBox.$n("real"), "Car Mark");
      sendKeys(singleBox.$n("real"), Keys.TAB);
      waitResponse();
      verifyEquals("TOYOTA", contentListbox.firstChild().get("label"));

      `type`(singleBox.$n("real"), "Fruit");
      sendKeys(singleBox.$n("real"), Keys.TAB);
      waitResponse();
      verifyEquals("Apple", contentListbox.firstChild().get("label"));

    })
  }
}