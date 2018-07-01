package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Inputs_Bandbox_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<hbox vflex="min">
	<window title="Bandbox (Default mold)" sclass="center-bg-win"
		border="normal" width="300px">
		<vbox>
			Simple Bandbox:
			<bandbox>
				<bandpopup>
					Bandbox Content
				</bandpopup>
			</bandbox>
			<separator />
			Grid in Bandbox:
			<bandbox>
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
			<separator />
		</vbox>
	</window>
	<window title="Bandbox (Rounded mold)" sclass="center-bg-win"
		border="normal" width="300px">
		<vbox>
			Simple Bandbox:
			<bandbox mold="rounded">
				<bandpopup>
					Bandbox Content
				</bandpopup>
			</bandbox>
			<separator />
			Grid in Bandbox:
			<bandbox mold="rounded">
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
			<separator />
		</vbox>
	</window>
</hbox>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}