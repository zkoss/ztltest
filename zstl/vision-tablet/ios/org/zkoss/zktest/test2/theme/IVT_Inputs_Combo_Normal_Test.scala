package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Combo_Normal_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	Combobox:
	<combobox>
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<combobox buttonVisible="false">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<separator />
	Datebox:
	<datebox format="yyyy/MM/dd hh:mm:ss a" />
	<datebox buttonVisible="false" />
	<separator />
	Bandbox:
	<bandbox>
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<bandbox buttonVisible="false">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<separator />
	Timebox:
	<timebox />
	<timebox buttonVisible="false" />
	<separator />
	Spinner:
	<spinner />
	<spinner buttonVisible="false" />
	<separator />
	Doublespinner:
	<doublespinner />
	<doublespinner buttonVisible="false" />
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
