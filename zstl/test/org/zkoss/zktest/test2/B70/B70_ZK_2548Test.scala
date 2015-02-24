package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2548.zul")
class B70_ZK_2548Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
	<label multiline="true">
	1. Set focus on the first combobox's text input box
	2. Press "down arrow" key to change its selection
	3. Press "tab" to set focus on the second combobox, model should be set
	</label>
    <zscript><![CDATA[
    ListModelList items = new ListModelList();
    items.add("d1");
    items.add("d2");
    items.add("d3");
    
    ListModelList otherItems = null;
    
    ListModelList sub1 = new ListModelList();
    sub1.add("d1s1");
    sub1.add("d1s2");
    sub1.add("d1s3");
    
    ListModelList sub2 = new ListModelList();
    sub2.add("d2s1");
    sub2.add("d2s2");
    sub2.add("d2s3");

    ListModelList sub3 = new ListModelList();
    sub3.add("d3s1");
    sub3.add("d3s2");
    sub3.add("d3s3");

    void doSelect(String value) {
        System.out.println("doSelect: " + value);
        if ("d1".equals(value))
            secondCombo.setModel(sub1);
        else if ("d2".equals(value))
            secondCombo.setModel(sub2);
        else
            secondCombo.setModel(sub3);
    }
    ]]></zscript>
    <combobox id="firstCombo"
        model="${items}"
        onSelect="doSelect(self.value)"
        constraint="no empty"/>
    <combobox id="secondCombo"
        constraint="no empty"/>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      var input = jq(".z-combobox-input").eq(0);
      var input2 = jq(".z-combobox-input").eq(1);
      focus(input);
      waitResponse();
      sendKeys(input, Keys.DOWN);
      waitResponse();
      verifyTrue(input.eval("val()").equals("d1"));
      sendKeys(input, Keys.TAB);
      waitResponse();
      focus(input2);
      waitResponse();
      sendKeys(input2, Keys.DOWN);
      verifyTrue(input2.eval("val()").equals("d1s1"));
      
    })
    
  }
}