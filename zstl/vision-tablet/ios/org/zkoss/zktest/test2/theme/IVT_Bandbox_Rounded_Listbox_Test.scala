package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Bandbox_Rounded_Listbox_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<bandbox open="true" mold="rounded">
	<bandpopup>
		<vbox>
			<hbox>
				Search
				<textbox />
			</hbox>
			<listbox width="200px">
				<listhead>
					<listheader label="Name" />
					<listheader label="Description" />
				</listhead>
				<listitem>
					<listcell label="John" />
					<listcell label="CEO" />
				</listitem>
				<listitem>
					<listcell label="Joe" />
					<listcell label="Engineer" />
				</listitem>
				<listitem>
					<listcell label="Mary" />
					<listcell label="Supervisor" />
				</listitem>
			</listbox>
		</vbox>
	</bandpopup>
</bandbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
