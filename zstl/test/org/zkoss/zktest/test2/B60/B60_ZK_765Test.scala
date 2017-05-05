/* B60_ZK_765Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Feb 17 09:49:05 CST 2012 , Created by benbai
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
 * A test class for bug ZK-765
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-765.zul,A,E,Listbox,ROD")
class B60_ZK_765Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<window xmlns:w="http://www.zkoss.org/2005/zk/client">
				<label multiline="true">
				1.click show index, the message shows "selected index is undefined, no selection" (currently if selected index is -1 is better, however 'undefined/null' is acceptable.
				2.select item 1 then click show index, the message should show "selected index is 1, widget selected is true"
				3.click reset
				4.click show index, the message shows "selected index is 1, widget selected is true" (currently wrong at here)
				</label>
				
				<label multiline="true">
				1.click show selected, the message shows "selected no selection"
				2.select item 1 then click show selected, the message should show "selected index is 1"
				3.click reset
				4.click show selected, the message should show "selected index is 1"
				</label>
			
				<zscript><![CDATA[
				org.zkoss.zul.ListModelList model = new org.zkoss.zul.ListModelList();
				
				for(int i=0;i<100;i++){
					model.add("Item "+i);
				}
				]]></zscript>
			    <vbox>
				<listbox id="listbox" width="300px" model="${model}" rows="5" />
				
				<label id="msg" />
				<button id="btnOne" label="reset" onClick="listbox.setModel(model)"/>
				</vbox>
				<button id="btnTwo" label="show index" w:onClick="showindex()"/>
				<button id="btnThree" label="show selected" w:onClick="showselected()"/>
				<script type="text/javascript"><![CDATA[
				showindex = function(){
					var msg = zk.Widget.$('$msg');
					var listbox = zk.Widget.$('$listbox');
					var index = listbox.getSelectedIndex();
					var selected = index>=0?listbox.firstChild:null;
					for(var i=1;i<=index;i++){
						selected = selected.nextSibling;
					}
					if(selected){
						msg.setValue("selected index is "+index +", widget selected is "+selected.isSelected());
					}else{
						msg.setValue("selected index is "+index +", no selection");
					}
				}
				showselected = function(){
					var msg = zk.Widget.$('$msg');
					var listbox = zk.Widget.$('$listbox');
					var index = 0;
					var selected = listbox.firstChild;
					while(selected && !selected.isSelected()){
						selected = selected.nextSibling;
						index++;
					}
					if(selected){
						msg.setValue("selected index is "+index);
					}else{
						msg.setValue("selected no selection");
					}
				}
				]]></script>
			</window>

    """
runZTL(zscript,
        () => {
        var listbox: Widget = engine.$f("listbox");
        var msg: Widget = engine.$f("msg");
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");
        var btnThree: Widget = engine.$f("btnThree");

        def clickAndWait(wgt: org.zkoss.ztl.ClientWidget) {
            click(wgt);
            waitResponse();
        }
        clickAndWait(btnTwo);
        verifyTrue("message should be 'selected index is undefined, no selection or ... index is -1 ...'",
            	jq("$msg:contains(selected index is undefined, no selection)").exists()
            	|| jq("$msg:contains(selected index is -1)").exists());
        clickAndWait(jq(".z-listitem:contains(Item 1)"));
        clickAndWait(btnTwo);
        verifyTrue("message should be 'selected index is 1, widget selected is true'",
            	jq("$msg:contains(selected index is 1, widget selected is true)").exists());
        clickAndWait(btnOne);
        clickAndWait(btnTwo);
        verifyTrue("message should be 'selected index is 1, widget selected is true'",
            	jq("$msg:contains(selected index is 1, widget selected is true)").exists());

        refresh();
        waitForPageToLoad("10000");
        waitResponse();
        runRawZscript(zscript.toString());
        waitResponse();

        clickAndWait(btnThree);
        verifyTrue("message should be 'selected no selection'",
            	jq("$msg:contains(selected no selection)").exists());
        clickAndWait(jq(".z-listitem:contains(Item 1)"));
        clickAndWait(btnThree);
        verifyTrue("message should be 'selected index is 1'",
            	jq("$msg:contains(selected index is 1)").exists());
        clickAndWait(btnOne);
        clickAndWait(btnThree);
        verifyTrue("message should be 'selected index is 1'",
            	jq("$msg:contains(selected index is 1)").exists());
    }
        
   );
  }
}