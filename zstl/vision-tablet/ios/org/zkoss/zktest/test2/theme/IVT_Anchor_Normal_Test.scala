package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Anchor_Normal_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<div>
	Normal: <a href="http://www.zkoss.org" label="ZK" />
	/ <a href="http://www.zkoss.xyz" label="Unknown" />
</div>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
