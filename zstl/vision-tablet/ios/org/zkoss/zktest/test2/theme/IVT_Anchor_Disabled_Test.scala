package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Anchor_Disabled_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<div>
	Disabled: <a href="http://www.zkoss.org" disabled="true" label="ZK" />
	/ <a href="http://www.zkoss.xyz" disabled="true" label="Unknown" />
</div>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
