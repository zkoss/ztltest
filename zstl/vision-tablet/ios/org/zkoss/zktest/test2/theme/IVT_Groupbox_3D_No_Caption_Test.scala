package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Groupbox_3D_No_Caption_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<groupbox width="300px" height="300px" mold="3d">
	Groupbox Content	
</groupbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
