package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1714.zul")
class B65_ZK_1714Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<zk>
	<label multiline="true">
		1. Click "set selected item" button.
		2. Click "clear selected item" button.
		3. Should see "null" label showed.
	</label>
	<window>
		<zscript><![CDATA[
			class Data {
				private List list;
				private String selItem;
				
				public Data() {
					list = new ArrayList();
					list.add("Item 1");
					list.add("Item 2");
					list.add("Item 3");
				}
				
				public List getList() {
					return list;
				}
				
				public String getSelItem() {
					return selItem;
				}
				public void setSelItem(String selItem) {
					this.selItem =  selItem;
				}
			}
			Data data = new Data();
		]]></zscript>
		<listbox id="lbx" width="150px" model="@{data.list}" selectedItem="@{data.selItem}">
			<listitem label="@{each}"/>
		</listbox>
		<button label="set selected item">
			<attribute name="onClick"><![CDATA[
				data.setSelItem("Item 1");
				binder.loadAll();
				lbl.setValue("" + lbx.getSelectedItem());
			]]></attribute>
		</button>
		<button label="clear selected item">
			<attribute name="onClick"><![CDATA[
				data.setSelItem(null);
				binder.loadAll();
				lbl.setValue("" + lbx.getSelectedItem());
			]]></attribute>
		</button>
		<label id="lbl" />
	</window>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button:contains(set selected)"))
      waitResponse()
      
      click(jq(".z-button:contains(clear selected)"))
      waitResponse()
      
      verifyTrue("Should see 'null' label showed.", jq(".z-label:contains(null)").exists)
    })
    
  }
}