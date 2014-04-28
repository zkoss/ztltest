package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Listbox_Livedata_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<zscript>
		import org.zkoss.zul.ListModel;
		
		ListModel strset = new org.zkoss.zkdemo.userguide.FakeListModel(20);
	</zscript>
	<listbox id="list" width="200px" rows="5" model="${strset}">
		<listhead>
			<listheader label="Load on Demend" sort="auto"/>
		</listhead>
	</listbox>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
