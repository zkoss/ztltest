/* B50_ZK_569Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Nov 30 16:09:20 CST 2011 , Created by benbai
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
 * A test class for bug ZK-569
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-569.zul,B,E,Listbox,Select")
class B50_ZK_569Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
			<hbox>
			<div width="20px">1.</div><label value="Select item 'test 7'" />
			</hbox>
			<separator/>
			<hbox>
			<div width="20px">2.</div><label value="Click button 'show selection', you should see a message box contains" />
			</hbox>
			<separator/>
			<hbox>
			<div width="20px"></div><label value="Selected index: 10, label of selected item: test 7" />
			</hbox>
			<separator/>
			<hbox>
			<div width="20px">3.</div><label value="Click 'OK' to close the message box then Click button 'set 333 selected'" />
			</hbox>
			<separator/>
			<hbox>
			<div width="20px">4.</div><label value="Click button 'show selection', you should see a message box contains" />
			</hbox>
			<separator/>
			<hbox>
			<div width="20px"></div><label value="Selected index: 4, label of selected item: test 333" />
			</hbox>
			<separator/>
				<div>
					<listbox id="lb" mold="select">
						<listitem label="test 1" visible="false"/>
						<listitem label="test 2" visible="false"/>
						<listitem label="test 3"/>
						<listitem label="test 33"/>
						<listitem id="fff" label="test 333"/>
						<listitem label="test 3333"/>
						<listitem label="test 4" visible="false"/>
						<listitem label="test 5"/>
						<listitem label="test 555"/>
						<listitem label="test 6" visible="false"/>
						<listitem id="item7" label="test 7"/>
						<listitem label="test 7555"/>
						<listitem label="test 8" visible="false"/>
					</listbox>
					<button id="btn1" label="show selection">
						<attribute name="onClick">
							alert("Selected index: " + lb.getSelectedIndex() + ", label of selected item: " + lb.getSelectedItem().getLabel());
						</attribute>
					</button>
					<button id="btn2" label="set 333 selected">
						<attribute name="onClick">
							lb.setSelectedItem(fff);
						</attribute>
					</button>
				</div>
			</zk>

    }

   runZTL(zscript, () => {
			var lb: Widget = engine.$f("lb");
			var item7: Widget = engine.$f("item7");
    		var btn1: Widget = engine.$f("btn1");
    		var btn2: Widget = engine.$f("btn2");

    		def clickAndWait = (target: org.zkoss.ztl.ClientWidget) => {
    			click(target);
    			waitResponse();
    		}
    		select(lb, "test 7");
    		clickAndWait(btn1);

    		verifyEquals(jq(".z-messagebox").find(".z-label").get(0).get("innerHTML"),
    		    "Selected index: 10, label of selected item: test 7");
    		clickAndWait(jq(".z-messagebox-button"));
    		clickAndWait(btn2);    		
    		clickAndWait(btn1);

    		verifyEquals(jq(".z-messagebox").find(".z-label").get(0).get("innerHTML"),
    		    "Selected index: 4, label of selected item: test 333");
		})
  }
}