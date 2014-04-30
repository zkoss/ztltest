package org.zkoss.zktest.test2.F65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F65-ZK-2014.zul")
class F65_ZK_2014Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<label multiline="true">
	1. Click checkbox on Listheader.
	2. Should see button label changed accordingly.
	</label>
	<zscript><![CDATA[
	import org.zkoss.zktest.test2.grid.FakeListModel;
	FakeListModel model = new FakeListModel(200);
	model.setMultiple(true);
	]]></zscript>
	<listbox checkmark="true" multiple="true" width="350px" model="${model}" mold="paging" pageSize="5">
		<custom-attributes org.zkoss.zul.listbox.rod="false"/>
		<attribute name="onCheckSelectAll"><![CDATA[
			if (event.isChecked()) {
				btn.setLabel("Select All Checked");
			} else {
				btn.setLabel("Select All Un-Checked");
			}
		]]></attribute>
		<listhead>
			<listheader id="hd" label="col" />
		</listhead>
	</listbox>
	<button id="btn" label="button" />
</zk>
"""  
  runZTL(zscript,
    () => {
      click(jq(".z-listheader").toWidget().$n("cm"))
      waitResponse()
      
      verifyTrue("Should see button label changed accordingly.", jq(".z-button").text() == "Select All Checked")
    })
    
  }
}