package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

@Tags(tags = "Android,VisionTest")
class Thm_Window_Test extends ZTL4ScalaTestCase {
	@Test
	def testClick() = {
		val zscript = """
<zk>
	<div height="700px">
		<hbox>
			<window title="Window: Embedded" border="normal" 
				closable="true" sizable="true" maximizable="true" minimizable="true"
				width="300px" height="200px" top="50px" left="50px">
				Window Content
			</window>
			<window title="Window: Overlapped" border="normal" mode="overlapped"
				closable="true" sizable="true" maximizable="true" minimizable="true"
				width="300px" height="200px" top="80px" left="550px" >
				Window Content
			</window>
			<window id="popup1" title="Window: Popup" border="normal" mode="popup"
				closable="true" sizable="true" maximizable="true" minimizable="true"
				width="300px" height="200px" top="80px" left="870px" >
				Window Content
			</window>
			<window id="modal1" title="Window: Modal" border="normal" visible="false"
				closable="true" sizable="true" maximizable="true" minimizable="true"
				width="300px" height="200px">
				<vbox>
					<div>Window Content</div>
					<div>
						<button id="close1" label="Close" onClick="modal1.visible = false;"/>
					</div>
				</vbox>
			</window>
		</hbox>
		<separator spacing="20px"/>
		<hbox>
			<window border="normal" closable="true" 
				width="300px" height="200px" top="50px" left="50px">
				Window Content
			</window>
			<window border="normal" mode="overlapped" closable="true" 
				width="300px" height="200px" top="300px" left="550px" >
				Window Content
			</window>
			<window id="popup2" border="normal" mode="popup" closable="true" 
				width="300px" height="200px" top="300px" left="870px" >
				Window Content
			</window>
			<window id="modal2" border="normal" visible="false"
				closable="true" sizable="true" maximizable="true" minimizable="true"
				width="300px" height="200px">
				<vbox>
					<div>Window Content</div>
					<div>
						<button id="close2" label="Close" onClick="modal2.visible = false;"/>
					</div>
				</vbox>
			</window>
		</hbox>
		<separator spacing="20px"/>
		<vbox>
			<button id="btn1" label="Show Popup" onClick="popup1.doPopup(); popup2.doPopup();"/>
			<button id="btn2" label="Show Modal 1" onClick="modal1.doModal();" />
			<button id="btn3" label="Show Modal 2" onClick="modal2.doModal();" />
		</vbox>
	</div>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Click on "Show Popup" button
				click(jq("$btn1"));
				waitResponse();
				verifyImage();
				
				// Click on "Show Modal 1" button
				click(jq("$btn2"));
				waitResponse();
				verifyImage();
				
				// Close "modal1" window
				click(jq("$close1"));
				waitResponse();
				verifyImage();
				
				// Click on "Show Modal 2" button
				click(jq("$btn3"));
				waitResponse();
				verifyImage();
				
				// Close "modal2" window
				click(jq("$close2"));
				waitResponse();
				verifyImage();
			});
	}
}