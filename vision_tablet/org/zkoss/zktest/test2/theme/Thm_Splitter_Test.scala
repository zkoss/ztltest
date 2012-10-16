package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Splitter_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<hbox>
	<panel title="Splitter, Default Mold" sclass="center-bg-win" framable="true" border="normal" 
		height="300px" width="300px">
		<panelchildren>
			<hbox spacing="0" height="100%">
				<vbox spacing="0" width="100%" height="100%">
					Vbox Content
					<splitter collapse="before"/>
					Vbox Content
				</vbox>
				<splitter collapse="before"/>
				Hbox Content
			</hbox>
		</panelchildren>
	</panel>
	<separator />
	<panel title="Splitter, OS Mold" sclass="center-bg-win" framable="true" border="normal" 
		height="300px" width="300px">
		<panelchildren>
			<hbox spacing="0" height="100%">
				<vbox spacing="0" width="100%" height="100%">
					Vbox Content
					<splitter mold="os" collapse="before"/>
					Vbox Content
				</vbox>
				<splitter mold="os" collapse="before"/>
				Hbox Content
			</hbox>
		</panelchildren>
	</panel>
</hbox>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}