/* B60_ZK_983Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Apr 23 11:01:32 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

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
 * A test class for bug ZK-983
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-983.zul,B,E,Combobutton")
class B60_ZK_983Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<div>Click the 'detach' button, you should not see any error.</div>
				<combobutton id="cb" label="Combobutton" />
				<button id="btn" label="detach" onClick='cb.detach()' />
			</zk>

    """
runZTL(zscript,
        () => {
        var cb: Widget = engine.$f("cb");
        var btn: Widget = engine.$f("btn");

        click(btn); waitResponse();
        verifyFalse("Should no js error",
            jq(".z-error").exists() || jq("#zk_err").exists());
        verifyFalse("Combobutton should be detached.",
            jq(cb).exists());
    }
   );
  }
}