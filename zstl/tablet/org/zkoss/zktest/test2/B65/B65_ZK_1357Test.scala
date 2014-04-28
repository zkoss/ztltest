package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Touch,Android")
class B65_ZK_1357Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
		iPad/Android only 
		1. Click on menu1, you should see a alert.
		2. Click on arrow icon of menu1, you should see menupopup showed.
	</label>
	<menubar>
		<menu label="Menu1" onClick='alert("alert")'>
			<menupopup>
				<menu label="New">
					<menupopup>
						<menuitem label="Small Car" />
						<menuitem label="Mediem Car" />
						<menuitem label="Large Car" />
					</menupopup>
				</menu>
				<menuitem label="Search" />
			</menupopup>
		</menu>
		<menu label="Menu2">
			<menupopup>
				<menu label="New">
					<menupopup>
						<menuitem label="Small Car" />
						<menuitem label="Mediem Car" />
						<menuitem label="Large Car" />
					</menupopup>
				</menu>
				<menuitem label="Search" />
			</menupopup>
		</menu>
	</menubar>
</zk>
    """

    runZTL(zscript,
      () => {
        val menu1 = jq(".z-menu:contains(Menu1)")
        singleTap(menu1)
        waitResponse()
        verifyTrue("you should see a alert.", jq(".z-messagebox-window").exists())
        singleTapAt(menu1, 65, 15)
        waitResponse()
        verifyTrue("you should see a alert.", jq(".z-menupopup").css("display") != "none")
      })

  }
}
