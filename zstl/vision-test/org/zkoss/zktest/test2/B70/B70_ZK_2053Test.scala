package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2053.zul")
class B70_ZK_2053Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<label multiline="true">
		clicked checkbox of title C,then each checkmark's position should be right.
	</label>
	<listbox id="a" checkmark="true"  multiple="true" >
		<custom-attributes org.zkoss.zul.listbox.groupSelect="true" />
		<custom-attributes org.zkoss.zul.listbox.rod="false" />
		<listhead>
			<listheader label="C" />
		</listhead>
		<listgroup label="A"/>
		<listitem>
			<listcell label="A1"/>
		</listitem>
		<listitem>
			<listcell label="A2" />
		</listitem>
		<listgroup label="B"/>
		<listitem>
			<listcell label="B1"/>
		</listitem>
		<listitem>
			<listcell label="B2"/>
		</listitem>
	</listbox>
    <label multiline="true">
		1.Group A,B shouldn't show checkmark
		2.clicked checkbox of multiple change ,then A1,A2,B1,B2 will show chackble
	</label>
	<listbox id ="b" checkmark="true"  multiple="false" >
		<custom-attributes org.zkoss.zul.listbox.rod="true" />
		<listhead menupopup="auto" >
			<listheader label="R" />
		</listhead>
		<listgroup label="A"/>
		<listitem>
			<listcell label="A1"/>
		</listitem>
		<listitem>
			<listcell label="A2" />
		</listitem>
		<listgroup label="B"/>
		<listitem>
			<listcell label="B1"/>
		</listitem>
		<listitem>
			<listcell label="B2"/>
		</listitem>
	</listbox>
	<checkbox label="multiple change">
	  <attribute name="onCheck">
		  a.setMultiple(self.isChecked());
		  b.setMultiple(self.isChecked());
	  </attribute>
	</checkbox>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
      click(jq(".z-listheader-checkable"))
      waitResponse()
      verifyImage()
      
      verifyTrue("Group A,B shouldn't show checkmark", !jq(".z-listbox:eq(1) .z-listheader-checkable").exists)
      click(jq(".z-checkbox"))
      waitResponse()
      
      verifyEquals("A1,A2,B1,B2 will show chackble", jq(".z-listbox:eq(1) .z-listitem-checkable").length(), 4)
    })
    
  }
}