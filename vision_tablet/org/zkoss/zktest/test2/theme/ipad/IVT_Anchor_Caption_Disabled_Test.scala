package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Anchor_Caption_Disabled_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<window>
	<caption>
		<div>
			Disabled: <a href="http://www.zkoss.org" disabled="true" label="ZK" />
			/ <a href="http://www.zkoss.xyz" disabled="true" label="Unknown" />
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
