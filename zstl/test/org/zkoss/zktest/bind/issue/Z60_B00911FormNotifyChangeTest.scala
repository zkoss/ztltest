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
class Z60_B00911FormNotifyChangeTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00911FormNotifyChange.zul"/>
    }

    runZTL(zul, () => {

      var l1 = jq("$l1");
      var l2 = jq("$l2");
      var l3 = jq("$l3");
      var l4 = jq("$l4");
      var l5 = jq("$l5");
      var l6 = jq("$l6");
      var btn = jq("$btn");

      verifyEquals("Dennis", l1.toWidget().get("value"));
      verifyEquals("Dennis", l2.toWidget().get("value"));
      verifyEquals("Dennis", l3.toWidget().get("value"));
      verifyEquals("A", l4.toWidget().get("value"));
      verifyEquals("A", l5.toWidget().get("value"));
      verifyEquals("A", l6.toWidget().get("value"));

      click(btn.toWidget());
      waitResponse();
      verifyEquals("Alex", l1.toWidget().get("value"));
      verifyEquals("Alex", l2.toWidget().get("value"));
      verifyEquals("Alex", l3.toWidget().get("value"));
      verifyEquals("A", l4.toWidget().get("value"));
      verifyEquals("A", l5.toWidget().get("value"));
      verifyEquals("A", l6.toWidget().get("value"));

    })
  }
}