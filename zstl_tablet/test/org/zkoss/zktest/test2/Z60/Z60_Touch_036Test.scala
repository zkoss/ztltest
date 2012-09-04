package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Touch")
class Z60_Touch_036Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = """
<borderlayout>
	<center autoscroll="true">
		<div style="padding:3px; background:red;" hflex="1" vflex="1">Should see the div region in red background</div>
	</center>
</borderlayout>""";
		
		runZTL(zscript,
			() => {
				var region_bgcolor = jq(".z-center-body > div").eq(0).css("background-color");
				verifyEquals("rgb(255, 0, 0)", region_bgcolor);
			}
		);
	}
}