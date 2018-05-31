/* B60_ZK_725Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Feb 17 10:49:30 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, Widget}
import org.zkoss.ztl.util.Scripts

/**
  * A test class for bug ZK-725
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-725.zul,A,E,sort")
class B60_ZK_725Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(
      () => {
        var grid: Widget = engine.$f("grid");
        Scripts.triggerMouseEventAt(getWebDriver, jq("@column:eq(0)"), "click", "2,2")
        waitResponse(true)
        verifyTrue("should sorted correctly",
          jq("@row").get(0).get("id").equals(jq(".z-row").get(0).get("id")));
        verifyTrue("should sorted correctly",
          jq("@row").get(1).get("id").equals(jq(".z-row").get(1).get("id")));
        verifyTrue("should sorted correctly",
          jq("@row").get(2).get("id").equals(jq(".z-row").get(2).get("id")));
      }
    );
  }
}