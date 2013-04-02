package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Messagebox_Information_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zscript>
	import org.zkoss.zul.Messagebox;
	
	Messagebox.show("Some information", "Information", Messagebox.OK, Messagebox.INFORMATION);
</zscript>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
