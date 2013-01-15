package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Combobutton_Popup_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<combobutton id="cbb" label="Combobutton" image="/common/img/volumn.gif">
		<popup>
			Popup Content
		</popup>
	</combobutton>
	
	<zscript>
		cbb.open();
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
