package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Inputs_Rounded_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<hbox vflex="min">
	<window title="Rounded Mold" sclass="center-bg-win"
		border="normal" width="300px">
		<vbox style="padding: 10px 0;">	
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
			Decimalbox:
			<decimalbox mold="rounded"/>
			Doublebox:
			<doublebox mold="rounded"/>
			Intbox:
			<intbox mold="rounded"/>
			Longbox:
			<longbox mold="rounded"/>
			Textbox:
			<textbox mold="rounded"/>
			<textbox mold="rounded" multiline="true" rows="2" />
		</vbox>
	</window>
	<window title="Rounded Mold, Disabled" sclass="center-bg-win"
		border="normal" width="300px">
		<vbox style="padding: 10px 0;">
			Combobox:
			<combobox mold="rounded" disabled="true">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			<combobox mold="rounded" disabled="true" buttonVisible="false">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			Datebox:
			<datebox mold="rounded" disabled="true" />
			<datebox mold="rounded" disabled="true" buttonVisible="false" />
			Bandbox:
			<bandbox mold="rounded" disabled="true">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			<bandbox mold="rounded" disabled="true" buttonVisible="false">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			Timebox:
			<timebox mold="rounded" disabled="true" />
			<timebox mold="rounded" disabled="true" buttonVisible="false" />
			Spinner:
			<spinner mold="rounded" disabled="true" />
			<spinner mold="rounded" disabled="true" buttonVisible="false" />
			Doublespinner:
			<doublespinner mold="rounded" disabled="true" />
			<doublespinner mold="rounded" disabled="true" buttonVisible="false" />
			Decimalbox:
			<decimalbox mold="rounded" disabled="true"/>
			Doublebox:
			<doublebox mold="rounded" disabled="true"/>
			Intbox:
			<intbox mold="rounded" disabled="true"/>
			Longbox:
			<longbox mold="rounded" disabled="true"/>
			Textbox:
			<textbox mold="rounded" disabled="true"/>
			<textbox mold="rounded" disabled="true" multiline="true" rows="2" />
		</vbox>
	</window>
	<window title="Rounded Mold, Read Only" sclass="center-bg-win"
		border="normal" width="300px">
		<vbox style="padding: 10px 0;">
			Combobox:
			<combobox readonly="true" mold="rounded">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			<combobox readonly="true" mold="rounded" buttonVisible="false">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			Datebox:
			<datebox readonly="true" mold="rounded" />
			<datebox readonly="true" mold="rounded" buttonVisible="false" />
			Bandbox:
			<bandbox readonly="true" mold="rounded">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			<bandbox readonly="true" mold="rounded" buttonVisible="false">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			Timebox:
			<timebox readonly="true" mold="rounded" />
			<timebox readonly="true" mold="rounded" buttonVisible="false" />
			Spinner:
			<spinner readonly="true" mold="rounded" />
			<spinner readonly="true" mold="rounded" buttonVisible="false" />
			Doublespinner:
			<doublespinner mold="rounded" readonly="true" />
			<doublespinner mold="rounded" readonly="true" buttonVisible="false" />
			Decimalbox:
			<decimalbox mold="rounded" readonly="true"/>
			Doublebox:
			<doublebox mold="rounded" readonly="true"/>
			Intbox:
			<intbox mold="rounded" readonly="true"/>
			Longbox:
			<longbox mold="rounded" readonly="true"/>
			Textbox:
			<textbox mold="rounded" readonly="true"/>
			<textbox mold="rounded" readonly="true" multiline="true" rows="2" />
		</vbox>
	</window>
	<window title="Rounded Mold, Inplace" sclass="center-bg-win"
		border="normal" width="300px">
		<vbox style="padding: 10px 0;">
			Combobox:
			<combobox inplace="true" mold="rounded">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			<combobox inplace="true" mold="rounded" buttonVisible="false">
				<comboitem label="Comboitem 1" />
				<comboitem label="Comboitem 2" />
				<comboitem label="Comboitem 3" />
			</combobox>
			Datebox:
			<datebox inplace="true" mold="rounded" />
			<datebox inplace="true" mold="rounded" buttonVisible="false" />
			Bandbox:
			<bandbox inplace="true" mold="rounded">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			<bandbox inplace="true" mold="rounded" buttonVisible="false">
				<bandpopup>Bandpopup Content</bandpopup>
			</bandbox>
			Timebox:
			<timebox inplace="true" mold="rounded" />
			<timebox inplace="true" mold="rounded" buttonVisible="false" />
			Spinner:
			<spinner inplace="true" mold="rounded" />
			<spinner inplace="true" mold="rounded" buttonVisible="false" />
			Doublespinner:
			<doublespinner mold="rounded" inplace="true" />
			<doublespinner mold="rounded" inplace="true" buttonVisible="false" />
			Decimalbox:
			<decimalbox mold="rounded" inplace="true"/>
			Doublebox:
			<doublebox mold="rounded" inplace="true"/>
			Intbox:
			<intbox mold="rounded" inplace="true"/>
			Longbox:
			<longbox mold="rounded" inplace="true"/>
			Textbox:
			<textbox mold="rounded" inplace="true"/>
			<textbox mold="rounded" inplace="true" multiline="true" rows="2" />
		</vbox>
	</window>
</hbox>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}