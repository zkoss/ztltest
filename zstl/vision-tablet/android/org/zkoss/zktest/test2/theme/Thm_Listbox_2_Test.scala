package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Listbox_2_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>			
	<label value="Listbox with checkmarks" />
	<button label="Toggle checkmark" onClick="box.checkmark = !box.checkmark"/>
	<button label="Toggle multiple" onClick="box.multiple = !box.multiple"/>
	<listbox id="box" fixedLayout="true" multiple="true" checkmark="true">
		<listhead menupopup="auto">
			<listheader label="Name"/>
			<listheader label="Gender" sort="client"/>
			<listheader label="Age" sort="auto"/>
			<listheader label="Description"/>
		</listhead>
		<listitem>
			<listcell label="Mary"/>
			<listcell label="FEMALE"/>
			<listcell label="18"/>
			<listcell label="A young lady."/>
		</listitem>
		<listitem>
			<listcell label="John"/>
			<listcell label="MALE"/>
			<listcell label="20"/>
			<listcell label="A college student."/>
		</listitem>
		<listitem disabled="true">
			<listcell label="Jane"/>
			<listcell label="FEMALE"/>
			<listcell label="32"/>
			<listcell label="A remarkable artist."/>
		</listitem>
		<listitem disabled="true">
			<listcell>
				<a href="http://www.zkoss.org">ZK</a>
			</listcell>
			<listcell label="MALE"/>
			<listcell label="29"/>
			<listcell label="A graduate."/>
		</listitem>
	</listbox>	
	<separator/>
	Paging can be supported to locate at three position: Top, Bottom, and Both.
	<radiogroup
		onCheck="tree.pagingPosition = self.selectedItem.label;listbox.pagingPosition = self.selectedItem.label">
		<radio label="top" />
		<radio label="bottom" checked="true" />
		<radio label="both" />
	</radiogroup>
	<button label="Change Paging Mold">
		<attribute name="onClick">
		listbox.pagingChild.mold = "os".equals(listbox.pagingChild.mold) ? "default" : "os";
		</attribute>
	</button>
	<zscript>
	<![CDATA[
		public class BigList extends java.util.AbstractList {
			private int _sz;
			
			public BigList(int sz) {
				if (sz < 0)
					throw new IllegalArgumentException("Negative not allowed: "+sz);
				_sz = sz;
			}
			
			public int size() {
				return _sz;
			}
			
			public Object get(int j) {
				return new Integer(j);
			}
		}
			
		List items = new BigList(1000); // a big list of Integer
	]]>
	</zscript>
	<listbox id="listbox" mold="paging" pageSize="5">
		<listitem forEach="${items}">
			<listcell label="${each}-1"/>
			<listcell label="${each}-2"/>
			<listcell label="${each}-3"/>
			<listcell label="${each}-4"/>
		</listitem>
	</listbox>
	<listbox emptyMessage="This Listbox is empty.">
		<listhead>
			<listheader label="Col" />
		</listhead>
	</listbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Turn off checkmark
				singleTap(jq("@button:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Turn checkmark back on
				singleTap(jq("@button:eq(0)"));
				sleep(500);
				
				// Turn off multiple selection
				singleTap(jq("@button:eq(1)"));
				sleep(500);
				verifyImage();
				
				// Paging on Top
				singleTap(jq("input[type=radio]:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Paging on Both
				singleTap(jq("input[type=radio]:eq(2)"));
				sleep(500);
				verifyImage();
				
				// Paging back on Bottom
				singleTap(jq("input[type=radio]:eq(1)"));
				sleep(500);
				
				// Change Paging Mold
				singleTap(jq("@button:eq(2)"));
				sleep(500);
				verifyImage();
				
				// Switch to page 2
				singleTap(jq(".z-paging-os a:eq(1)"));
				sleep(500);
				verifyImage();
			});
	}
}