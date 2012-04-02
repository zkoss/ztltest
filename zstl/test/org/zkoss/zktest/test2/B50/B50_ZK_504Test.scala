/* B50_ZK_504Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 28 18:32:27 CST 2012 , Created by benbai
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
 * A test class for bug ZK-504
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-504.zul,")
class B50_ZK_504Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
			<html><![CDATA[
			<ul><li>You shall see "onCreated received" inside the following window.</li></ul>
			]]></html>
			
			<zscript><![CDATA[
			public class Tooltip extends org.zkoss.zk.ui.util.GenericForwardComposer {
				Label tip;
				public void onCreate$tip(Event event) {
					tip.setValue("onCreated received");
				}
			}
			]]></zscript>
			
			<window border="normal" apply="Tooltip">
				<label id="tip"/>
			</window>
			
			</zk>

    }

    runZTL(zscript,
        () => {
        verifyTrue("event fired",
            jq(".z-label:contains(onCreated received)").exists());
    }
   );
  }
}