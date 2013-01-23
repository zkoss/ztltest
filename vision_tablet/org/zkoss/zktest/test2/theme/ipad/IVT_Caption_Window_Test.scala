package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Caption_Window_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<window width="300px" height="300px" border="normal">
	<caption label="Title" image="/img/volumn.gif">
		Caption Content
		<button label="Button" />
	</caption>
	Window Content
</window>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
