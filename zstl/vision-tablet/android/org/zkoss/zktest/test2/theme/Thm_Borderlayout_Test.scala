package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.junit.Test

@Tags(tags = "Android,VisionTest")
class Thm_Borderlayout_Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
		val zscript = """
<zk>
	<borderlayout>
		<center>
			<label multiline="true">
			Center Content
			</label>
		</center>
		<west title="West" size="20%" splittable="true" collapsible="true">
			West Content
		</west>
		<east title="East" size="20%" splittable="true" collapsible="true">
			East Content
		</east>
		<north title="North" size="20%" splittable="true" collapsible="true">
			North Content
		</north>
		<south title="South" size="20%" splittable="true" collapsible="true">
			South Content
		</south>
	</borderlayout>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Collapse north
				singleTap(jq(".z-north").toWidget().$n("btn"));
				waitForCondition(jq(".z-north").toWidget().$n("btned").toString(), "1000");
				verifyImage();
				
				// Collapse east
				singleTap(jq(".z-east").toWidget().$n("btn"));
				waitForCondition(jq(".z-east").toWidget().$n("btned").toString(), "1000");
				verifyImage();
				
				// Collapse south
				singleTap(jq(".z-south").toWidget().$n("btn"));
				waitForCondition(jq(".z-south").toWidget().$n("btned").toString(), "1000");
				verifyImage();

				// Collapse west
				singleTap(jq(".z-west").toWidget().$n("btn"));
				waitForCondition(jq(".z-west").toWidget().$n("btned").toString(), "1000");
				verifyImage();
			});
	}
}
