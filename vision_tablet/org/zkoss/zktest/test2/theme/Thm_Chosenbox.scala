package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Chosenbox extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk xmlns:n="native">
	<zscript><![CDATA[
		import org.zkoss.zul.*;
		import org.zkoss.zkmax.zul.Chosenbox;
		import java.util.*;
		
		ListModel model = new ListModelList(new String[] {
			"Apple", "Banana", "Super Apple", "Super Banana","Cantaloupe",
			"Carambola", "Casaba", "Cascara", "Cherry", "Chestnut",
			"Coconut", "Codlin", "Core", "Cranberry", "Cumquat",
			"Damson", "Date", "Dew", "Durian", "Casaba", "Cascara",
			"Cherry", "Chestnut", "Coconut", "Codlin", "Core", "Cranberry",
			"Cumquat", "Damson", "Date", "Dew", "Durian","Fig",
			"Filbert", "Flat", "Foxnut", "Ginkgo", "Gooseberry", "Grape",
			"Grapefruit", "Guava", "Haw", "Herbaceous", "Hickory", "Honey-dew",
			"Juicy", "Kernel", "Kiwifruit","Lemon", "Lichee", "Longan",
			"Loquat", "Lotus", "Mandarin", "Mango", "Mangosteen", "Marc",
			"Melon", "Mini", "Nectarine", "Newton", "Nucleus" 
		});
		model.multiple = true;
		model.addToSelection("Apple");
		model.addToSelection("Banana");
	]]></zscript>
	<n:table>
		<n:tr>
			<n:td>
				<label>Base</label>
			</n:td>
			<n:td>
				<chosenbox width="300px" creatable="true" model="${model}" onSelect="" 
					noResultsText="No Result" />
			</n:td>
		</n:tr>
		<n:tr>
			<n:td>
				<label>Disabled</label>
			</n:td>
			<n:td>
				<chosenbox width="300px" creatable="true" model="${model}" onSelect="" 
					disabled="true" />
			</n:td>
		</n:tr>
		<n:tr>
			<n:td>
				<label>No Model</label>
			</n:td>
			<n:td>
				<chosenbox width="300px" creatable="true" onSelect="" 
					noResultsText="No Result" createMessage="Create New" />
			</n:td>
		</n:tr>
	</n:table>		
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Remove 1st selected item
				singleTap(jq(".z-chosenbox-del-btn:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Show chosenbox popup
				singleTap(jq("@chosenbox:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Choose 1st item in the popup
				singleTap(jq(".z-chosenbox-option[style*=block]").eq(2));
				sleep(500);
				verifyImage();
				
				// Set focus to chosenbox with no model
				var nomodel = jq("@chosenbox:eq(2)")
				singleTap(nomodel);
				sleep(500);
				verifyImage();
				
				// Create new item
				keyPress(nomodel.find("input"), "abc");
				sleep(500);
				verifyImage();
			});
	}
}