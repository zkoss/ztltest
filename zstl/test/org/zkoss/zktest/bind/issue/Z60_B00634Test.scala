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
class Z60_B00634Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = {
      <include src="/bind/issue/B00634.zul" />
    }

    runZTL(zul, () => {
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("B", jq("$l12").toWidget().get("value"));
      `type`(jq("$t11"), "PP");
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("B", jq("$l12").toWidget().get("value"));
      verifyEquals("value 1 has to be XX or ZZ", jq("$msg1").toWidget().get("value"));
      verifyEquals("value 2 has to be YY or ZZ", jq("$msg2").toWidget().get("value"));
      `type`(jq("$t11"), "XX");
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("B", jq("$l12").toWidget().get("value"));
      verifyEquals("", jq("$msg1").toWidget().get("value"));
      verifyEquals("value 2 has to be YY or ZZ", jq("$msg2").toWidget().get("value"));
      `type`(jq("$t11"), "YY");
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("B", jq("$l12").toWidget().get("value"));
      verifyEquals("value 1 has to be XX or ZZ", jq("$msg1").toWidget().get("value"));
      verifyEquals("", jq("$msg2").toWidget().get("value"));
      `type`(jq("$t11"), "ZZ");
      waitResponse();
      verifyEquals("ZZ", jq("$l11").toWidget().get("value"));
      verifyEquals("ZZ", jq("$l12").toWidget().get("value"));
      verifyEquals("", jq("$msg1").toWidget().get("value"));
      verifyEquals("", jq("$msg2").toWidget().get("value"));

    })
  }
}