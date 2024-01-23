/* F60_ZK_523Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 23 14:42:11 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-523
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-523.zul,F60,B,E,Columnlayout")
class F60_ZK_523Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
        verifyTrue("The listbox should displayed well",
          jq(".z-listbox:contains(ZK Spring)").exists());
      }
    )
  }
}