/* B50_ZK_831Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Feb 15 15:59:17 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-831
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-831.zul,A,E,Spinner")
class B50_ZK_831Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<window title="Spinner" border="normal">
				1. Please type the number to the input element - "12345678910"
				<separator/>
				2. You should see an error message like "Out of range..."
					<spinner id="spinner" />
					<button id="btn" label="show" onClick='alert("" + spinner.getValue())' />
				</window>
			</zk>

    }

   runZTL(zscript,
        () => {
        var spinner: Widget = engine.$f("spinner");
        var btn: Widget = engine.$f("btn");
        var input: Element = spinner.$n("real");
        focus(input);
        sendKeys(input, "12345678910");
        click(btn);
        waitResponse();
        verifyTrue("should have error box",
            jq(".z-errbox").exists());
    }
   );
  }
}