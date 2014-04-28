package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Listbox_Header_Auxhead_Listhead_Auxhead_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<listbox width="900px" fixedLayout="true">
	<auxhead>
		<auxheader label="A+B" colspan="2" />
		<auxheader label="C" />
	</auxhead>
	<listhead id="cs">
		<listheader label="Align Left" align="left" />
		<listheader label="Align Center" align="center"/>
		<listheader label="Align Right" align="right" />
	</listhead>
	<auxhead>
		<auxheader label="C+D" colspan="2" />
		<auxheader label="E" />
	</auxhead>
	<listitem>
		<listcell label="AA01" />
		<listcell label="BB01" />
		<listcell label="CC01" />
	</listitem>
	<listfoot>
		<listfooter label="footer 1" />
		<listfooter label="image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
		<listfooter label="image" image="/img/Centigrade-Widget-Icons/BookBlue-16x16.png" hoverImage="/img/Centigrade-Widget-Icons/BookGreen-16x16.png"/>
	</listfoot>
</listbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
