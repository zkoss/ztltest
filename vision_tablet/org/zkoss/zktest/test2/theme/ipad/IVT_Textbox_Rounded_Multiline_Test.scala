package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Textbox_Rounded_Multiline_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<hbox align="center">
	Textbox: <textbox mold="rounded" multiline="true" rows="4" value="abc" /> (Multiline)
</hbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
