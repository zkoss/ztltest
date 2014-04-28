package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Caption_Groupbox_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<groupbox width="300px" height="300px">
	<caption label="Title" image="/img/volumn.gif">
		Caption Content
		<button label="Button" />
	</caption>
	Groupbox Content
</groupbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
