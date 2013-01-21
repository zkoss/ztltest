package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Loading_Render_Defer_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<div width="100px" height="100px" style="border: 1px solid #888888">
	Renderer Defer: <span renderdefer="500000">Done</span>
</div>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
