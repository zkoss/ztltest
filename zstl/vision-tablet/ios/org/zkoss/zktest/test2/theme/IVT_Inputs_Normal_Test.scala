package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Normal_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	<div>Decimalbox: <decimalbox value="123.45" /> (Normal)</div>
	<div>Doublebox: <doublebox value="123.45" /> (Normal)</div>
	<div>Intbox: <intbox value="123" /> (Normal)</div>
	<div>Longbox: <longbox value="123" /> (Normal)</div>
	<div>Textbox: <textbox value="abc" /> (Normal)</div>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
