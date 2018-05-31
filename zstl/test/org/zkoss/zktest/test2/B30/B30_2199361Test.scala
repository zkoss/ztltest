/* B30_2199361Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 11, 2012 11:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-2199361.zul,B,E,Window,Button")
class B30_2199361Test extends ZTL4ScalaTestCase {
  def testClick() = {
    target = ch.getServer() + ch.getContextPath() + "/test2/B30-2199361.zul"
    val zscript = ""
    runZTL(zscript, () => {
      // Verify the existence of the "Hello, Initiator" label. Should be a count of 2 because of the explanation label
      verifyTrue("The label \"Hello, Initiator\" should be visible above the separator", jq(".z-label:contains(Hello, Initiator)").length() == 2);
    })
  }
}