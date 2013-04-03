package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Combo_Readonly_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	Combobox:
	<combobox readonly="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<combobox buttonVisible="false" readonly="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<separator />
	Datebox:
	<datebox format="yyyy/MM/dd hh:mm:ss a" readonly="true"/>
	<datebox buttonVisible="false" readonly="true"/>
	<separator />
	Bandbox:
	<bandbox readonly="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<bandbox buttonVisible="false" readonly="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<separator />
	Timebox:
	<timebox readonly="true"/>
	<timebox buttonVisible="false" readonly="true"/>
	<separator />
	Spinner:
	<spinner readonly="true"/>
	<spinner buttonVisible="false" readonly="true"/>
	<separator />
	Doublespinner:
	<doublespinner readonly="true"/>
	<doublespinner buttonVisible="false" readonly="true"/>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
