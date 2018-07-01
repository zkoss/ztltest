package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Menu_Colorpicker_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<menubar id="menubar" width="100%">
		<menu id="primary"
			image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
			<menupopup>
				<menuitem label="Index"
					onClick="alert(self.label)" />
				<menu label="Color Picker" id="color"
					content="#color=#184dc6" />
			</menupopup>
		</menu>
	</menubar>
	<zscript>
	import org.zkoss.zk.ui.util.Clients;
	
	primary.open();
	Clients.evalJavaScript("jq('$color').trigger('click')");
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
