package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Checkbox_Label_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<checkbox label="unchecked"/>
	<checkbox label="checked" checked="true"/>
	<textbox  placeholder="test alignment"/>
</zk>	
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
