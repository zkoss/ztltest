package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Borderlayout_Simple_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<borderlayout>
	<center>
		Center Content
	</center>
	<north size="20%">
		North Content
	</north>
	<south size="20%">
		South Content
	</south>
	<east size="20%">
		East Content
	</east>
	<west size="20%">
		West Content
	</west>
</borderlayout>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
