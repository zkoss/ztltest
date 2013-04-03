package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Checkbox_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	Checkbox: <checkbox/> Checked: <checkbox checked="true"/>  <textbox placeholder="test alignment"/>
	<separator/>
	Checkbox-Label: <checkbox label="checkbox"/> Checked: <checkbox label="checkbox" checked="true"/>  <textbox  placeholder="test alignment"/>
	<separator/>
	<radiogroup>Radio: <radio/> Checked: <radio checked="true"/>  <textbox  placeholder="test alignment"/></radiogroup>
	<separator/>
	<radiogroup>Radiobox: <radio  label="radio"/> Checked: <radio label="radio" checked="true"/> <textbox  placeholder="test alignment"/></radiogroup>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}