/* B60_ZK_765Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Feb 17 09:49:05 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.{ClientWidget, Widget}

/**
  * A test class for bug ZK-765
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-765.zul,A,E,Listbox,ROD")
class B60_ZK_765Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(
      () => {
        var listbox: Widget = engine.$f("listbox");
        var msg: Widget = engine.$f("msg");
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");
        var btnThree: Widget = engine.$f("btnThree");

        def clickAndWait(wgt: ClientWidget) {
          click(wgt);
          waitResponse();
        }

        clickAndWait(btnTwo);
        verifyTrue("message should be 'selected index is undefined, no selection or ... index is -1 ...'",
          jq("$msg:contains(selected index is undefined, no selection)").exists()
            || jq("$msg:contains(selected index is -1)").exists());
        clickAndWait(jq(".z-listitem:contains(Item 1)"));
        clickAndWait(btnTwo);
        verifyTrue("message should be 'selected index is 1, widget selected is true'",
          jq("$msg:contains(selected index is 1, widget selected is true)").exists());
        clickAndWait(btnOne);
        clickAndWait(btnTwo);
        verifyTrue("message should be 'selected index is 1, widget selected is true'",
          jq("$msg:contains(selected index is 1, widget selected is true)").exists());

        waitResponse();
        refresh();
        waitResponse();

        clickAndWait(btnThree);
        verifyTrue("message should be 'selected no selection'",
          jq("$msg:contains(selected no selection)").exists());
        clickAndWait(jq(".z-listitem:contains(Item 1)"));
        clickAndWait(btnThree);
        verifyTrue("message should be 'selected index is 1'",
          jq("$msg:contains(selected index is 1)").exists());
        clickAndWait(btnOne);
        clickAndWait(btnThree);
        verifyTrue("message should be 'selected index is 1'",
          jq("$msg:contains(selected index is 1)").exists());
      }

    );
  }
}