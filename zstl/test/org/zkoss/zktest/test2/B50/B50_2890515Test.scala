/* B50_2890515Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 16:26:16 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 2890515
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-2890515.zul,A,E,Datebox,Calendar,Constraint,Before")
class B50_2890515Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
      var outer: Widget = engine.$f("outer")
      var dtbx: Widget = engine.$f("dtbx")

      click(dtbx.$n("real"))
      dtbx.$n("real").eval("value='20091102'")
      blur(dtbx.$n("real"))
      waitResponse()

      verifyFalse("should not show error with date before (and include) 2009/11/02",
        jq(".z-errorbox").exists())

      click(dtbx.$n("real"))
      dtbx.$n("real").eval("value='20091103'")
      blur(dtbx.$n("real"))
      waitResponse()

      verifyTrue("should show error with date after 2009/11/02",
        jq(".z-errorbox").exists())
    }
    );

  }
}
