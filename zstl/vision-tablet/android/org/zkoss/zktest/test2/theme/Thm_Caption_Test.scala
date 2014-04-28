package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Caption_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<hlayout>
		<window width="300px" height="300px" border="normal">
			<caption label="Title" image="/img/volumn.gif">
				Caption Content
				<button label="Button" />
			</caption>
			Window Content
		</window>
		<panel width="300px" height="300px" border="normal">
			<caption label="Title" image="/img/volumn.gif">
				Caption Content
				<button label="Button" />
			</caption>
			<panelchildren>
				Panel Content
			</panelchildren>
		</panel>
	</hlayout>
	<separator />
	<hlayout>
		<groupbox width="300px" height="300px">
			<caption label="Title" image="/img/volumn.gif">
				Caption Content
				<button label="Button" />
			</caption>
			Groupbox Content
		</groupbox>
		<groupbox width="300px" height="300px" mold="3d">
			<caption label="Title" image="/img/volumn.gif">
				Caption Content
				<button label="Button" />
			</caption>
			Groupbox Content
		</groupbox>
	</hlayout>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}