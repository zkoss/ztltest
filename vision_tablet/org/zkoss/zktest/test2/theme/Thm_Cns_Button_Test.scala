package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Cns_Button_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<toolbar>
		<toolbarbutton label="Toolbarbutton" mode="toggle" />
		<combobutton mold="toolbar" label="Combobutton" />
	</toolbar>
	<toolbar>
		<toolbarbutton label="Toolbarbutton" mode="toggle" image="/img/volumn.gif" />
		<combobutton mold="toolbar" label="Combobutton" image="/img/volumn.gif" />
	</toolbar>
	<separator />
	<div>
		<toolbarbutton label="Toolbarbutton" mode="toggle" image="/img/volumn.gif" />
		<combobutton mold="toolbar" label="Combobutton" image="/img/volumn.gif" />
	</div>
	<separator />
	<div>
		<button label="Button" />
		<combobutton label="Combobutton" />
	</div>
	<separator />
	<div>
		<button label="Button" image="/img/volumn.gif" />
		<combobutton label="Combobutton" image="/img/volumn.gif" />
	</div>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}