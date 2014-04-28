package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Combo_Rounded_Normal_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox style="margin: 10px 0;">	
	Combobox:
	<combobox mold="rounded">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<combobox mold="rounded" buttonVisible="false">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	Datebox:
	<datebox mold="rounded" />
	<datebox mold="rounded" buttonVisible="false" />
	Bandbox:
	<bandbox mold="rounded">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<bandbox mold="rounded" buttonVisible="false">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	Timebox:
	<timebox mold="rounded" />
	<timebox mold="rounded" buttonVisible="false" />
	Spinner:
	<spinner mold="rounded" />
	<spinner mold="rounded" buttonVisible="false" />
	Doublespinner:
	<doublespinner mold="rounded" />
	<doublespinner mold="rounded" buttonVisible="false" />
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
