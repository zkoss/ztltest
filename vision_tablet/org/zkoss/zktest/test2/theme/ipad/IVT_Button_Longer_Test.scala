package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Button_Longer_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	Trendy Mold:
	<button label="Long Long Button" mold="trendy" />
	<separator />
	OS Mold:
	<button label="Long Long Button" mold="os" />
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
