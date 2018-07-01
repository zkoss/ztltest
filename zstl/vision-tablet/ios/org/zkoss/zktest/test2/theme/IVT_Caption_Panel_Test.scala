package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Caption_Panel_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<panel width="300px" height="300px" border="normal">
	<caption label="Title" image="/img/volumn.gif">
		Caption Content
		<button label="Button" />
	</caption>
	<panelchildren>
		Panel Content
	</panelchildren>
</panel>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
