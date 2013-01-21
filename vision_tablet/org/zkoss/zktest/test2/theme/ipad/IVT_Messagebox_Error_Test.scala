package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Messagebox_Error_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zscript>
	import org.zkoss.zul.Messagebox;
	
	Messagebox.show("Some error message", "Error", Messagebox.OK, Messagebox.ERROR);
</zscript>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
