/* Z60_B00994InitParamTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 20, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00994InitParamTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00994InitParam.zul"/>
"""

    runZTL(zul, () => {

      var l1 = jq("$l1");
      var l2 = jq("$l2");

      verifyEquals("foo", l1.toWidget().attr("value"));
      verifyEquals("bar", l2.toWidget().attr("value"));

    })
  }
}