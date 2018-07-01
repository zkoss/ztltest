package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Readonly_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	<div>Decimalbox: <decimalbox value="123.45" readonly="true"/> (Read Only)</div>
	<div>Doublebox: <doublebox value="123.45" readonly="true"/> (Read Only)</div>
	<div>Intbox: <intbox value="123" readonly="true"/> (Read Only)</div>
	<div>Longbox: <longbox value="123" readonly="true"/> (Read Only)</div>
	<div>Textbox: <textbox value="abc" readonly="true"/> (Read Only)</div>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
