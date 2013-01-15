package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Button_Large_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	Trendy Mold:
	<button label="Button" width="100px" height="50px" mold="trendy" />
	<separator />
	OS Mold:
	<button label="Button" width="100px" height="50px" mold="os" />
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
