package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Rounded_Normal_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	<div>Decimalbox: <decimalbox mold="rounded" value="123.45" /> (Normal)</div>
	<div>Doublebox: <doublebox mold="rounded" value="123.45" /> (Normal)</div>
	<div>Intbox: <intbox mold="rounded" value="123" /> (Normal)</div>
	<div>Longbox: <longbox mold="rounded" value="123" /> (Normal)</div>
	<div>Textbox: <textbox mold="rounded" value="abc" /> (Normal)</div>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
