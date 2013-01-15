package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Grid_Header_Only_Auxhead_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<grid fixedLayout="true" width="900px">
	<auxhead>
		<auxheader label="A+B" colspan="2"/>
		<auxheader label="C"/>
	</auxhead>
	<rows>
		<row>
			<label value="AA01"/>
			<label value="BB01"/>
			<label value="CC01"/>
		</row>
	</rows>
	<foot>
		<footer label="footer 1"/>
		<footer label="footer 2"/>
	</foot>
</grid>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
