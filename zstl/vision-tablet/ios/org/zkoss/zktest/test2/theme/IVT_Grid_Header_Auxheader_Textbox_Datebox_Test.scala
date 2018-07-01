package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Grid_Header_Auxheader_Textbox_Datebox_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<grid fixedLayout="true" width="900px">
	<columns id="cs">
		<column label="Align Left" align="left" width="300px"/>
		<column label="Align Center" align="center" width="300px"/>
		<column label="Align Right" align="right" width="300px"/>
	</columns>
	<auxhead>
		<auxheader label="A+B" colspan="2"/>
		<auxheader label="C"/>
	</auxhead>
	<auxhead>
		<auxheader colspan="2">
			<label id="span">ss</label>
			<textbox onChange='span.value = self.value' />
			<datebox />
			ssss
		</auxheader>
	</auxhead>
	<rows>
		<row>
			<label value="AA01"/>
			<label value="BB01"/>
			<label value="CC01"/>
		</row>
		<row>
			<label value="AA01"/>
			<label value="BB01"/>
			<label value="CC01"/>
		</row>
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
