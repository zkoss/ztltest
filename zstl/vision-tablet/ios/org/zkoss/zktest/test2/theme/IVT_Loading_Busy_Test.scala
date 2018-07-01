package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Loading_Busy_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<div id="loading_div" width="100px" height="100px" style="border: 1px solid black">
		Dummy Div
	</div>
	
	<script defer="true"><![CDATA[
		var div = zk.Widget.$('$loading_div');
		zAu.cmd0.showBusy(div.uuid, 'loading');
	]]></script>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
