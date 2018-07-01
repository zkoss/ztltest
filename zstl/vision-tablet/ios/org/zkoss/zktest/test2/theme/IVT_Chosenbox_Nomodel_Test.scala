package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Chosenbox_Nomodel_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<chosenbox
	id="cbx"
	width="300px"
	creatable="true"
	onSelect=""
	noResultsText="No Result"
	createMessage="Create New" />
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
