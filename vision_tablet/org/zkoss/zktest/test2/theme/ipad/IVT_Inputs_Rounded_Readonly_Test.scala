package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Rounded_Readonly_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	<div>Decimalbox: <decimalbox mold="rounded" value="123.45" readonly="true"/> (Read Only)</div>
	<div>Doublebox: <doublebox mold="rounded" value="123.45" readonly="true"/> (Read Only)</div>
	<div>Intbox: <intbox mold="rounded" value="123" readonly="true"/> (Read Only)</div>
	<div>Longbox: <longbox mold="rounded" value="123" readonly="true"/> (Read Only)</div>
	<div>Textbox: <textbox mold="rounded" value="abc" readonly="true"/> (Read Only)</div>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
