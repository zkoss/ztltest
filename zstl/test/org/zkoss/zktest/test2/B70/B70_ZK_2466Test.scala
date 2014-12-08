package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2466.zul")
class B70_ZK_2466Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk xmlns:w="client">
	<label multiline="true">
	  1. click the button
	  2. you should see three columns show up
	</label>
	<button id="btn" label="Click me" />
	<grid sizedByContent="true" span="true">
		<columns fulfill="btn.onClick">
			<column label="AAA"></column>
			<column label="BBB" hflex="1"></column>
			<column label="CCC"></column>
		</columns>
		<rows>
			<row>
				<label value="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" />
				<label value="bbbbbbbbbbbbbbbbb" />
				<label value="ccccccccccccc" />
			</row>
		</rows>
	</grid>
</zk>

"""  
  runZTL(zscript,
    () => {
      var btn = jq(".z-button");
      click(btn);
      waitResponse();
      val AAA = jq(".z-column-content").first().text();      
      verifyTrue("AAA".equals(AAA));
      
    })
    
  }
}