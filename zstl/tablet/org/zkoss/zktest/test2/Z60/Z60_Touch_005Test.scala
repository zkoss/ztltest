package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_005Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
		val zscript = {
<zk>
	<div>
		Click on icon button should not see native keyboard.
	</div>
	<vlayout spacing="30px">
		<combobox onChange='lbl.setValue(self.getValue())'>
			<comboitem label="Item 1" />
			<comboitem label="Item 2" />
			<comboitem label="Item 3" />
		</combobox>
		<bandbox id="bd" width="300px">
			<bandpopup>
				<listbox width="200px" onSelect="bd.value=self.selectedItem.label; bd.close(); lbl.value=bd.value">
					<listhead>
						<listheader label="Name" />
						<listheader label="Description" />
					</listhead>
					<listitem>
						<listcell label="John" />
						<listcell label="CEO" />
					</listitem>
					<listitem>
						<listcell label="Joe" />
						<listcell label="Engineer" />
					</listitem>
					<listitem>
						<listcell label="Mary" />
						<listcell label="Supervisor" />
					</listitem>
				</listbox>
			</bandpopup>
		</bandbox>
		<label id="lbl" />
	</vlayout>
</zk>	
		};
		
		runZTL(zscript,
			() => {
				var pageHeight = jq(".z-page").innerHeight();
				
				// 1. Click on combobox button
				singleTap(jq(".z-combobox").toWidget().$n("btn"));
				waitResponse(true);
				
				// a popup should appear at the bottom of the screen
				var combobox_pp = jq(jq(".z-combobox").toWidget().$n("pp"));
				verifyTrue(combobox_pp.isVisible());
				
				verifyTrue(pageHeight - (combobox_pp.positionTop() + combobox_pp.height()) < 10);
								
				// Click on bandbox button
				singleTap(jq(".z-bandbox").toWidget().$n("btn"));
				waitResponse(true);
				
				// a dropdown should be visible
				var bandbox_pp = jq(jq(".z-bandbox").toWidget().$n("pp"));
				verifyTrue(bandbox_pp.isVisible());
			}
		);
	}
}