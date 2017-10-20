package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2435.zul")
class B70_ZK_2435Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
	<label multiline="true">
		1. click the magnifier button
		2. click a row of the drop down listbox
		3. press ENTER
		4. you should see the textbox is filled with the name you choose
		5. click the magnifier button
		6. click a row of the drop down listbox
		7. press ESC
		8. you should see an empty textbox
	</label>
	<separator />
	<bandbox id="bd">
	    <bandpopup>
		    <listbox id="lb" width="200px" onOK="bd.value=lb.selectedItem.label; bd.close();" 
		    	onCancel='bd.value="";lb.setSelectedItem(null); bd.close();'>
		        <listhead>
		            <listheader label="Name" />
		            <listheader label="Description" />
		        </listhead>
		        <listitem>
		            <listcell label="John" />
		            <listcell label="CEO" />
		        </listitem>
		        <listitem>
		            <listcell label="Joe" />
		            <listcell label="Engineer" />
		        </listitem>
		        <listitem>
		            <listcell label="Mary" />
		            <listcell label="Supervisor" />
		        </listitem>
		    </listbox>
	    </bandpopup>
	</bandbox>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      var btn = jq(".z-bandbox-button");
      var input = jq("input");
      click(btn);
      waitResponse();
      var john = jq(".z-listitem").first();
      if(!isSafari)
        click(john);
      else
        clickAt(john, "2,2");
      waitResponse();
      var listbox = jq("@listbox").toWidget();
      var a = listbox.$n("a"); //button can be focused and sendKey
      focus(a);
      sendKeys(a, Keys.ENTER);
      waitResponse();
      verifyTrue(input.eval("val()").equals("John"));
      waitResponse();
      click(btn);
      waitResponse();
      if(!isSafari)
        click(john);
      else
        clickAt(john, "2,2");
      waitResponse();
      focus(a);
      sendKeys(a, Keys.ESCAPE);
      waitResponse();
      verifyTrue(input.eval("val()").equals(""));
      
    })
    
  }
}