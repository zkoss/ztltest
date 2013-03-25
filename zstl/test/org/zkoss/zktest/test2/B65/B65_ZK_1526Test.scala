package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1526.zul")
class B65_ZK_1526Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	Should not see any gray background showed.
	<vlayout style="background:gray;" hflex="min" vflex="min">
		<label style="background:cyan;" value="bottom padding due to menupopup" context="someMenuPopup1" />
		<menupopup id="someMenuPopup1">
			<menuitem label="Some Action" />
		</menupopup>
	</vlayout>
	<separator />
	<hlayout style="background:gray;" hflex="min" vflex="min">
		<label style="background:cyan;" value="bottom padding due to menupopup" context="someMenuPopup2" />
		<menupopup id="someMenuPopup2">
			<menuitem label="Some Action" />
		</menupopup>
	</hlayout>
	<separator />
	<vbox style="background:gray;" hflex="min" vflex="min">
		<label style="background:cyan;" value="bottom padding due to menupopup" context="someMenuPopup3" />
		<menupopup id="someMenuPopup3">
			<menuitem label="Some Action" />
		</menupopup>
	</vbox>
	<separator />
	<hbox style="background:gray;" hflex="min" vflex="min">
		<label style="background:cyan;" value="bottom padding due to menupopup" context="someMenuPopup4" />
		<menupopup id="someMenuPopup4">
			<menuitem label="Some Action" />
		</menupopup>
	</hbox>
</zk>
    """

    runZTL(zscript,
      () => {
        verifyTrue("Should not see any gray background showed.", jq(".z-vlayout").width() == jq(".z-vlayout .z-label").width())
        verifyTrue("Should not see any gray background showed.", jq(".z-vlayout").height() == jq(".z-vlayout .z-label").height())
        verifyTrue("Should not see any gray background showed.", jq(".z-hlayout").width() == jq(".z-hlayout .z-label").width())
        verifyTrue("Should not see any gray background showed.", jq(".z-hlayout").height() == jq(".z-hlayout .z-label").height())
        verifyTrue("Should not see any gray background showed.", jq(".z-vbox").width() == jq(".z-vbox .z-label").width())
        verifyTrue("Should not see any gray background showed.", jq(".z-vbox").height() == jq(".z-vbox .z-label").height())
        verifyTrue("Should not see any gray background showed.", jq(".z-hbox").width() == jq(".z-hbox .z-label").width())
        verifyTrue("Should not see any gray background showed.", jq(".z-hbox").height() == jq(".z-hbox .z-label").height())
      })

  }
}
