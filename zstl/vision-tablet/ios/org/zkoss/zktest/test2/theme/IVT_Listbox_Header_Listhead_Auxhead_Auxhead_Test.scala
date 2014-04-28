package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Listbox_Header_Listhead_Auxhead_Auxhead_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<listbox fixedLayout="true" width="900px">
	<listhead id="cs">
		<listheader label="Align Left" align="left" />
		<listheader label="Align Center" align="center"/>
		<listheader label="Align Right" align="right" />
	</listhead>
	<auxhead>
		<auxheader label="A+B" colspan="2" />
		<auxheader label="C" />
	</auxhead>
	<auxhead>
		<auxheader label="C"  />
		<auxheader label="D + E" colspan="2"/>
	</auxhead>
	<listitem>
		<listcell label="AA01" />
		<listcell label="BB01" />
		<listcell label="CC01" />
	</listitem>
	<listfoot>
		<listfooter label="footer 1" />
		<listfooter label="footer 2" />
		<listfooter label="footer 3" />
	</listfoot>
</listbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
