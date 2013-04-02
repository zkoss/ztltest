package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Chosenbox_Disabled_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<zscript>
	<![CDATA[
	    import org.zkoss.zul.*;
	    import org.zkoss.zkmax.zul.Chosenbox;
	    import java.util.*;
		ListModel model = new ListModelList(new String[] { 
				"Apple", "Banana", "Super Apple", "Super Banana", "Cantaloupe", 
				"Carambola", "Casaba", "Cascara", "Cherry", "Chestnut", "Coconut",
				"Codlin", "Core", "Cranberry", "Cumquat", "Damson", "Date", "Dew", 
				"Durian", "Casaba", "Cascara", "Cherry", "Chestnut", "Coconut", 
				"Codlin", "Core", "Cranberry", "Cumquat", "Damson", "Date", "Dew", 
				"Durian", "Fig", "Filbert", "Flat", "Foxnut", "Ginkgo", "Gooseberry",
		        "Grape", "Grapefruit", "Guava", "Haw", "Herbaceous", "Hickory",
		        "Honey-dew", "Juicy", "Kernel", "Kiwifruit", "Lemon", "Lichee",
		        "Longan", "Loquat", "Lotus", "Mandarin", "Mango", "Mangosteen",
		        "Marc", "Melon", "Mini", "Nectarine", "Newton", "Nucleus" });
		model.multiple = true;
		model.addToSelection("Apple");
		model.addToSelection("Banana");
	]]>
	</zscript>
	<chosenbox
		width="300px"
		creatable="true"
		model="${model}"
		onSelect=""
		disabled="true" />
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
