package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.openqa.selenium.interactions.touch.TouchActions

@Tags(tags = "Android,VisionTest")
class Thm_Button_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<hbox>
		<window title="Button" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<vbox>
				Trendy Mold:
				<div>
					<button label="Button" mold="trendy" />
					<button image="/img/volumn.gif" mold="trendy" />
					<button label="Button" image="/img/volumn.gif" mold="trendy" />
				</div>
				<separator />
				OS Mold:
				<div>
					<button label="Button" mold="os" />
					<button image="/img/volumn.gif" mold="os" />
					<button label="Button" image="/img/volumn.gif" mold="os" />
				</div>
			</vbox>
			<separator />
			Note: keeps the original design for OS mold
		</window>
		<window title="Button with longer label" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<vbox>
				Trendy Mold:
				<button label="Long Long Button" mold="trendy" />
				<separator />
				OS Mold:
				<button label="Long Long Button" mold="os" />
			</vbox>
			<separator />
		</window>
		<window title="Large Button" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<vbox>
				Trendy Mold:
				<button label="Button" width="100px" height="50px" mold="trendy" />
				<separator />
				OS Mold:
				<button label="Button" width="100px" height="50px" mold="os" />
			</vbox>
			<separator />
		</window>
	</hbox>
	<separator />
	<hbox>
		<window title="Button with Hover Image" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<vbox>
				Trendy Mold:
				<button label="Button" image="/img/volumn.gif" 
					hoverImage="/img/network.gif" mold="trendy" />
				<separator />
				OS Mold:
				<button label="Button" image="/img/volumn.gif" 
					hoverImage="/img/network.gif" mold="os" />
			</vbox>
			<separator />
		</window>
	</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// No hover effect in touch devices
			});
	}
}