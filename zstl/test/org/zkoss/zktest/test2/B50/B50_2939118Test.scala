/* B50_2939118Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Oct 14 15:43:14 CST 2011 , Created by benbai
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
  * A test class for bug 2939118
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-2939118.zul,A,E,Tree,Model")
class B50_2939118Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
        def btn: Widget = engine.$f("btn");
        click(btn);
        waitResponse();
        verifyFalse(jq(".z-error").exists());
      }
    );
  }
}