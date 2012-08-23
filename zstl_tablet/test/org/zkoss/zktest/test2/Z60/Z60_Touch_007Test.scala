package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Touch")
class Z60_Touch_007Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = {
// <?meta name="viewport" content="width=800"?>
<zk>
	<n:h3 xmlns:n="native">iPad/Android Only</n:h3>
	<vlayout>
		You should be able to close errorbox just click one time.
		<separator/>
		<intbox value="0" id="ibox" constraint="no zero"/>
	</vlayout>
</zk>	
		};
		
		runZTL(zscript,
			() => {
				// Focus on intbox and then lose the focus to enter the default value of 0
				focus(jq("@intbox"));
				blur(jq("@intbox"));
				waitResponse();

				// Since the non-zero constraint is not met, an error box should show.
				var errbox = jq(".z-errbox");
				verifyTrue(errbox.isVisible());
				
				// Click once on 'X' should close the error box
				clickAt(errbox, "248,12");
				waitResponse();
				
				verifyFalse(errbox.isVisible());
				
				
				driver().close();
			}
		);
	}
}