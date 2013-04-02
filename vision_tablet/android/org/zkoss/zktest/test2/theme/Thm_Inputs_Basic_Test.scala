package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Inputs_Basic_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<hbox>
	<vbox>
		<window title="Basic Inputs" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<vbox>
				Intbox:
				<div><intbox value="123" /> (Normal)</div>
				<div><intbox value="123" disabled="true" /> (Disabled)</div>
				<div><intbox value="123" readonly="true" /> (Read Only)</div>
				<div><intbox value="123" inplace="true" /> (Inplace)</div>
			</vbox>
			<separator />
			Note: This includes Decimalbox, Doublebox, Intbox, Longbox and Textbox. They all use the same style.
		</window>
		<window title="Textbox" border="normal" sclass="center-bg-win"
			width="300px" height="300px">
			<vbox>
				Textbox:
				<div><textbox value="abc" /> (Normal)</div>
				<div><textbox multiline="true" rows="4" value="abc" /> (Multiline)</div>
			</vbox>
			<separator />
		</window>
	</vbox>
	<window width="150px" height="300px" />
	<vbox>
		<separator spacing="150px" />
		<window title="Error Box" border="normal" sclass="center-bg-win"
			width="300px" height="300px">
			<vbox>
				For showing error box:
				<div><textbox constraint="/^`````````$/" /> (Normal)</div>
				<div><textbox inplace="true" constraint="/^`````````$/" /> (Inplace)</div>
			</vbox>
			<separator />
			Note: please click on the textbox and then click somewhere else.
		</window>
	</vbox>
</hbox>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Show errorbox
				singleTap(jq("@textbox:eq(2)"));
				sleep(500);
				singleTap(jq("@textbox:eq(3)"));
				sleep(500);
				verifyImage();
				
				// Close errorbox
				closeErrorBox();
				sleep(500);
				verifyImage();
			});
	}
}