package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Rounded_Inplace_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	<div>Decimalbox: <decimalbox mold="rounded" value="123.45" inplace="true"/> (Inplace)</div>
	<div>Doublebox: <doublebox mold="rounded" value="123.45" inplace="true"/> (Inplace)</div>
	<div>Intbox: <intbox mold="rounded" value="123" inplace="true"/> (Inplace)</div>
	<div>Longbox: <longbox mold="rounded" value="123" inplace="true"/> (Inplace)</div>
	<div>Textbox: <textbox mold="rounded" value="abc" inplace="true"/> (Inplace)</div>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
