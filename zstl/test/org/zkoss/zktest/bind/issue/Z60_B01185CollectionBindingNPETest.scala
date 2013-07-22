/* Z60_B01185CollectionBindingNPETest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 6, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Assert
import org.junit.Test

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01185CollectionBindingNPETest extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul = {
      <include src="/bind/issue/B01185CollectionBindingNPE.zul"/>
    }
    runZTL(zul, () => {
      
		click(jq("$addPersonBtn").toWidget())
		waitResponse()
		click(jq("$delPerson_0").toWidget())
		waitResponse()
		click(jq("$addUrlBtn").toWidget())
		waitResponse()
		click(jq("$delUrl_0").toWidget())
		waitResponse()
		var widget = jq("$delUrl_0")
		verifyFalse(widget.exists())
	
    })
  }
}
