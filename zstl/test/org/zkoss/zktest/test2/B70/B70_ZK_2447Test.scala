package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2447.zul")
class B70_ZK_2447Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
	<zscript><![CDATA[
        String[] data = new String[3];
        for(int j=0; j < data.length; ++j) {
            data[j] = "item "+j;
        }
        ListModel strset = new ListModelList(data);
    ]]></zscript>
    <vlayout>
    	<label multiline="true">
    		1. Select 'item 2' and 'item 3'
    		2. Click button 'Show Selected Count' , and you'll see message '2'
			3. Click button 'Remove All'
			4. Click button 'Show Selected Count' , and you'll see message '0'
		</label>
	    <listbox id="list" model="${strset}" multiple="true" checkmark="true">
			<listhead>
	            <listheader label="Items"/>
	        </listhead>
		</listbox>
		<button label="Remove All" onClick="strset.removeRange(0,3)"></button>
		<button label="Show Selected Count" onClick='Clients.showNotification(""+list.getSelectedCount())'></button>
    </vlayout>
	
</zk>

"""  
  runZTL(zscript,
    () => {
      
      var first = jq("@listitem").first();
      var last = jq("@listitem").last();
      var showBtn = jq(".z-button:contains(Show)");
      var removeBtn = jq(".z-button:contains(Remove)");
      waitResponse(true);
      click(first);
      waitResponse();
      click(last);
      waitResponse();
      click(showBtn);
      waitResponse();
      verifyTrue(jq(".z-notification-content").text().equals("2"));
      waitResponse();
      click(removeBtn);
      waitResponse();
      click(showBtn);
      waitResponse();
      verifyTrue(jq(".z-notification-content").text().equals("0"));
      
    })
    
  }
}