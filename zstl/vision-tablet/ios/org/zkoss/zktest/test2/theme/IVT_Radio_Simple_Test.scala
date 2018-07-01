package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Radio_Simple_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<radiogroup>
	Unchecked: <radio/> 
	Checked: <radio checked="true"/>  
	<textbox  placeholder="test alignment"/>
</radiogroup>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
