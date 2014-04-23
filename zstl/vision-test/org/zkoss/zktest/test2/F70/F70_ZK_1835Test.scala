package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-1835.zul")
class F70_ZK_1835Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window title="Navbar" border="normal" width="1120px" height="500px">
	You can change the navbar's orient and set it to be collapsed.
	<hlayout>
		<checkbox label="Vertical Orient">
			<attribute name="onCheck">
				nb.orient = self.checked ? "vertical" :  "horizontal";
			</attribute>
		</checkbox>
		<checkbox label="Collapsed">
			<attribute name="onCheck">
				nb.collapsed = self.checked ? true : false;
			</attribute>
		</checkbox>
	</hlayout>
		<navbar id="nb">
			<navitem label="Inbox" iconSclass="z-icon-inbox" />
			<navitem label="Create New Task" iconSclass="z-icon-pencil"/>
			<navseparator/>
			<nav label="Next Actions" iconSclass="z-icon-th-list" badgeText="4">
				<navitem label="Rescue the Baby" iconSclass="z-icon-star"/>
				<navitem label="Play Darts" />
				<navitem label="Plant Flowers" />
				<navitem label="Wash the Car" iconSclass="z-icon-star"/>
			</nav>
			<nav label="Someday" iconSclass="z-icon-tasks" badgeText="2">
				<navitem label="Say Hi to the Soldier"/>
				<navitem label="Hide and Seek" />
			</nav>
			<nav label="Done" iconSclass="z-icon-archive">
				<navitem label="Go to the Park" disabled="true"/>
				<navitem label="Badminton Game" disabled="true"/>
				<navitem label="Buy the Ticket" disabled="true"/>
				<navitem label="Return the U-Bike" disabled="true"/>
			</nav>
		</navbar>
</window>
"""  
  runZTL(zscript,
    () => {
      val col = jq(".z-checkbox:contains(Collapsed)")
      val ver = jq(".z-checkbox:contains(Vertical)")
      verifyImage()
      
      click(col)
      waitResponse()
      verifyImage()
      
      click(ver)
      waitResponse()
      verifyImage()
      
      click(col)
      waitResponse()
      verifyImage()
    })
    
  }
}