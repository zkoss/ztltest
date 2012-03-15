/* B50_ZK_786Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 14 11:30:03 CST 2012 , Created by benbai
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
 * A test class for bug ZK-786
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-786.zul,B,E,Caption")
class B50_ZK_786Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<div>1. Below is a window has a 'caption', and there is a 'toolbarbutton' in caption has a coffee image in it.</div>
				<div>2. Click the Show/Hide caption image button, you should see a image before the 'Testing' title displayed, disappeared.</div>
				<div>3. If the coffee image changed, it is a bug.</div>
				<window id="testWindow" title="Testing" border="normal">
					<caption id="cap" image="">
						<toolbarbutton id="tbbtn" image="/test2/img/coffee.gif" />
					</caption>
					<button id="showCapImg" label="Show caption image" onClick='cap.setImage("img/defender.gif");' />
					<button id="hideCapImg" label="Hide caption image" onClick='cap.setImage("");' />
				</window>
			</zk>

    }

    def executor() = {
    	
    }
   runZTL(zscript,
        () => {
        var tbbtn: Widget = engine.$f("tbbtn");
        var showCapImg: Widget = engine.$f("showCapImg");
        var hideCapImg: Widget = engine.$f("hideCapImg");
        var tbimg: Element = jq(tbbtn).find("img").get(0);

        def clickAndVerify (wgt: Widget) {
          click(wgt);
          waitResponse();
          verifyTrue("Src of toolbarbutton image should not changed.",
              tbimg.get("src").contains("img/coffee.gif"));
        }
        clickAndVerify(showCapImg);
        clickAndVerify(hideCapImg);
    }
   );
  }
}