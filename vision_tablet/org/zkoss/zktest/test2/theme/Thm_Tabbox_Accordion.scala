package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Tabbox_Accordion extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<hbox>
		<window title="Tabbox Accordion" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<tabbox height="100%" mold="accordion">
				<tabs>
					<tab label="Tab1" closable="true" />
					<tab label="Tab2" closable="true" />
					<tab label="Tab3" />
					<tab label="Tab4" disabled="true" closable="true" />
					<tab label="Tab5" disabled="true" />
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
		<window title="Tabbox Accordion" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<tabbox height="100%" mold="accordion">
				<tabs>
					<tab label="Tab1" image="/img/volumn.gif" closable="true" />
					<tab label="Tab2" image="/img/volumn.gif" closable="true" />
					<tab label="Tab3" image="/img/volumn.gif" />
					<tab label="Tab4" image="/img/volumn.gif" disabled="true" closable="true" />
					<tab label="Tab5" image="/img/volumn.gif" disabled="true" />
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
	</hbox>
	<separator />
	<hbox>
		<window title="Tabbox Accordion-lite" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<tabbox height="100%" mold="accordion-lite">
				<tabs>
					<tab label="Tab1" closable="true" />
					<tab label="Tab2" closable="true" />
					<tab label="Tab3" />
					<tab label="Tab4" disabled="true" closable="true" />
					<tab label="Tab5" disabled="true" />
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
		<window title="Tabbox Accordion-lite" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<tabbox height="100%" mold="accordion-lite">
				<tabs>
					<tab label="Tab1" image="/img/volumn.gif" closable="true" />
					<tab label="Tab2" image="/img/volumn.gif" closable="true" />
					<tab label="Tab3" image="/img/volumn.gif" />
					<tab label="Tab4" image="/img/volumn.gif" disabled="true" closable="true" />
					<tab label="Tab5" image="/img/volumn.gif" disabled="true" />
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
	</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}