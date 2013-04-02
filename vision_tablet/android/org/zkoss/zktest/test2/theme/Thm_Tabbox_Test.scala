package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Tabbox_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<hbox>
		<window title="Tabbox Horizontal with Toolbar" sclass="center-bg-win" 
			border="normal" width="300px" height="300px" >
			<tabbox height="100%">
				<toolbar>
					<toolbarbutton label="Button 1" image="/img/volumn.gif" />
				</toolbar>
				<tabs>
					<tab label="Tab1" closable="true" />
					<tab label="Tab2" closable="true" />
					<tab label="Tab3" closable="true" />
					<tab label="Tab4" closable="true" />
					<tab label="Tab5" />
				</tabs>
				<tabpanels>
					<tabpanel>
						Tabpanel Content 1
					</tabpanel>
					<tabpanel>Tabpanel Content 2</tabpanel>
					<tabpanel>Tabpanel Content 3</tabpanel>
					<tabpanel>Tabpanel Content 4</tabpanel>
					<tabpanel>Tabpanel Content 5</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
		<window title="Tabbox Horizontal with images on Tabs" sclass="center-bg-win" 
			border="normal" width="300px" height="300px" >
			<tabbox height="100%">
				<toolbar>
					<toolbarbutton label="Button 1" image="/img/volumn.gif" />
				</toolbar>
				<tabs>
					<tab label="Tab1" closable="true" image="/img/volumn.gif" />
					<tab label="Tab2" closable="true" image="/img/volumn.gif" />
					<tab label="Tab3" closable="true" />
					<tab label="Tab4" closable="true" />
					<tab label="Tab5" image="/img/volumn.gif" />
				</tabs>
				<tabpanels>
					<tabpanel>
						Tabpanel Content 1
					</tabpanel>
					<tabpanel>Tabpanel Content 2</tabpanel>
					<tabpanel>Tabpanel Content 3</tabpanel>
					<tabpanel>Tabpanel Content 4</tabpanel>
					<tabpanel>Tabpanel Content 5</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
		<window title="Tabbox Horizontal" border="normal" sclass="center-bg-win"
			width="300px" height="300px" >
			<tabbox height="100%">
				<tabs>
					<tab label="Tab1" closable="true" />
					<tab label="Tab2" closable="true" />
					<tab label="Tab3" closable="true" />
					<tab label="Tab4" closable="true" />
					<tab label="Tab5" />
				</tabs>
				<tabpanels>
					<tabpanel>
						Tabpanel Content 1
					</tabpanel>
					<tabpanel>Tabpanel Content 2</tabpanel>
					<tabpanel>Tabpanel Content 3</tabpanel>
					<tabpanel>Tabpanel Content 4</tabpanel>
					<tabpanel>Tabpanel Content 5</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
		<window title="Tabbox Vertical" border="normal" sclass="center-bg-win" 
			width="300px" height="300px" >
			<tabbox height="100%" orient="vertical">
				<tabs width="80px">
					<tab label="Tab1" closable="true" />
					<tab label="Tab2" closable="true" />
					<tab label="Tab3" closable="true" />
					<tab label="Tab4" closable="true" />
					<tab label="Tab5" closable="true" />
					<tab label="Tab6" />
					<tab label="Tab7" />
					<tab label="Tab8" />
					<tab label="Tab9" />
					<tab label="Tab10" />
				</tabs>
				<tabpanels>
					<tabpanel>
						<vbox>
							<label>Tabpanel Content 1</label>
						</vbox>
					</tabpanel>
					<tabpanel>Tabpanel Content 2</tabpanel>
					<tabpanel>Tabpanel Content 3</tabpanel>
					<tabpanel>Tabpanel Content 4</tabpanel>
					<tabpanel>Tabpanel Content 5</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
	</hbox>
	<separator />
	<hbox>
		<window title="Tabbox Horizontal with Toolbar" sclass="center-bg-win" 
			border="normal" width="300px" height="300px" >
			<tabbox height="100%">
				<toolbar>
					<toolbarbutton label="Button 1" image="/img/volumn.gif" />
				</toolbar>
				<tabs>
					<tab label="Tab1" closable="true" />
					<tab label="Tab2" closable="true" />
					<tab label="Tab3" />
				</tabs>
				<tabpanels>
					<tabpanel>
						Tabpanel Content 1
					</tabpanel>
					<tabpanel>Tabpanel Content 2</tabpanel>
					<tabpanel>Tabpanel Content 3</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
		<window title="Tabbox Horizontal with images on Tabs" sclass="center-bg-win" 
			border="normal" width="300px" height="300px" >
			<tabbox height="100%">
				<toolbar>
					<toolbarbutton label="Button 1" image="/img/volumn.gif" />
				</toolbar>
				<tabs>
					<tab label="Tab1" closable="true" image="/img/volumn.gif" />
					<tab label="Tab2" closable="true" />
				</tabs>
				<tabpanels>
					<tabpanel>
						Tabpanel Content 1
					</tabpanel>
					<tabpanel>Tabpanel Content 2</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
		<window title="Tabbox Horizontal" sclass="center-bg-win"
			border="normal" width="300px" height="300px" >
			<tabbox height="100%">
				<tabs>
					<tab label="Tab1" closable="true" />
					<tab label="Tab2" closable="true" />
					<tab label="Tab3" />
				</tabs>
				<tabpanels>
					<tabpanel>
						Tabpanel Content 1
					</tabpanel>
					<tabpanel>Tabpanel Content 2</tabpanel>
					<tabpanel>Tabpanel Content 3</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
		<window title="Tabbox Vertical" border="normal" sclass="center-bg-win" 
			width="300px" height="300px" >
			<tabbox height="100%" orient="vertical">
				<tabs width="80px">
					<tab label="Tab1 ZK" closable="true" />
					<tab label="Tab2" closable="true" />
					<tab label="Tab3" image="/img/volumn.gif" />
					<tab label="Tab4" />
					<tab label="Tab5" />
				</tabs>
				<tabpanels>
					<tabpanel>
						<vbox>
							<label>Tabpanel Content 1</label>
							<label>Note: User has to set tabs width manually.</label>
						</vbox>
					</tabpanel>
					<tabpanel>Tabpanel Content 2</tabpanel>
					<tabpanel>Tabpanel Content 3</tabpanel>
					<tabpanel>Tabpanel Content 4</tabpanel>
					<tabpanel>Tabpanel Content 5</tabpanel>
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