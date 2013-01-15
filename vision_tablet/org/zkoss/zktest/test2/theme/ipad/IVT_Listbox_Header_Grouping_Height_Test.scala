package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Listbox_Header_Grouping_Height_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<listbox fixedLayout="true" width="900px" height="200px">
	<listhead sizable="true">
		<listheader label="Brand" />
		<listheader label="Price"  width="100px"/>
		<listheader label="Hard Drive Capacity" width="150px"/>
	</listhead>
	<listgroup label="Dell" />
	<listitem>
		<listcell label="Dell E4500 2.2GHz"/>
		<listcell label="$261.00" />
		<listcell label="500GB"/>
	</listitem>
	<listitem>
		<listcell label="XP-Pro Slim Dell-Inspiron-530-s"/>
		<listcell label="$498.93" />
		<listcell label="500GB"/>				
	</listitem>
	<listitem>
		<listcell label="Dell P4 3.2 GHz"/>
		<listcell label="$377.99" />
		<listcell label="500GB"/>				
	</listitem>
	<listgroup label="Compaq"/>
	<listitem>
		<listcell label="Compaq SR5113WM"/>
		<listcell label="$279.00" />
		<listcell label="160GB"/>				
	</listitem>
	<listitem>
		<listcell label="Compaq HP XW4200"/>
		<listcell label="$980"/>
		<listcell label="500GB"/>				
	</listitem>
	<listgroupfoot>
		<listcell label="cell in groupfoot"/>
		<listcell label=""/>
		<listcell label=""/>
	</listgroupfoot>
</listbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
