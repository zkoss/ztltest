package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2519.zul")
class B70_ZK_2519Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
	<style>
		.z-label.tagStyle {
		color: white;
		background-color: green;
		border-radius: 4px;
		padding: 3px;
		line-height: normal;
		}
	</style>
	<label multiline="true">
		1. click "change default caption label", the element "tag Label" should not be removed
		2. after 1, click "hide another label", there should not be any js errors
	</label>
	<panel id="mPanel" border="normal" width="100%"
		vflex="1" sizable="false" sclass="tn-window">
		<caption id="mPanelCaption" sclass='tn-panel-div' label="Caption label">
			<label id="tagLabel" sclass='tagStyle' style='' value="tag Label"
				visible="true" />
			<button id="mCloseButton" sclass="tn-btn-close" label="close"
				autodisable="self" tooltiptext="close" />
		</caption>
		<panelchildren>
			<vlayout>
				<button label="1. change default caption label"
					onClick='mPanelCaption.setLabel("updated Caption Label");' />
				1. ERROR tagLabel is removed from the DOM
				<button label="2. hide another label" onClick="tagLabel.setVisible(false);" />
				2. aftereffect, trying to hide the label causes a JS error because
				the DOM and widget tree are out of sync
				(the tagLabel still exists on
				the server side, but is removed from the DOM)
			</vlayout>
		</panelchildren>
	</panel>
</zk>

"""  
  runZTL(zscript,
    () => {
      var changeBtn = jq(".z-button:contains(change)");
      click(changeBtn);
      waitResponse();
      verifyTrue(jq(".z-label:contains(tag Label)").last().length() > 0);
      waitResponse();
      var hideBtn = jq(".z-button:contains(hide)");
      click(hideBtn);
      waitResponse();
      verifyTrue(jq(".z-error").length() < 1);
      
    })
    
  }
}