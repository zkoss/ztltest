package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Cns_Input_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	Mold: Default
	<include src="/test2/consis/_cns_input_template.zul" />
	<separator bar="true" height="50px" />
	Mold: Rounded
	<include src="/test2/consis/_cns_input_template.zul" imold="rounded" />
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}