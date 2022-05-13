/* B50_ZK_577Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Dec 02 14:51:14 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit._

/**
  * A test class for bug ZK-577
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-577.zul,B,E,Datebox")
class B50_ZK_577Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      var dbx: Widget = engine.$f("dbx");
      var btn1: Widget = engine.$f("btn1");
      var btn2: Widget = engine.$f("btn2");

      var dbxLeft: Integer = jq(dbx.$n()).offsetLeft();
      var btn1Left: Integer = jq(btn1.$n()).offsetLeft();
      var btn2Left: Integer = jq(btn2.$n()).offsetLeft();
      var dbxTop: Integer = jq(dbx.$n()).offsetTop();
      var btn1Top: Integer = jq(btn1.$n()).offsetTop();
      var btn2Top: Integer = jq(btn2.$n()).offsetTop();
      var dbxWidth: Integer = jq(dbx.$n()).outerWidth();
      var btn1Width: Integer = jq(btn1.$n()).outerWidth();

      verifyTrue("The top of datebox and button 1 should almost the same",
        getEval("Math.abs(" + btn1Top + "-" + dbxTop + ") <= 10"))
      verifyTrue("The top of datebox and button 2 should almost the same",
        getEval("Math.abs(" + btn2Top + "-" + dbxTop + ") <= 10"))
      verifyTrue("The left of button 1 should larger then the right of datebox",
        btn1Left >= dbxLeft + dbxWidth);
      verifyTrue("The left of button 2 should larger then the right of button 1",
        btn2Left >= btn1Left + btn1Width);
    })
  }
}