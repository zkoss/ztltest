package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Fisheyebar_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<window width="300px" height="300px">
	<div>
		<checkbox label="AttachEdge bottom" onCheck='fsb.attachEdge=self.checked?"bottom":"top"' />
		<checkbox label="Vertical orient" onCheck='fsb.orient=self.checked?"vertical":"horizontal"' />
	</div>
	<separator />
	Note: The label of Fisheyebar is the only theme element that can be customized.
	<fisheyebar id="fsb" style="position:absolute;margin:80px 150px;"
		attachEdge="top" itemWidth="80" itemHeight="80" itemMaxHeight="160" itemMaxWidth="160">
		<fisheye image="/img/Centigrade-Widget-Icons/FolderABlue-128x128.png" label="Folder" />
		<fisheye image="/img/Centigrade-Widget-Icons/ReadingGlass-128x128.png" label="Reading Glasses" />
		<fisheye image="/img/Centigrade-Widget-Icons/Briefcase-128x128.png" label="Project" />
		<fisheye image="/img/Centigrade-Widget-Icons/MailboxFlag-128x128.png" label="Email" />
		<fisheye image="/img/Centigrade-Widget-Icons/Globe-128x128.png" label="Globe" />
		<fisheye image="/img/Centigrade-Widget-Icons/Spyglass-128x128.png" label="Spyglass" />
	</fisheyebar>
</window>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				swipeRight(jq("@fisheyebar"), 100);
				sleep(500);
				verifyImage();
				
				singleTap(jq("input[type=checkbox]:eq(1)"));
				verifyImage();
			});
	}
}