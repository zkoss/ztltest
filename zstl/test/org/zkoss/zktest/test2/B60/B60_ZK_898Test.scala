/* B60_ZK_898Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 30 15:50:44 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.JQuery
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-898
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-898.zul,A,E,Listbox,Grid,Paging")
class B60_ZK_898Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
      var containers: JQuery = null;
      var container: JQuery = null;
      click(jq("@button"));
      waitResponse();
      containers = jq(".z-hlayout-inner");
      for (i <- 0 until 2) {
        container = jq(containers.get(i));
        verifyFalse("You should see paging disappeared with Listbox content",
          isVisible(jq(".z-paging").eq(i)));
      }
    }
    );
  }
}