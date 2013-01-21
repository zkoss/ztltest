package org.zkoss.zktest.test2.theme.ipad;

import org.zkoss.zstl.ZTL4ScalaTestCase;
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Listbox_Paging_Default_Top_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<zscript>
		import java.util.List;
		
		List items = new org.zkoss.zkdemo.userguide.BigList(50); 
	</zscript>
	<listbox id="listbox" mold="paging" pageSize="5">
		<listitem forEach="${items}">
			<listcell label="${each}-1"/>
			<listcell label="${each}-2"/>
			<listcell label="${each}-3"/>
			<listcell label="${each}-4"/>
		</listitem>
	</listbox>
	
	<zscript>
	listbox.setPagingPosition("top");
	listbox.getPagingChild().setMold("default");
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
