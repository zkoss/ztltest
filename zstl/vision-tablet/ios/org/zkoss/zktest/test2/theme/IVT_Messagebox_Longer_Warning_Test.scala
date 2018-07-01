package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Messagebox_Longer_Warning_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zscript>
	import org.zkoss.zul.Messagebox;
	
	Messagebox.show("A warning message\nEven more warning message", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
</zscript>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
