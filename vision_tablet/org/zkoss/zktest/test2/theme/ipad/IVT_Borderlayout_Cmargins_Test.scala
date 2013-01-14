package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Borderlayout_Cmargins_Test extends ZTL4ScalaTestCase {
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
	<east title="East" size="20%" collapsible="true" cmargins="10,10,10,10" open="false">
		East Content
	</east>
	<west title="West" size="20%" collapsible="true" cmargins="10,10,10,10" open="false">
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
