package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Inputs_Combobox extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<window title="Combobox (default mold)" sclass="center-bg-win"
	border="normal" width="300px">
	<vbox>
		Simple Combobox:
		<combobox>
			<comboitem label="Comboitem 1" />
			<comboitem label="Comboitem 2" />
			<comboitem label="Comboitem 3" />
		</combobox>
		<separator />
		Comboitem with description:
		<combobox>
			<comboitem label="Comboitem 1" description="Description of the great Comboitem 1." />
			<comboitem label="Comboitem 2" description="Description of the great Comboitem 2." />
			<comboitem label="Comboitem 3" description="Description of the great Comboitem 3." />
		</combobox>
		<separator />
		Comboitem with icon:
		<combobox>
			<comboitem label="Comboitem 1" image="/img/search.png" />
			<comboitem label="Comboitem 2" image="/img/search.png" />
		<comboitem label="Comboitem 3" image="/img/search.png" />
		</combobox>
		<separator />
		Comboitem with description and icon:
		<combobox>
			<comboitem label="Comboitem 1" image="/img/search.png" 
				description="Description of the great Comboitem 1." />
			<comboitem label="Comboitem 2" image="/img/search.png" 
				description="Description of the great Comboitem 2." />
			<comboitem label="Comboitem 3" image="/img/search.png" 
				description="Description of the great Comboitem 3." />
		</combobox>
	</vbox>
</window>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Open 1st combobox
				singleTap(jq(".z-combobox-btn:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Open 2nd combobox
				singleTap(jq(".z-combobox-btn:eq(1)"));
				sleep(500);
				verifyImage();

				// Open 3rd combobox
				singleTap(jq(".z-combobox-btn:eq(2)"));
				sleep(500);
				verifyImage();
				
				// Open 4th combobox
				singleTap(jq(".z-combobox-btn:eq(3)"));
				sleep(500);
				verifyImage();
			});
	}
}