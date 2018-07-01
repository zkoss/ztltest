/* Z60_B01268UnsupportChildExpTest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 7, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01268UnsupportChildExpTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01268UnsupportChildExp.zul"/>
"""
    
    runZTL(zul, () => {
      var listbox = jq("@listbox")
      verifyTrue(listbox.exists())			// check if the page can show up.

    })
  }
}
