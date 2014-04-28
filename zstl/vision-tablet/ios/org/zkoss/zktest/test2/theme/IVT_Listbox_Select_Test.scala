package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Listbox_Select_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<listbox rows="1" mold="select">
	<listitem label="Inbox"/>
	<listitem label="Received"/>
	<listitem label="Draft"/>
</listbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
