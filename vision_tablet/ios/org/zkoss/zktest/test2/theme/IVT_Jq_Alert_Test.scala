package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Jq_Alert_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<script>
jq.alert('Test Alert');
</script>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
