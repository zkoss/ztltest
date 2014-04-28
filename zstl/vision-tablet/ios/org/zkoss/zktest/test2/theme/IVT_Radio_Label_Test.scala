package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Radio_Label_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<radiogroup>
	<radio label="Unchecked"/>
	<radio label="Checked" checked="true"/>
	<textbox placeholder="test alignment"/>
</radiogroup>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
