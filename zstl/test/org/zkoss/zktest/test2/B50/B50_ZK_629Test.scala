/* B50_ZK_629Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Dec 06 10:31:06 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{Element,Widget}
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-629
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-629.zul,A,E,Doublebox,Decimalbox,Doublespinner,Locale")
class B50_ZK_629Test extends ZTL4ScalaTestCase {
  @Test
  def testNumberLocale() = {
    runZTL(() => {
      waitResponse();
      var db1: Widget = engine.$f("db1")
      var db2: Widget = engine.$f("db2")
      var db3: Widget = engine.$f("db3")
      var db4: Widget = engine.$f("db4")
      var db5: Widget = engine.$f("db5")

      def checkValue(ele: Element) {
        verifyContains("You should see the values in each input element \"0,5\" or \"0,00...5\", not \"5\".",
          ele.attr("value"), "0,");
      }

      checkValue(db1.$n());
      checkValue(db2.$n("real"));
      checkValue(db3.$n());
      checkValue(db4.$n());
      checkValue(db5.$n());

      sleep(1000)
      click(jq("@button"))
      waitResponse();
    });
  }
}