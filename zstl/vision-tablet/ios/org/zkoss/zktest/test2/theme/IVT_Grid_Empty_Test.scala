package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Grid_Empty_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<grid emptyMessage="This Grid is empty.">
	<columns>
		<column label="Column Title">Column Content</column>
	</columns>
</grid>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
