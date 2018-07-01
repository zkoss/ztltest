package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Toolbar_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<hbox>
		<window title="Window" border="normal" height="300px" width="300px">
			<toolbar>
				<toolbarbutton label="Button 1" image="/img/volumn.gif"/>
				<toolbarbutton label="Button 2" mode="toggle" checked="true" image="/img/network.gif"/>
				<a href="http://www.zkoss.org">ZK</a>
			</toolbar>
			Window Content
		</window>
		<panel title="Panel" border="normal" height="300px" width="300px" framable="true" >
			<toolbar >
				<toolbarbutton label="Button 1" image="/img/volumn.gif"/>
				<toolbarbutton label="Button 2" mode="toggle" checked="true" image="/img/network.gif"/>
			</toolbar>
			<panelchildren >
				Panel Content
				(For Toolbar in panel mold, see Panel demo.)
			</panelchildren>
			<toolbar mold="panel">
				<toolbarbutton label="Button 1" image="/img/volumn.gif"/>
				<toolbarbutton label="Button 2" mode="toggle" checked="true" image="/img/network.gif"/>
			</toolbar>
		</panel>
		<tabbox height="300px" width="300px" >
			<tabs>
				<tab label="Tab 1"/>
				<tab label="Tab 2"/>
			</tabs>
			<tabpanels>
				<tabpanel>
					Tabpanel Content
				</tabpanel>
				<tabpanel>
					Tabpanel Content
				</tabpanel>
			</tabpanels>
			<toolbar>
				<toolbarbutton label="Button 1" image="/img/volumn.gif"/>
				<toolbarbutton label="Button 2" mode="toggle" checked="true" image="/img/network.gif"/>
			</toolbar>
		</tabbox>
	</hbox>
	<separator />
	<hbox>
		<window title="Window" border="normal" height="300px" width="300px">
			<toolbar>
				<toolbarbutton label="Button 1" />
				<toolbarbutton label="Button 2" mode="toggle" checked="true" />
			</toolbar>
			Window Content
		</window>
		<panel title="Panel" border="normal" height="300px" width="300px" framable="true" >
			<toolbar>
				<toolbarbutton label="Button 1" />
				<toolbarbutton label="Button 2" mode="toggle" checked="true" />
			</toolbar>
			<panelchildren>
				Panel Content
				(For Toolbar in panel mold, see Panel demo.)
			</panelchildren>
			<toolbar mold="panel">
				<toolbarbutton label="Button 1" />
				<toolbarbutton label="Button 2" mode="toggle" checked="true" />
			</toolbar>
		</panel>
		<tabbox height="300px" width="300px" >
			<tabs>
				<tab label="Tab 1"/>
				<tab label="Tab 2"/>
			</tabs>
			<tabpanels>
				<tabpanel>
					Tabpanel Content
				</tabpanel>
				<tabpanel>
					Tabpanel Content
				</tabpanel>
			</tabpanels>
			<toolbar>
				<toolbarbutton label="Button 1" />
				<toolbarbutton label="Button 2" mode="toggle" checked="true" />
			</toolbar>
		</tabbox>
	</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}