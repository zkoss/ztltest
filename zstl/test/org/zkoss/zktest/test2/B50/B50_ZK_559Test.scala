/* B50_ZK_559Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Dec 02 16:12:14 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug ZK-559
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-559.zul,A,E,Hbox,Vbox,flex")
class B50_ZK_559Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
      var listbox: Widget = engine.$f("listbox");
      var tabbox: Widget = engine.$f("tabbox");
      verifyTrue("the gap between listbox and tabbox should not too large",
        getEval("Math.abs(" + jq(tabbox.$n()).offsetTop() + "-" + jq(listbox.$n()).height() + "-" + jq(listbox.$n()).offsetTop() + ") < 15"))
    })
  }

}