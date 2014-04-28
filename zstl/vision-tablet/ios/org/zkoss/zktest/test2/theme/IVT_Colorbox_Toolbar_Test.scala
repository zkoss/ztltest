package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Colorbox_Toolbar_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<toolbar orient="vertical" width="38px" height="100%">
		<colorbox width="22px" height="12px" color="#FFFFFF" />
	</toolbar>
	
	<zscript>
		import org.zkoss.zk.ui.util.Clients;
		
		Clients.evalJavaScript("jq('@colorbox').click()");
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
