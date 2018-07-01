package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_012Test extends ZTL4ScalaTestCase {
	@Test
  def testClick() {
		val zscript = """
<zk>
	<zscript><![CDATA[
		int i = 0;
		public void doClick() {
			new Label("Click " + ++i + " time").setParent(vlayout);
		}
	]]></zscript>
	<n:h3 xmlns:n="native">iPad/Android</n:h3>
	<vlayout>
		<hlayout valign="middle">
			1. Click on <button label="Button" onClick="doClick()" mold="os"/> one time.
		</hlayout>
		2. You should only see "Click 1 time" message. If you see two messages, it is a bug.
		<vlayout id="vlayout" />
	</vlayout>
</zk>			
		};
		
		runZTL(zscript,
			() => {
				// Click on button one time
				singleTap(jq("@button"));
				waitResponse();
				
				// Should only see "Click xx time" message once
				verifyEquals(1, jq("$vlayout").find("@label").length());
			}
		);
	}
}