/* B50_3330762Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 17:09:43 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{Element, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug 3330762
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3330762.zul,A,E,Doublespinner")
class B50_3330762Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

			<zk>
				<label id="outer" value="outer" />
    			<div></div>
    			<separator/>
					1. Input "1" in spinner and click button "test"
				<separator/>
					2. If an exception is thrown, it is a bug.
				<separator/>
					3. Click the up arrow, the doublespinner value should change to 1.1
				<separator/>
					4. Click button "test", if there is an exception, it is a bug.
				<separator/>
				<doublespinner id="ds" step="0.1" />
				<button id="btn" label="test" onClick='lb.value = "" + ds.value' />
				Doublespinner Value: <label id="lb" />
			</zk>

    """
    runZTL(zscript,
      () => {
        var outer: Widget = engine.$f("outer");
        var ds: Widget = engine.$f("ds");
        var btn: Widget = engine.$f("btn");
        var lb: Widget = engine.$f("lb");
        var dsInp: Element = ds.$n("real");

        click(dsInp);
        dsInp.eval("value=1");
        click(outer);
        waitResponse();
        clickThenCheck("1.0");

        click(ds.$n("btn-up"));
        waitResponse();
        clickThenCheck("1.1");

        def clickThenCheck(value: String) {
          click(btn);
          waitResponse();

          verifyEquals("the value of label should equal to the value of doublespinner",
            value, getText(lb))
          verifyFalse("should not have Exception",
            jq(".z-window-highlighted").exists());
          verifyFalse("should not have Exception",
            jq(".z-window-modal").exists())
        }
      }
    );

  }
}