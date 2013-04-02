package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Error_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<script defer="true"><![CDATA[
		zk.error('Sample error message.');
		zk.error('Second error message.');
	]]></script>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
