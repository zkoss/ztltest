package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Notification_Warning_Closable_After_Pointer_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<zscript>
	<![CDATA[
	import org.zkoss.zk.ui.util.Clients;
	import org.zkoss.zk.ui.Component;
	
	String msg = "Use the force, Harry.";
	String type = Clients.NOTIFICATION_TYPE_WARNING;
	Component ref = null;
	String pval = "after_pointer";
	int dur = -1;
	boolean closable = true;
	
	Clients.showNotification(msg, type, ref, pval, dur, closable);
	]]>
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
