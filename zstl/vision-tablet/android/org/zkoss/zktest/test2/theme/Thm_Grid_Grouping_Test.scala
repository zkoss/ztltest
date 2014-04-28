package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

@Tags(tags = "Android,VisionTest")
class Thm_Grid_Grouping_Test extends ZTL4ScalaTestCase {
	@Test
	def testClick() = {
		val zscript = """
<grid fixedLayout="true">
	<columns sizable="true">
		<column label="Brand" />
		<column label="Processor Type" width="150px"/>
		<column label="Memory (RAM)" width="120px"/>
		<column label="Price"  width="100px"/>
		<column label="Hard Drive Capacity" width="150px"/>
	</columns>
	<rows>
		<group label="Dell"/>
		<row>
			<label style="padding-left:15px" value="Dell E4500 2.2GHz"/>
			<label value="Intel Core 2 Duo"/>
			<label value="2GB RAM"/>
			<label value="$261.00" style="color:green"/>
			<label value="500GB"/>
		</row>
		<row>
			<label style="padding-left:15px" value="XP-Pro Slim Dell-Inspiron-530-s"/>
			<label value="Intel Core 2 Duo"/>
			<label value="2GB RAM"/>
			<label value="$498.93" style="color:green"/>
			<label value="500GB"/>				
		</row>
		<row>
			<label style="padding-left:15px" value="Dell P4 3.2 GHz"/>
			<label value="Intel Pentium 4"/>
			<label value="4GB RAM"/>
			<label value="$377.99" style="color:green"/>
			<label value="500GB"/>				
		</row>
		<group label="Compaq"/>
		<row>
			<label style="padding-left:15px" value="Compaq SR5113WM"/>
			<label value="Intel Core Duo"/>
			<label value="1GB RAM"/>
			<label value="$279.00" style="color:green"/>
			<label value="160GB"/>				
		</row>
		<row>
			<label style="padding-left:15px" value="Compaq HP XW4200"/>
			<label value="Intel Pentium 4"/>
			<label value="4GB RAM"/>
			<label value="$980" style="color:green"/>
			<label value="500GB"/>				
		</row>
		<groupfoot spans="5">
			<label value="This a summary about Compaq Desktop PCs"/>
		</groupfoot>
	</rows>
</grid>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				singleTap(widget(jq("@group:eq(0)")).$n("img"));
				verifyImage();
			});
	}
}