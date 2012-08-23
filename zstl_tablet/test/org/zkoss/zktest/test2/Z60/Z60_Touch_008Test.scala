package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Touch")
class Z60_Touch_008Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = {
// <?meta name="viewport" content="width=800"?>
<zk>
	<n:h3 xmlns:n="native">iPad/Android Only</n:h3>
	<vlayout>
		You should be able to download file.
		<separator/>
		<button label="Download sun.jpg">
			<attribute name="onClick">
			Filedownload.save("/img/sun.jpg", null);
			</attribute>
		</button>
	</vlayout>
</zk>
		};
		
		runZTL(zscript,
			() => {
				// Click button to start download
				click(jq("@button"));
				waitResponse();
				
				// Verify if download is successful
				
				driver().close();
			}
		);
	}
}