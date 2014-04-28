package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Inplace_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	<div>Decimalbox: <decimalbox value="123.45" inplace="true"/> (Inplace)</div>
	<div>Doublebox: <doublebox value="123.45" inplace="true"/> (Inplace)</div>
	<div>Intbox: <intbox value="123" inplace="true"/> (Inplace)</div>
	<div>Longbox: <longbox value="123" inplace="true"/> (Inplace)</div>
	<div>Textbox: <textbox value="abc" inplace="true"/> (Inplace)</div>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
