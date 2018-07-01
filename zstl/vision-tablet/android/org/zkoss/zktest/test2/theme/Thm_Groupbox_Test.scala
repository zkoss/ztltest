package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Groupbox_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<hbox>
		<groupbox width="300px" height="300px">
			<caption image="/img/volumn.gif" label="Caption" />
			Groupbox Content	
		</groupbox>
		<groupbox width="300px" height="300px">
			<caption label="Caption" />
			Groupbox Content	
		</groupbox>
	</hbox>
	<separator />
	<hbox>
		<groupbox width="300px" height="300px">
			<caption image="/img/volumn.gif" />
			Groupbox Content	
		</groupbox>
		<groupbox width="300px" height="300px">
			Groupbox Content	
		</groupbox>
	</hbox>
	<separator />
	Note: we kept the original design, which uses native fieldset and caption html element.
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
