package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Checkbox_Simple_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	Unchecked: <checkbox/> 
	Checked: <checkbox checked="true"/>
	<textbox placeholder="test alignment"/>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
