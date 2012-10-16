package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Loading_Test extends ZTL4ScalaTestCase {
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
	<div style="position: absolute; z-index: 50">
		<div id="loading_div" width="100px" height="100px" style="border: 1px solid black">
			Dummy Div
		</div>
		<separator />
		<div width="100px" height="100px" style="border: 1px solid #888888">
			Renderer Defer: <span renderdefer="500000">Done</span>
		</div>
		<separator />
		<button label="Show Busy (Global)">
			<attribute w:name="onClick"><![CDATA[
				zAu.cmd0.showBusy('loading <span class="loading-btn" onClick="zAu.cmd0.clearBusy()">Close</span>');
			]]></attribute>
		</button>
	</div>
	<script defer="true"><![CDATA[
		var div = zk.Widget.$('$loading_div');
		zAu.cmd0.showBusy(div.uuid, 'loading');
	]]></script>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				singleTap(jq("@button"));
				sleep(500);
				verifyImage();
			});
	}
}