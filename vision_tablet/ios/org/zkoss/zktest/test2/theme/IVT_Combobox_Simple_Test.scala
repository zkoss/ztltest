package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Combobox_Simple_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<combobox open="true">
	<comboitem label="Comboitem 1" />
	<comboitem label="Comboitem 2" />
	<comboitem label="Comboitem 3" />
</combobox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
