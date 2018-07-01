package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Menupopup_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<button label="Open menupopup" id="btn">
		<attribute name="onClick">
		popup.open(self);
		</attribute>
	</button>
	<menupopup id="popup">
		<menuitem
			image="/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png"
			label="New" onClick="alert(self.label)" />
		<menuitem
			image="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png"
			label="Open" onClick="alert(self.label)" />
		<menuitem
			image="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png"
			label="Save" onClick="alert(self.label)" />
		<menuseparator />
		<menuitem label="Exit"
			image="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png"
			onClick="alert(self.label)" />
	</menupopup>
	<zscript>
	popup.open(btn, "after_end");
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
