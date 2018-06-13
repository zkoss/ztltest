/* B50_3162238Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Oct 17 09:18:58 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug 3162238
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3162238.zul,A,E,Include")
class B50_3162238Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """

			<zk>
				<html><![CDATA[
					<ol>
						<li>Click on Show Null, the included content should disappear, 
						otherwise it is a bug.</li>
					</ol>
				]]></html>
				<include id="inc" src="/test2/B50-3162238-inc.zul" />
				<button id="btn" label="Show Null" onClick='inc.src = null' />
			</zk>

    """
    runZTL(zscript,
      () => {
        var btn: Widget = engine.$f("btn");

        verifyTrue("embedded window should exist before button clicked",
          jq(".z-window-embedded").exists());
        click(btn);
        waitResponse();
        verifyFalse("embedded window should not exist after button clicked",
          jq(".z-window-embedded").exists());
      }
    );

  }
}