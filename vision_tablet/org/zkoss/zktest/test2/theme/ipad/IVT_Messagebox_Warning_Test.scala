package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Messagebox_Warning_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zscript>
	import org.zkoss.zul.Messagebox;
	
	Messagebox.show("Some warning messages", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
</zscript>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
