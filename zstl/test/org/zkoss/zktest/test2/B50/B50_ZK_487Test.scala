/* B50_ZK_487Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 28 18:37:33 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, Widget};

/**
  * A test class for bug ZK-487
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-487.zul,A,E,Groupbox,Caption")
class B50_ZK_487Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      var gb1: Widget = engine.$f("gb1");
      var gb2: Widget = engine.$f("gb2");
      click(jq(gb1).find(".z-caption"));
      waitResponse(true);
      click(jq(gb2).find(".z-caption"));
      waitResponse(true);
      verifyEquals("Height should be 200", jq(gb1).outerHeight(), 200)
      verifyEquals("Height should be 200", jq(gb2).outerHeight(), 200);
    }
    );
  }
}