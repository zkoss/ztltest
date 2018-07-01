package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Button_Simple_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	Trendy Mold:
	<div>
		<button label="Button" mold="trendy" />
		<button image="/img/volumn.gif" mold="trendy" />
		<button label="Button" image="/img/volumn.gif" mold="trendy" />
	</div>
	OS Mold:
	<div>
		<button label="Button" mold="os" />
		<button image="/img/volumn.gif" mold="os" />
		<button label="Button" image="/img/volumn.gif" mold="os" />
	</div>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
