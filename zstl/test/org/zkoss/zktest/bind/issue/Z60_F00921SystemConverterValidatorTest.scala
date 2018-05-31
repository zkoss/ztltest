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
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00921SystemConverterValidatorTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/F00921SystemConverterValidator.zul"/>
"""

    runZTL(zul, () => {

      var l1 = jq("$l1")
      var l2 = jq("$l2")
      var l3 = jq("$l3")
      var l4 = jq("$l4")

      verifyEquals("XConverterX", l1.toWidget().get("value"))
      verifyEquals("YConverterY", l2.toWidget().get("value"))
      verifyEquals("XValidator", l3.toWidget().get("value"))
      verifyEquals("YValidator", l4.toWidget().get("value"))

    })
  }
}

