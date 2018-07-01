package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Textbox_Multiline_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<hbox align="center">
	Textbox: <textbox multiline="true" rows="4" value="abc" /> (Multiline)
</hbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
