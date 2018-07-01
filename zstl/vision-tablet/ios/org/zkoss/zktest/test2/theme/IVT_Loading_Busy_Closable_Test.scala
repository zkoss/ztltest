package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Loading_Busy_Closable_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk xmlns:w="client">
	<style>
	span.loading-btn {
		border: 1px solid #669999;
		border-radius: 3px; 
		-moz-border-radius: 3px; 
		-webkit-border-radius: 3px; 
		color: #669999;
		cursor: pointer !important;
	}
	</style>
	<script>
	zAu.cmd0.showBusy('loading <span class="loading-btn" onClick="zAu.cmd0.clearBusy()">Close</span>');
	</script>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
