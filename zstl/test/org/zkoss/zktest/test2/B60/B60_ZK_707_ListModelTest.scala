/* B60_ZK_707_ListModelTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Feb 17 11:52:18 CST 2012 , Created by benbai
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
 * A test class for bug ZK-707-ListModel
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-707-ListModel.zul,A,E,ListModel,Selectable,Listbox,ROD")
class B60_ZK_707_ListModelTest extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
			    <zscript><![CDATA[
			String[] data = new String[10];
			for (int i = 0; i < data.length; i++)
				data[i] = "option_" + i;
			
			
			ListModelList model = new ListModelList(data);
			    ]]></zscript>
			    1. Please test to select the listitem, the both listbox should be the same result. (test both checked/unchecked multiple)
			    <checkbox id="cbx" label="Multiple Selections">
			    	<attribute name="onCheck">
			    	model.setMultiple(event.checked);
			    	
			    	// reset model
			    	gridOne.setModel(null);
			    	gridTwo.setModel(null);
			    	gridOne.setModel(model);
			    	gridTwo.setModel(model);
			    	</attribute>
			    </checkbox>
			    <separator/>
			    2. Please click upon the head "Column" to sort it, the selection status and sorting
			    function also affect the both listbox.
			    <listbox id="gridOne" model="${model}" checkmark="true" onSelect="">
			    	<listhead><listheader label="column" sort="auto"/></listhead>
			    </listbox>
			    
			    <listbox id="gridTwo" model="${model}" checkmark="true" onSelect="">
			    	<listhead><listheader label="column" sort="auto"/></listhead>
			    </listbox>
			</zk>

    """

   runZTL(zscript,
        () => {
        var cbx: Widget = engine.$f("cbx");
        var gridOne: Widget = engine.$f("gridOne");
        var gridTwo: Widget = engine.$f("gridTwo");

        def selectItem(wgt: Widget,content: String) {
        	click(jq(gridOne.$n()).find(".z-listitem:contains("+content+")"));
	        waitResponse();
        }
        def verifySelected(content: String) {
            verifyTrue("Both first grid and second grid select the "+content,
            		jq(gridOne.$n()).find(".z-listitem-seld:contains("+content+")").exists()
            		&& jq(gridTwo.$n()).find(".z-listitem-seld:contains("+content+")").exists());
        }
        def sort (wgt: Widget) {
            click(jq(wgt.$n()).find(".z-listheader:contains(column)"));
            waitResponse();
        }
        def checkOrder(content: String, order: Int) {
        	verifyTrue("The item "+order+" of first/second grid should contains"+content,
        	    jq(gridOne.$n()).find(".z-listitem").get(order).get("innerHTML").contains(content)
        	    && jq(gridTwo.$n()).find(".z-listitem").get(order).get("innerHTML").contains(content));
        }
        selectItem(gridOne, "option_1");
        verifySelected("option_1");

        selectItem(gridTwo, "option_3");
        verifySelected("option_3");

        selectItem(gridOne, "option_2");
        verifySelected("option_2");

        click(cbx.$n("real"));
        waitResponse();
        selectItem(gridOne, "option_1");
        selectItem(gridTwo, "option_5");
        selectItem(gridOne, "option_4");
        verifySelected("option_1");
        verifySelected("option_2");
        verifySelected("option_4");
        verifySelected("option_5");

        sort(gridOne);
        sort(gridOne);
        checkOrder("option_9", 0);
        checkOrder("option_8", 1);
        checkOrder("option_7", 2);

        sort(gridTwo);
        checkOrder("option_0", 0);
        checkOrder("option_1", 1);
        checkOrder("option_2", 2);
     }
   );
  }
}