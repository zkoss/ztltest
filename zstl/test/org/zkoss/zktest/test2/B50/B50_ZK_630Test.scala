/* B50_ZK_630Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Dec 02 16:56:35 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug ZK-630
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-630.zul,A,E,Doublespinner")
class B50_ZK_630Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
				<div>You should see no Java Exception</div>
				<doublespinner id="db" value="1" constraint="no negative" />
				<zscript>
					db.getValue();
				</zscript>
			</zk>

    """
    runZTL(zscript, () => {
      var db: Widget = engine.$f("db");

      verifyTrue("page should rendered well",
        db.exists());
      verifyFalse("should no exception",
        jq(".z-window-modal").exists());
    })
  }
}