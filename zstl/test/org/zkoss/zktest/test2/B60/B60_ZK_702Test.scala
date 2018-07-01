/* B60_ZK_702Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Feb 17 15:04:11 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug ZK-702
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-702.zul,B,E,Combobutton")
class B60_ZK_702Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
				<div>Click on button of combobutton, you should see a message box.</div>
				<combobutton id="cb" label="popup" onClick='alert(self.label)'>
				</combobutton>
			</zk>

    """
    runZTL(zscript,
      () => {
        var cb: Widget = engine.$f("cb");
        click(cb);
        waitResponse();
        verifyTrue("Should show a message box",
          jq(".z-window-highlighted:contains(popup)").exists());
      }
    );
  }
}