package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Panel_Noborder_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<hbox spacing="0">
		<panel framable="true" height="300px" width="300px" 
			maximizable="true" minimizable="true" collapsible="true" closable="true"
			title="Panel (with frame)">
			<toolbar mold="panel">Toolbar</toolbar>
			<panelchildren>
				Panel Content
			</panelchildren>
			<toolbar>Toolbar</toolbar>
			<toolbar mold="panel">Toolbar</toolbar>
		</panel>
		<separator orient="vertical" spacing="10px" />
		<panel height="300px" width="300px" 
			maximizable="true" minimizable="true" collapsible="true" closable="true"
			title="Panel (no frame)">
			<toolbar mold="panel">Toolbar</toolbar>
			<panelchildren>
				Panel Content
			</panelchildren>
			<toolbar>Toolbar</toolbar>
			<toolbar mold="panel">Toolbar</toolbar>
		</panel>
		<separator orient="vertical" spacing="10px" />
		<panel framable="true" height="300px" width="300px">
			<toolbar mold="panel">Toolbar</toolbar>
			<panelchildren>
				Panel Content
			</panelchildren>
			<toolbar>Toolbar</toolbar>
			<toolbar mold="panel">Toolbar</toolbar>
		</panel>
		<separator orient="vertical" spacing="10px" />
		<panel height="300px" width="300px">
			<toolbar mold="panel">Toolbar</toolbar>
			<panelchildren>
				Panel Content
			</panelchildren>
			<toolbar>Toolbar</toolbar>
			<toolbar mold="panel">Toolbar</toolbar>
		</panel>
	</hbox>
	<separator spacing="10px" />
	<hbox spacing="0">
		<panel framable="true" height="300px" width="300px" 
			maximizable="true" minimizable="true" collapsible="true" closable="true"
			title="Panel (with frame)">
			<panelchildren>
				Panel Content
			</panelchildren>
		</panel>
		<separator orient="vertical" spacing="10px" />
		<panel height="300px" width="300px" title="Panel (no frame)"
			maximizable="true" minimizable="true" collapsible="true" closable="true">
			<panelchildren>
				Panel Content
			</panelchildren>
		</panel>
		<separator orient="vertical" spacing="10px" />
		<panel framable="true" height="300px" width="300px">
			<panelchildren>
				Panel Content
			</panelchildren>
		</panel>
		<separator orient="vertical" spacing="10px" />
		<panel height="300px" width="300px">
			<panelchildren>
				Panel Content
			</panelchildren>
		</panel>
	</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}