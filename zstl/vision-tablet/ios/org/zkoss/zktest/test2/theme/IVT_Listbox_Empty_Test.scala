package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Listbox_Empty_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<listbox emptyMessage="This Listbox is empty.">
	<listhead>
		<listheader label="Listheader Content" />
	</listhead>
</listbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
