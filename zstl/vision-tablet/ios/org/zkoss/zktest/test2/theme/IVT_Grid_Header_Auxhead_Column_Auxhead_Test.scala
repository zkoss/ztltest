package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Grid_Header_Auxhead_Column_Auxhead_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<grid fixedLayout="true" width="900px">
	<auxhead>
		<auxheader label="A+B" colspan="2"/>
		<auxheader label="C"/>
	</auxhead>
	<columns id="cs">
		<column label="Align Left" align="left" width="300px"/>
		<column label="Align Center" align="center" width="300px"/>
		<column label="Align Right" align="right" width="300px"/>
	</columns>
	<auxhead>
		<auxheader label="C+D" colspan="2"/>
		<auxheader label="E"/>
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
		<footer label="footer 3"/>
	</foot>
</grid>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
