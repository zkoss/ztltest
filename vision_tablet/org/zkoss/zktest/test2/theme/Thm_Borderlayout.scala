package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Borderlayout extends ZTL4ScalaTestCase {
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
				singleTap(jq(".z-north-colps"));
				waitForCondition(jq(".z-north-exp").toString(), "1000");
				verifyImage();
				
				// Collapse east
				singleTap(jq(".z-east-colps"));
				waitForCondition(jq(".z-east-exp").toString(), "1000");
				verifyImage();
				
				// Collapse south
				singleTap(jq(".z-south-colps"));
				waitForCondition(jq(".z-south-exp").toString(), "1000");
				verifyImage();

				// Collapse west
				singleTap(jq(".z-west-colps"));
				waitForCondition(jq(".z-west-exp").toString(), "1000");
				verifyImage();
			});
	}
}
