/* B30_2208873Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 1, 2011 05:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element
import org.zkoss.ztl.ZK
import org.zkoss.ztl.util.Scripts

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-2208873.zul,B,E,Window,Button")
class B30_2208873Test extends ZTL4ScalaTestCase {
  def testClick() = {
  	target = ch.getServer() + ch.getContextPath() + "/test2/B30-2208873.zul"
    val zscript = ""
    runZTL(zscript, () => {
      // Verifying each of the cells
      verifyTrue("Item one should be visible", jq(".z-listcell-cnt:contains(one)").exists());
      verifyTrue("Item two should be visible", jq(".z-listcell-cnt:contains(two)").exists());
      verifyTrue("Item three should be visible", jq(".z-listcell-cnt:contains(three)").exists());
      verifyTrue("Item foud should be visible", jq(".z-listcell-cnt:contains(four)").exists());
    })
  }
}