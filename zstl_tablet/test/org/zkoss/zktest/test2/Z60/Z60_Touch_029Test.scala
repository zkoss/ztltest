package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_029Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() {
		val zscript = {
<zk xmlns:n="native">
	<n:h3>iPad/Android only</n:h3>
	<div>
		1. Click on chosenbox to show drop-down list. <separator />
		2. Should be able to scroll the drop-down list.
	</div>
	<zscript><![CDATA[
	import org.zkoss.zktest.test2.select.models.ListModelLists;
	import org.zkoss.zul.*;
	ListModelList model = ListModelLists.getModel(ListModelLists.MULTIPLE);
	]]></zscript>
	<chosenbox width="240px" model="${model}" separator=",./" />
</zk>			
		};
		
		runZTL(zscript,
			() => {
				singleTap(jq("@chosenbox"));
				waitResponse(true);
				
				var pp = jq(jq(".z-chosenbox").toWidget().$n("pp"));
				verifyTrue(pp.isVisible());
				
				var pp_scroller = pp.find("> div:last-child");
				verifyEquals(1, pp_scroller.length());
			}
		);
	}
}