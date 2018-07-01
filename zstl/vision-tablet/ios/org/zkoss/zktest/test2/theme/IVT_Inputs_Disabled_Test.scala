package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Disabled_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	<div>Decimalbox: <decimalbox value="123.45" disabled="true"/> (Disabled)</div>
	<div>Doublebox: <doublebox value="123.45" disabled="true"/> (Disabled)</div>
	<div>Intbox: <intbox value="123" disabled="true"/> (Disabled)</div>
	<div>Longbox: <longbox value="123" disabled="true"/> (Disabled)</div>
	<div>Textbox: <textbox value="abc" disabled="true"/> (Disabled)</div>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
