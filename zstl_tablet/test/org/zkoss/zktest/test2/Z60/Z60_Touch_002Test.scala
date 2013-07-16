package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.JQuery
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_002Test extends ZTL4ScalaTestCase {
	@Test
	def testClick() = {
		val zscript = {
<zk>
	<vlayout>
		<div>1. Collapsed West region</div>
		<div>2. Click collapsed bar, you should see west content</div>
	</vlayout>
	<borderlayout width="100%" height="100%">
		<west size="20%" title="west" collapsible="true" border="normal">
			<div hflex="true" vflex="true">WEST</div>
		</west>
		<center></center>
	</borderlayout>
</zk>		
		};
		
		runZTL(zscript, 
			() => {
				// 1. Collapse west region
				singleTap(jq(".z-west").toWidget().$n("btn"));
				waitResponse(true);
				sleep(1000);
				
				// 2. Click on collapsed bar
				singleTap(jq(".z-west-collapsed"));
				waitResponse(true);
				
				// West region should be visible
				verifyTrue(jq(".z-west").isVisible());
			}
		);
		
	}
}