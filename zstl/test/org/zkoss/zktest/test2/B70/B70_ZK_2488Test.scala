package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2488.zul")
class B70_ZK_2488Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
	<label multiline="true">
		1. you should see the circle icon display at label's left
	</label>
	<groupbox closable="true" title="Groupbox">
		<caption iconSclass="z-icon-circle">
			<label value="Test-Label" />
		</caption>
		caption in groupbox
	</groupbox>
	<separator />
	<tabbox>
		<tabs>
			<tab>
				<caption iconSclass="z-icon-circle">
					<label value="Test-Label" />
				</caption>
			</tab>
		</tabs>
		<tabpanels>
			<tabpanel>caption in tabbox/tab</tabpanel>
		</tabpanels>
	</tabbox>
	<separator />
	<panel closable="true" minimizable="true"  title="Panel">
		<caption iconSclass="z-icon-circle">
			<label value="Test-Label" />
		</caption>
		<panelchildren>caption in panel</panelchildren>
	</panel>
	<separator />
	<window closable="true" minimizable="true"  title="Window">
		<caption iconSclass="z-icon-circle">
			<label value="Test-Label" />
		</caption>
		caption in window
	</window>
</zk>

"""  
  runZTL(zscript,
    () => {
      var c = jq(".z-caption-content").iterator();
      var l = jq(".z-caption-content>.z-label").iterator();
      while(c.hasNext() && l.hasNext()) {
        var caption = c.next();
        var label = l.next();
        verifyTrue(caption.positionLeft() < label.positionLeft());
      }
      
    })
    
  }
}