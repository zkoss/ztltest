package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Groupbox_No_Caption_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<groupbox width="300px" height="300px">
	Groupbox Content	
</groupbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
