package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Combobox_Description_Icon_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<combobox open="true">
	<comboitem label="Comboitem 1" 
		description="Description of the great Comboitem 1."
		image="/img/search.png" />
	<comboitem label="Comboitem 2" 
		description="Description of the great Comboitem 2."
		image="/img/search.png" />
	<comboitem label="Comboitem 3" 
		description="Description of the great Comboitem 3."
		image="/img/search.png" />
</combobox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
