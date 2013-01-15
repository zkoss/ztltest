package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Combobutton_Menu_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<combobutton id="cbb" label="Combobutton" image="/common/img/volumn.gif">
		<menupopup>
			<menuitem label="Index" />
			<menu label="About">
				<menupopup>
					<menuitem label="About ZK" />
					<menuitem label="About Potix" />
				</menupopup>
			</menu>
		</menupopup>
	</combobutton>
	
	<zscript>
		cbb.open();
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
