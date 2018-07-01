package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2040.zul")
class B65_ZK_2040Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<div>Test steps:</div>
	<div style="margin-left: 10px;">
		1. Right Click on 'Right Click' label to open menupopup.
	</div>
	<div style="margin-left: 10px;">
		2. Mouseover 'Group' to open sub Menupopup (should go left).
	</div>
	<div style="margin-left: 10px;">
		3. Mouseover 'Add to...' to open second sub Menupopup (should go
		left).
	</div>
	<vlayout>
		<div hflex="1">
			<div
				style="float: right; margin-right: 175px; padding: 5px; border: 2px solid green;">
				<label value="Right Click" context="editPopup" />
			</div>
			<div style="clear: both;"></div>
		</div>
	</vlayout>
	<menupopup id="editPopup">
		<menuitem label="Message" />
		<menuseparator />
		<menuitem label="Profile" />
		<menuitem
			image="http://www.zkoss.org/zkdemo/widgets/menu/context_menu/img/Envelope-16x16.png"
			label="Mail to" />
		<menuseparator />
		<menu
			image="http://www.zkoss.org/zkdemo/widgets/menu/context_menu/img/CasualUsers-16x16.png"
			label="Group">
			<menupopup>
				<menu label="Add to...">
					<menupopup>
						<menuitem label="Member" autocheck="true"
							checkmark="true" checked="true" />
						<menuitem label="Managers" autocheck="true"
							checkmark="true" />
						<menuitem label="Guest" autocheck="true"
							checkmark="true" />
						<menuitem label="Customers" autocheck="true"
							checkmark="true" />
					</menupopup>
				</menu>
				<menu label="Move to...">
					<menupopup>
						<menuitem label="Member" autocheck="true"
							checkmark="true" />
						<menuitem label="Managers" autocheck="true"
							checkmark="true" />
						<menuitem label="Guest" autocheck="true"
							checkmark="true" />
						<menuitem label="Customers" autocheck="true"
							checkmark="true" />
					</menupopup>
				</menu>
			</menupopup>
		</menu>
		<menuitem
			image="http://www.zkoss.org/zkdemo/widgets/menu/context_menu/img/CasualUserMaleProhibition-16x16.png"
			label="Reach me" />
		<menuitem label="Remove contant" />
	</menupopup>
</zk>"""  
  runZTL(zscript,
    () => {
      contextMenu(jq(".z-label:contains(Right Click)").eq(1))
      waitResponse()
      mouseOver(jq(".z-menu:contains(Group)"))
      waitResponse()
      mouseOver(jq(".z-menu:contains(Add to)"))
      waitResponse()
      verifyImage()
    })
    
  }
}