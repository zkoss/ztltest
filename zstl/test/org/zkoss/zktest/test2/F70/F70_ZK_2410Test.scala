package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "F70-ZK-2410.zul")
class F70_ZK_2410Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """
    
<zk>
    <label multiline="true">
    Customers usage steps are :

	1. click to paging input box
	2. press tab
	3. press enter to switch to next page
	</label>
	    
    <listbox id="box" mold="paging" pageSize="2">
        <listhead sizable="true">
            <listheader label="name" sort="auto" />
            <listheader label="gender" sort="auto" />
        </listhead>
        <listitem>
            <listcell label="Mary" />
            <listcell label="FEMALE" />
        </listitem>
        <listitem>
            <listcell label="John" />
            <listcell label="MALE" />
        </listitem>
        <listitem>
            <listcell label="Jane" />
            <listcell label="FEMALE" />
        </listitem>
        <listitem>
            <listcell label="Henry" />
            <listcell label="MALE" />
        </listitem>
    </listbox>
</zk>
  
"""  
  runZTL(zscript,
    () => {
      var input = jq(".z-paging-input");
      click(input);
      waitResponse();
      sendKeys(input, Keys.TAB);
      waitResponse();
      sendKeys(jq(".z-paging-next"), Keys.ENTER); //a little strange...we shouldn't focus button manually....
      waitResponse();
      verifyTrue(jq(".z-paging-input").eval("val()").equals("2"));
    })
    
  }
}