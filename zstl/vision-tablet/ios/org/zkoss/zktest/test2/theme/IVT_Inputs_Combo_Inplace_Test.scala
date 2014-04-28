package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Combo_Inplace_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	Combobox:
	<combobox inplace="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<combobox buttonVisible="false" inplace="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<separator />
	Datebox:
	<datebox format="yyyy/MM/dd hh:mm:ss a" inplace="true"/>
	<datebox buttonVisible="false" inplace="true"/>
	<separator />
	Bandbox:
	<bandbox inplace="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<bandbox buttonVisible="false" inplace="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<separator />
	Timebox:
	<timebox inplace="true"/>
	<timebox buttonVisible="false" inplace="true"/>
	<separator />
	Spinner:
	<spinner inplace="true"/>
	<spinner buttonVisible="false" inplace="true"/>
	<separator />
	Doublespinner:
	<doublespinner inplace="true"/>
	<doublespinner buttonVisible="false" inplace="true"/>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
