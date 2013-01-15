package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Combobox_Description_Icon_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<combobox open="true">
	<comboitem label="Comboitem 1" 
		description="Description of the great Comboitem 1."
		image="/common/img/search.png" />
	<comboitem label="Comboitem 2" 
		description="Description of the great Comboitem 2."
		image="/common/img/search.png" />
	<comboitem label="Comboitem 3" 
		description="Description of the great Comboitem 3."
		image="/common/img/search.png" />
</combobox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
