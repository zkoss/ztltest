/* F60_ZK_503Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 23 15:11:59 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

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
 * A test class for bug ZK-503
 * @author benbai
 *
 */
@Tags(tags = "F60-ZK-503.zul,F60,B,E,Idspace")
class F60_ZK_503Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
			<div>Click the test button, you shoould see two window without any problem.</div>
				<button id="btn" label="test">
					<attribute name="onClick">
						Idspace is = new Idspace();
						Window win = new Window();
						win.setId("win");
						win.setTitle("test window");
						win.setBorder("normal");
						win.setParent(is);
			
						Idspace isTwo = new Idspace();
						Window winTwo = new Window();
						winTwo.setId("win");
						winTwo.setTitle("test window");
						winTwo.setBorder("normal");
						winTwo.setParent(isTwo);
						isTwo.setParent(is);
						is.setParent(div);
					</attribute>
				</button>
				<div id="div"></div>
			</zk>

    }

    runZTL(zscript,
        () => {
        var btn: Widget = engine.$f("btn");
        click(btn);
        waitResponse();
        verifyFalse("Should no Exception",
            jq(".z-window-modal").exists());
    }
   );
  }
}