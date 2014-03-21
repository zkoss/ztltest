/* Z60_B01791GlobalCommandTest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 29, 2013 Created by Kuro Chung

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author kuro
 */
@Tags(tags = "zbind")
class Z60_B01791GlobalCommandTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B01791GlobalCommand.zul"/>
    }

    runZTL(zul, () => {
      
		var lab1 = jq("$lb1");
		var btn = jq("$btn1");
		
		click(btn.toWidget());
		waitResponse()
		
		verifyEquals("global: onClick, global", lab1.toWidget().get("value"));  

    })
  }
}
