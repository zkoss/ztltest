package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Borderlayout_Noborder_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<borderlayout>
	<center border="none">
		Center Content
	</center>
	<north size="20%" border="none">
		North Content
	</north>
	<south size="20%" border="none">
		South Content
	</south>
	<east size="20%" border="none">
		East Content
	</east>
	<west size="20%" border="none">
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
