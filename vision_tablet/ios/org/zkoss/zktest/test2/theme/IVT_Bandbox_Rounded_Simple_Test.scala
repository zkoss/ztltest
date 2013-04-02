package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Bandbox_Rounded_Simple_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<bandbox open="true" mold="rounded">
	<bandpopup>
		Bandbox Content
	</bandpopup>
</bandbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
