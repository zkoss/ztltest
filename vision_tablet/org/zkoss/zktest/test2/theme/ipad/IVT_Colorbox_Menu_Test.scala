package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Colorbox_Menu_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<menubar id="menubar" width="100%">
		<menu id="main" image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
			<menupopup>
				<menuitem label="Index" onClick="alert(self.label)" />
				<menu label="Color Picker" content="#color=#184dc6"/>
			</menupopup>
		</menu>
	</menubar>
	
	<zscript>
		import org.zkoss.zk.ui.util.Clients;
		
		main.open();
		Clients.evalJavaScript("jq('@menu:eq(1)').click()");
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
