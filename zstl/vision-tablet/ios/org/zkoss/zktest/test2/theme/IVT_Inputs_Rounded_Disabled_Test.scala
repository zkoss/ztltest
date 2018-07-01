package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Rounded_Disabled_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	<div>Decimalbox: <decimalbox mold="rounded" value="123.45" disabled="true"/> (Disabled)</div>
	<div>Doublebox: <doublebox mold="rounded" value="123.45" disabled="true"/> (Disabled)</div>
	<div>Intbox: <intbox mold="rounded" value="123" disabled="true"/> (Disabled)</div>
	<div>Longbox: <longbox mold="rounded" value="123" disabled="true"/> (Disabled)</div>
	<div>Textbox: <textbox mold="rounded" value="abc" disabled="true"/> (Disabled)</div>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
