package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Tabbox_Misc extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<hbox>
		<window title="Tabbox, tabscroll=false" sclass="center-bg-win" 
			border="normal" width="300px" height="300px">
			<tabbox tabscroll="false" height="100%">
				<tabs>
					<tab label="Tab 1" />
					<tab label="Tab 2" />
					<tab label="Tab 3" />
				</tabs>
				<tabpanels>
					<tabpanel>Tabpanel 1 Content</tabpanel>
					<tabpanel>Tabpanel 2 Content</tabpanel>
					<tabpanel>Tabpanel 3 Content</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
	</hbox>
	<separator />
	<hbox>
		<window title="Tabbox, tabscroll=false" sclass="center-bg-win" 
			border="normal" width="300px" height="300px">
			<tabbox tabscroll="false" orient="vertical" height="100%">
				<tabs>
					<tab label="Tab 1" />
					<tab label="Tab 2" />
					<tab label="Tab 3" />
				</tabs>
				<tabpanels>
					<tabpanel>Tabpanel 1 Content</tabpanel>
					<tabpanel>Tabpanel 2 Content</tabpanel>
					<tabpanel>Tabpanel 3 Content</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
	</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}