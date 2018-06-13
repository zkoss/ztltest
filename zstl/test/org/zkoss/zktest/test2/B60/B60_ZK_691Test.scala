/* B60_ZK_691Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Feb 17 15:18:14 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug ZK-691
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-691.zul,B,E,stubonly")
class B60_ZK_691Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<html><![CDATA[
				<ol>
				<li>Click the create button</li>
				<li>Click the test button</li>
				<li>Then, you shall two message: "Correct" and another message starting with "Stub: [StubEvent onStub".</li>
				</ol>
				]]></html>
				<button id="btnOne" label="create"
				 onClick='Executions.createComponents("/test2/B60-ZK-691-inc.zul", null, null)'/>
			</zk>

    """
    runZTL(zscript,
      () => {
        var btnOne: Widget = engine.$f("btnOne");

        click(btnOne);
        waitResponse();
        click(jq(".z-button:contains(test)").get(0));
        waitResponse();

        verifyTrue("shall see two message: 'Correct' and another message starting with 'Stub: [StubEvent onStub'.",
          jq(".z-window-embedded:contains(Correct)").exists()
            && jq(".z-window-embedded:contains(Stub:[StubEvent onStub)").exists());
      }
    );
  }
}