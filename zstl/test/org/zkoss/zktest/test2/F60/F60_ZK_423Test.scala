/* F60_ZK_423Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 28 13:08:06 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.openqa.selenium.Keys
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-423
 * @author benbai
 *
 */
@Tags(tags = "F60-ZK-423.zul,F60,A,E,Listbox,Tree")
class F60_ZK_423Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<div>
					1. Click on the first textbox so the textbox will gain focus.
				</div>
				<div>
					2. Press TAB key once, and press DOWN key. You should see Listitem 0 selected.
				</div>
				<div>
					3. Press TAB key once again, and press DOWN key. You should see Treeitem A selected.
				</div>
				<separator />
				<textbox id="tbxOne" />
				<listbox id="lbx" onSelect='tbxTwo.setValue(""+self.getSelectedItem().equals(self.getItems().get(0)))'>
					<listitem label="${each}" forEach="0,1,2,3,4,5" />
				</listbox>
				<tree id="tree" onSelect='tbxOne.setValue(""+self.getSelectedItem().equals(ti));'>
					<treechildren>
						<treeitem label="A" id="ti">
							<treechildren>
								<treeitem label="B" />
								<treeitem label="C" />
							</treechildren>
						</treeitem>
						<treeitem label="D" />
						<treeitem label="E" />
					</treechildren>
				</tree>
				<textbox id="tbxTwo" />
			</zk>

    }

    runZTL(zscript,
        () => {
        var tbxOne: Widget = engine.$f("tbxOne");
        var lbx: Widget = engine.$f("lbx");
        var tree: Widget = engine.$f("tree");
        var tbxTwo: Widget = engine.$f("tbxTwo");

        click(tbxOne);
        waitResponse();

        sendKeys(tbxOne, Keys.TAB);
        waitResponse();
        sendKeys(lbx.$n("a"), Keys.ARROW_DOWN);
        waitResponse();

        verifyTrue("First listitem should be selected",
            tbxTwo.$n().get("value").contains("true"));

        sendKeys(lbx.$n("a"), Keys.TAB);
        waitResponse();
        sendKeys(tree.$n("a"), Keys.ARROW_DOWN);
        waitResponse();

        verifyTrue("First listitem should be selected",
            tbxOne.$n().get("value").contains("true"));
    }
   );
  }
}