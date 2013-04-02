package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Combo_Rounded_Readonly_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox style="margin: 10px 0;">
	Combobox:
	<combobox mold="rounded" readonly="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<combobox mold="rounded" buttonVisible="false" readonly="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	Datebox:
	<datebox mold="rounded" readonly="true"/>
	<datebox mold="rounded" buttonVisible="false" readonly="true"/>
	Bandbox:
	<bandbox mold="rounded" readonly="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<bandbox mold="rounded" buttonVisible="false" readonly="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	Timebox:
	<timebox mold="rounded" readonly="true"/>
	<timebox mold="rounded" buttonVisible="false" readonly="true"/>
	Spinner:
	<spinner mold="rounded" readonly="true"/>
	<spinner mold="rounded" buttonVisible="false" readonly="true"/>
	Doublespinner:
	<doublespinner mold="rounded" readonly="true"/>
	<doublespinner mold="rounded" buttonVisible="false" readonly="true"/>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
