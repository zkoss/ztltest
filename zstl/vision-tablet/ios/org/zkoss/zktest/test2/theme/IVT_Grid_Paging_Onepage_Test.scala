package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Grid_Paging_Onepage_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<grid mold="paging" pageSize="5">
	<attribute name="onCreate">
		self.getPagingChild().setMold("os");
	</attribute>
	<columns menupopup="auto">
		<column label="Author"/>
		<column label="Title"/>
		<column label="Publisher"/>
		<column label="Hardcover"/>
	</columns>
	<rows>
		<row>
			<label value="Philip Hensher"/>
			<label value="The Northern Clemency"/>
			<label value="Knopf (October 30, 2008)"/>
			<label value="608 pages"/>
		</row>
		<row>
			<label value="Philip Hensher"/>
			<label value="The Fit"/>
			<label value="HarperPerennial (April 4, 2005)"/>
			<label value="240 pages"/>
		</row>
	</rows>
</grid>
			
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
