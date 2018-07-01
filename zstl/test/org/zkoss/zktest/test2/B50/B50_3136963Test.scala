/* B50_3136963Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Oct 17 10:03:58 CST 2011 , Created by benbai
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
  * A test class for bug 3136963
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3136963.zul,A,E,Include,Composer")
class B50_3136963Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """

			<zk>
				Please press the click button and the invalidate button, and each time it should only appear one message below.
				<include id="include" />
				<button id="btn1" label="click" onClick='include.src="/test2/B50-3136963_2.zul"' autodisable="+self"/>
				<button id="btn2" label="invalidate" onClick='include.invalidate()'/>
			</zk>
			

    """
    runZTL(zscript,
      () => {
        var btn1: Widget = engine.$f("btn1");
        var btn2: Widget = engine.$f("btn2");
        var len: Int = jq(".z-label").length();

        click(btn1);
        waitResponse();
        var len2: Int = jq(".z-label").length();
        verifyTrue("each time it should only appear one message below.",
          (len2 - len) == 1);

        for (i <- 0 until 3) {
          len = len2;
          click(btn2);
          waitResponse();

          len2 = jq(".z-label").length();
          verifyTrue("each time it should only appear one message below.",
            (len2 - len) == 1);
        }

      }
    );

  }
}