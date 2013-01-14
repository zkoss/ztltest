package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Borderlayout_Title_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<borderlayout>
	<center title="Center">
		Center Content
	</center>
	<north size="20%" title="North">
		North Content
	</north>
	<south size="20%" title="South">
		South Content
	</south>
	<east size="20%" title="East">
		East Content
	</east>
	<west size="20%" title="West">
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
