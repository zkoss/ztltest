package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Paging_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<paging totalSize="300" pageSize="5" activePage="15" detailed="true" />
	<paging totalSize="300" pageSize="5" activePage="15" detailed="true" mold="os" />
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}