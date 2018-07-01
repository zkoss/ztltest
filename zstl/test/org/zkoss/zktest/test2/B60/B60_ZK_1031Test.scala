/* B60_ZK_1031Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Apr 23 12:01:41 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug ZK-1031
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-1031.zul,B,E,ListModel")
class B60_ZK_1031Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
			    <zscript>
			        <![CDATA[
			        String[] userName = { "data 1", null, "data 2"};
			        ListModelList model = new ListModelList(userName);
			    ]]></zscript>
			    <div>Select second item of the selectbox, you should NOT see any Exception.</div>
			    <div>Click 'show selected index' button, all indexes are '1'</div>
			    <div id="outer">outer</div>
			    The selectbox: <selectbox id="sbx" model="${model}" onSelect="">
			        <template name="model">
			            Name is ${each}
			        </template>
			    </selectbox>
			    <listbox id="lbx" model="${model}" checkmark="true">
			        <template name="model">
						<listitem>
							<listcell label="Name is ${each}"/>
						</listitem>
			        </template>
			    </listbox>
			    <chosenbox id="csx" model="${model}" onSelect="">
			        <template name="model">${each}</template>
			    </chosenbox>
			    <radiogroup id="rg" model="${model}">
			        <template name="model">
			            <radio label="Name is ${each}" value="${each}" />
			        </template>
			    </radiogroup>
			    <combobox id="cbx" model="${model}">
			        <template name="model">
			            <comboitem label="Name is ${each}" />
			        </template>
			    </combobox>
			    <div>
			    	selected index of selectbox: <label id="lb1" />
			    </div>
			    
			    <div>
			    	selected index of listbox: <label id="lb2" />
			    </div>
			    
			    <div>
			    	selected index of chosenbox: <label id="lb3" />
			    </div>
			    
			    <div>
			    	selected index of radiogroup: <label id="lb4" />
			    </div>
			    
			    <div>
			    	selected index of combobox: <label id="lb5" />
			    </div>
			    
			    <div>
			    	<button id="btn" label="show selected index">
				    	<attribute name="onClick">
				    		lb1.setValue(sbx.getSelectedIndex() + "");
				    		lb2.setValue(lbx.getSelectedIndex() + "");
				    		lb3.setValue(csx.getSelectedIndex() + "");
				    		lb4.setValue(rg.getSelectedIndex() + "");
				    		lb5.setValue(cbx.getSelectedIndex() + "");
				    	</attribute>
				    </button>
			    </div>
			    
			</zk>

    """

    runZTL(zscript,
      () => {
        var outer: Widget = engine.$f("outer");
        var sbx: Widget = engine.$f("sbx");
        var btn: Widget = engine.$f("btn");

        def select(num: Int) {
          this.select(sbx, num);
          click(outer);
          waitResponse();
        }

        select(1);
        verifyFalse("No exception",
          jq(".z-window-modal").exists());
        click(btn);
        waitResponse();
        for (i <- 1 to 5) {
          verifyContains("Select index in label " + i + " should be 1",
            engine.$f("lb" + i).$n().get("innerHTML"), "1")
        }
      }
    );
  }
}