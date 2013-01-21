package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Borderlayout_Autoscroll_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<borderlayout>
	<center autoscroll="true">
		<vbox vflex="1">
			<label value="Center" />
			<label value="Content" />
			<label value="is" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="very" />
			<label value="long" />
			<label value="long" />
			<label value="long" />
			<label value="long" />
			<label value="long" />
			<label value="long" />
			<label value="long" />
			<label value="long" />
			<label value="long" />
			<label value="long" />
			<label value="long" />
			<label value="long" />
			<label value="long" />
		</vbox>
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
