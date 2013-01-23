package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Groupbox_Caption_Label_Image_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<groupbox width="300px" height="300px">
	<caption image="/img/volumn.gif" label="Caption" />
	Groupbox Content
</groupbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
