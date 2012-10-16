package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Slider_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<hbox>
	<window title="Slider: Horizontal" sclass="center-bg-win"
		border="normal" width="300px" height="300px">
		<vbox>
			<slider />
			<slider mold="sphere" />
			<slider mold="scale" />
		</vbox>
	</window>
	<window title="Slider: Vertical" sclass="center-bg-win"
		border="normal" width="300px" height="300px">
		<hbox>
			<slider orient="vertical" />
			<slider mold="sphere" orient="vertical" />
		</hbox>
	</window>
</hbox>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}