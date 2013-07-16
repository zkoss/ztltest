package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.By
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.HasTouchScreen
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_007Test extends ZTL4ScalaTestCase {
	@Test
  def testClick() {
		val zscript = """
<zk>
	<n:h3 xmlns:n="native">iPad/Android Only</n:h3>
	<vlayout>
		You should be able to close errorbox just click one time.
		<separator/>
		<intbox value="0" id="ibox" constraint="no zero"/>
	</vlayout>
</zk>""";
		
		runZTL(zscript,
			() => {
				// Focus on intbox and then lose the focus to enter the default value of 0
				singleTap(jq("@intbox"));
				singleTap(jq("@label"));
				waitResponse();

				// Since the non-zero constraint is not met, an error box should show.
				var errbox = jq(".z-errorbox");
				verifyTrue(errbox.isVisible());
				
				// Click once on 'X' should close the error box
				singleTap(errbox.toWidget().$n("cls"))
				waitResponse();
				
				verifyFalse(errbox.exists());
			}
		);
	}
}