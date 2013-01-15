package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Borderlayout_Collapsed_Ne_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<borderlayout>
	<center>
		<label multiline="true">
		Center Content: Line 1
		Center Content: Line 2
		Center Content: Line 3
		</label>
	</center>
	<west title="West" size="20%" splittable="true" collapsible="true">
		West Content
	</west>
	<east title="East" size="20%" splittable="true" collapsible="true" open="false">
		East Content
	</east>
	<north title="North" size="20%" splittable="true" collapsible="true" open="false">
		North Content
	</north>
	<south title="South" size="20%" splittable="true" collapsible="true">
		South Content
	</south>
</borderlayout>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
