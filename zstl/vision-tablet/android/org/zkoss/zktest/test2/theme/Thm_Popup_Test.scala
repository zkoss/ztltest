package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Popup_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<style>
		.labelbox {
			border: 1px solid #CCCCCC;
			padding: 10px;
			margin: 5px;
		}
	</style>
	<hbox>
		<window title="Popup" border="normal" width="300px" height="300px">
			<vbox>
				<button label="Show Popup" popup="p1" />
				<button label="Show Popup with fixed size" popup="p2" />
			</vbox>
		</window>
		<window title="Tooltip, Context" border="normal" width="300px" height="300px">
			<vbox>
				<div sclass="labelbox" tooltip="p1">
					<label value="Tooltip (mouse over)" />
				</div>
				<div sclass="labelbox" context="p1">
					<label value="Context (right click)" />
				</div>
			</vbox>
		</window>
		<window title="Tooltiptext" border="normal" width="300px" height="300px">
			<vbox>
				<div sclass="labelbox" tooltiptext="Tooltip Message">
					<label value="Tooltiptext (mouse over)" />
				</div>
			</vbox>
			Note: Tooltiptext is not a Popup.
		</window>
	</hbox>
	Note: for Errorbox, please visit Input (Basic, Errbox).
	<popup id="p1">
		<div>Popup Content</div>
		<div>Second Line</div>
	</popup>
	<popup id="p2" width="200px" height="200px">
		<div>Popup Content</div>
		<div>Second Line</div>
	</popup>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();

				// Show Popup
				singleTap(jq("@button:eq(0)"));
				waitResponse();
				verifyImage();
				singleTap(jq("@window:eq(0)"));
				
				// Show fix-sized Popup
				singleTap(jq("@button:eq(1)"));
				waitResponse();
				verifyImage();
			});
	}
}