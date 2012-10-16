package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Inputs_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<hbox vflex="min">
	<window title="Default Mold" sclass="center-bg-win"
		border="normal" width="300px">
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
			<separator />
		</vbox>
	</window>
	<window title="Default Mold, Disabled" sclass="center-bg-win" 
		border="normal" width="300px">
		<vbox>
			Combobox:
			<combobox disabled="true">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			<combobox disabled="true" buttonVisible="false">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			<separator />
			Datebox:
			<datebox disabled="true" />
			<datebox disabled="true" buttonVisible="false" />
			<separator />
			Bandbox:
			<bandbox disabled="true">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			<bandbox disabled="true" buttonVisible="false">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			<separator />
			Timebox:
			<timebox disabled="true" />
			<timebox disabled="true" buttonVisible="false" />
			<separator />
			Spinner:
			<spinner disabled="true" />
			<spinner disabled="true" buttonVisible="false" />
			<separator />
			Doublespinner:
			<doublespinner disabled="true" />
			<doublespinner disabled="true" buttonVisible="false" />
			<separator />
		</vbox>
	</window>
	<window title="Default Mold, Read Only" sclass="center-bg-win"
		border="normal" width="300px">
		<vbox>
			Combobox:
			<combobox readonly="true">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			<combobox readonly="true" buttonVisible="false">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			<separator />
			Datebox:
			<datebox readonly="true" />
			<datebox readonly="true" buttonVisible="false" />
			<separator />
			Bandbox:
			<bandbox readonly="true">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			<bandbox readonly="true" buttonVisible="false">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			<separator />
			Timebox:
			<timebox readonly="true" />
			<timebox readonly="true" buttonVisible="false" />
			<separator />
			Spinner:
			<spinner readonly="true" />
			<spinner readonly="true" buttonVisible="false" />
			<separator />
			Doublespinner:
			<doublespinner readonly="true" />
			<doublespinner readonly="true" buttonVisible="false" />
			<separator />
		</vbox>
	</window>
	<window title="Default Mold, Inplace" sclass="center-bg-win"
		border="normal" width="300px">
		<vbox>
			Combobox:
			<combobox inplace="true">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			<combobox inplace="true" buttonVisible="false">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			<separator />
			Datebox:
			<datebox inplace="true" />
			<datebox inplace="true" buttonVisible="false" />
			<separator />
			Bandbox:
			<bandbox inplace="true">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			<bandbox inplace="true" buttonVisible="false">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			<separator />
			Timebox:
			<timebox inplace="true" />
			<timebox inplace="true" buttonVisible="false" />
			<separator />
			Spinner:
			<spinner inplace="true" />
			<spinner inplace="true" buttonVisible="false" />
			<separator />
			Doublespinner:
			<doublespinner inplace="true" />
			<doublespinner inplace="true" buttonVisible="false" />
			<separator />
		</vbox>
	</window>
</hbox>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}