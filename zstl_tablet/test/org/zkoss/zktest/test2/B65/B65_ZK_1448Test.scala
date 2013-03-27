package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Touch,Android")
class B65_ZK_1448Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	iPad/Android only
	Should see left/right arrow icons.
	</label>
	<menubar id="menubar" width="200px">
		<custom-attributes org.zkoss.zul.image.preload="true" />
		<attribute name="onCreate">
			self.setScrollable(true);
		</attribute>
		<menu label="Project"
			image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
			<menupopup>
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
		</menu>
		<menu label="Help"
			image="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
			<menupopup>
				<menuitem label="Index"
					onClick="alert(self.label)" />
				<menu label="About">
					<menupopup>
						<menuitem label="About ZK"
							onClick="alert(self.label)" />
						<menuitem label="About Potix"
							onClick="alert(self.label)" />
					</menupopup>
				</menu>
			</menupopup>
		</menu>
		<menu
			image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
			<menupopup>
				<menuitem label="Index"
					onClick="alert(self.label)" />
				<menu label="Color Picker"
					content="#color=#184dc6" />
			</menupopup>
		</menu>
	</menubar>
</zk>

    """

    runZTL(zscript,
      () => {
        verifyTrue("Should see left/right arrow icons.", jq(".z-menubar-hor-left").width() != 0)
        verifyTrue("Should see left/right arrow icons.", jq(".z-menubar-hor-right").width() != 0)
      })

  }
}
