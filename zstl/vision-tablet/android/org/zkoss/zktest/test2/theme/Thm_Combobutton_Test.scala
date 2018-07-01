package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Combobutton_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<hlayout>
	<window title="Combobutton" border="normal" width="300px" height="300px">
		<combobutton label="Combobutton" image="/img/volumn.gif">
			<popup>
				Popup Content
			</popup>
		</combobutton>
		<separator />
		<combobutton label="Combobutton" image="/img/volumn.gif">
			<menupopup>
				<menuitem label="Index" />
				<menu label="About">
					<menupopup>
						<menuitem label="About ZK" />
						<menuitem label="About Potix" />
					</menupopup>
				</menu>
			</menupopup>
		</combobutton>
	</window>
	<window title="Combobutton mold=toolbar" border="normal" width="300px" height="300px">
		<toolbar>
			<combobutton label="Combobutton" image="/img/volumn.gif" mold="toolbar">
				<menupopup>
					<menuitem label="Index" />
					<menu label="About">
						<menupopup>
							<menuitem label="About ZK" />
							<menuitem label="About Potix" />
						</menupopup>
					</menu>
				</menupopup>
			</combobutton>
		</toolbar>
	</window>
</hlayout>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Show the popup of the 1st combobutton
				singleTapAt(jq("@combobutton:eq(0)"), 140, 10);
				sleep(500);
				verifyImage();

				// Close the 1st combobutton
				singleTapAt(jq("@combobutton:eq(0)"), 140, 10);
				sleep(500);

				// Show the menu of the 2nd combobutton
				singleTapAt(jq("@combobutton:eq(1)"), 140, 10);
				sleep(500);
				verifyImage();
				
				singleTapAt(jq("@combobutton:eq(1)"), 140, 10);
				sleep(500);
				
				singleTapAt(jq("@combobutton:eq(2)"), 135, 20);
				sleep(500);
				verifyImage();
			});
	}
}