package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Listbox_Paging_Os_Bottom_Test extends ZTL4ScalaTestCase {
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
	listbox.setPagingPosition("bottom");
	listbox.getPagingChild().setMold("os");
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
