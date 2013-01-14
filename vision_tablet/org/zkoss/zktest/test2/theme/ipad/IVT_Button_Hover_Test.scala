package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Button_Hover_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	Trendy Mold:
	<button label="Button" image="/common/img/volumn.gif" 
		hoverImage="/common/img/network.gif" mold="trendy" />
	<separator />
	OS Mold:
	<button label="Button" image="/common/img/volumn.gif" 
		hoverImage="/common/img/network.gif" mold="os" />
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
