package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Listbox_Grouping_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<listbox >
	<listhead menupopup="auto" >
		<listheader label="Brand" sort="auto" />
		<listheader label="Processor Type" sort="auto" width="225px"/>
		<listheader label="Memory (RAM)" sort="auto" width="180px"/>
		<listheader label="Price" sort="auto" width="150px"/>
		<listheader label="Hard Drive Capacity" sort="auto" width="225px"/>
	</listhead>
	<listgroup label="Dell"/>
	<listitem>
		<listcell label="Dell E4500 2.2GHz"/>
		<listcell label="Intel Core 2 Duo" />
		<listcell label="2GB RAM"/>
		<listcell label="$261.00"/>
		<listcell label="500GB"/>
	</listitem>
	<listitem>
		<listcell label="Dell P4 3.2 GHz" />
		<listcell label="Intel Pentium 4"/>
		<listcell label="4GB RAM"/>
		<listcell label="$377.99"/>
		<listcell label="500GB"/>
	</listitem>
	<listgroupfoot label="more about Dell"/>
	<listgroup label="Compaq"/>
	<listitem>
		<listcell style="padding-left:15px" label="Compaq SR5113WM"/>
		<listcell label="Intel Core Duo" />
		<listcell label="1GB RAM"/>
		<listcell label="$279.00" />
		<listcell label="160GB" />
	</listitem>
	<listfoot >
		<listfooter label="Summary"/>
	</listfoot>
</listbox>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Collapse list group
				singleTap(jq(".z-listgroup-img"));
				sleep(500);
				verifyImage();
			});
	}
}