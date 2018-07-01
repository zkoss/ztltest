package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Messagebox_Question_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zscript>
	import org.zkoss.zul.Messagebox;
	
	Messagebox.show("A question. Are you sure?", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
</zscript>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
