package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Anchor_Caption_Normal_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<window>
	<caption>
		<div>
			Normal: <a href="http://www.zkoss.org" label="ZK" />
			/ <a href="http://www.zkoss.xyz" label="Unknown" />
		</div>
	</caption>
</window>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
