package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Colorbox_Basic_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<colorbox />
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
