/* B60_ZK_898Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 30 15:50:44 CST 2012 , Created by benbai
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
 * A test class for bug ZK-898
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-898.zul,A,E,Listbox,Grid,Paging")
class B60_ZK_898Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<div>
					1. Press Clear button. You should see paging disappeared with Listbox content.
				</div>
				<zscript><![CDATA[
					String[] strs = new String[50];
					for (int i = 0; i < 50; i++)
						strs[i] = "Item " + i;
				]]></zscript>
				<button id="btn" label="Clear" onClick="lb.items.clear(); rs.children.clear()" />
				<hlayout>
					<listbox id="lb" mold="paging" width="300px">
						<listitem label="${each}" forEach="${strs}" />
					</listbox>
					<grid mold="paging" width="300px">
						<rows id="rs">
							<row forEach="${strs}">
								<label>${each}</label>
							</row>
						</rows>
					</grid>
				</hlayout>
			</zk>

    """

    runZTL(zscript,
        () => {
        var btn: Widget = engine.$f("btn");
        var containers: JQuery = null;
        var container: JQuery = null;

        click(btn);
        waitResponse();

        containers = jq(".z-hlayout-inner");
        for (i <- 0 until containers.length()) {
          container = jq(containers.get(i));
          verifyTrue("You should see paging disappeared with Listbox content",
            container.height() < 5);
        }
    }
   );
  }
}