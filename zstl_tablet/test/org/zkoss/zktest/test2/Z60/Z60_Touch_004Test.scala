package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.ZKTestCase

@Tags(tags = "Touch,Android")
class Z60_Touch_004Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = {
<zk>
	<div>
		Click on calendar button should not see native keyboard.
	</div>
	<vlayout spacing="30px">
		<datebox onChange='lbl.setValue("" + self.getValue())'/>
		<calendar onChange='lbl.setValue("" + self.getValue())'/>
		<label id="lbl" />
	</vlayout>
</zk>
		};
		
		runZTL(zscript,
			() => {
				var pageHeight = jq(".z-page").innerHeight();
				
				// Click on calendar button
				singleTap(jq(jq(".z-datebox").toWidget().$n("btn")));
				waitResponse(true);
				
				// calendar wheel should be visible
				var datebox_pp = jq(jq(".z-datebox").toWidget().$n("pp"));
				verifyTrue(datebox_pp.isVisible());

				// and should be at the bottom of screen (native keyboard should not appear)
				verifyTrue(pageHeight - (datebox_pp.positionTop() + datebox_pp.height()) < 10);
			}
		);
	}
}