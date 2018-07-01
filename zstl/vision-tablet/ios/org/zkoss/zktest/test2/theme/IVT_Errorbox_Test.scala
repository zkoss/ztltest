package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Errorbox_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<textbox id="tbx" constraint="/^`````````$/" />
	
	<zscript>
	import org.zkoss.zk.ui.util.Clients;
	
	tbx.setFocus(true);
	Clients.evalJavaScript("jq('$tbx').trigger('blur')");
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
