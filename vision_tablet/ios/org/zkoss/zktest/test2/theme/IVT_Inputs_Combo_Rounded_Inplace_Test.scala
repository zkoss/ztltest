package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Combo_Rounded_Inplace_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox style="margin: 10px 0;">
	Combobox:
	<combobox mold="rounded" inplace="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<combobox mold="rounded" buttonVisible="false" inplace="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	Datebox:
	<datebox mold="rounded" inplace="true"/>
	<datebox mold="rounded" buttonVisible="false" inplace="true"/>
	Bandbox:
	<bandbox mold="rounded" inplace="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<bandbox mold="rounded" buttonVisible="false" inplace="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	Timebox:
	<timebox mold="rounded" inplace="true"/>
	<timebox mold="rounded" buttonVisible="false" inplace="true"/>
	Spinner:
	<spinner mold="rounded" inplace="true"/>
	<spinner mold="rounded" buttonVisible="false" inplace="true"/>
	Doublespinner:
	<doublespinner mold="rounded" inplace="true"/>
	<doublespinner mold="rounded" buttonVisible="false" inplace="true"/>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
