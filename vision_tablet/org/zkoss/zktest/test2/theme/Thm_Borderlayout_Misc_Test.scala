package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Borderlayout_Misc_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<hbox>
		<window title="Simple Title" sclass="center-bg-win" 
			border="normal" width="300px" height="300px">
			<borderlayout>
				<center title="Center">
					Center Content
				</center>
				<north size="20%" title="North">
					North Content
				</north>
				<south size="20%" title="South">
					South Content
				</south>
				<east size="20%" title="East">
					East Content
				</east>
				<west size="20%" title="West">
					West Content
				</west>
			</borderlayout>
		</window>
		<window title="Simple" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<borderlayout>
				<center>
					Center Content
				</center>
				<north size="20%">
					North Content
				</north>
				<south size="20%">
					South Content
				</south>
				<east size="20%">
					East Content
				</east>
				<west size="20%">
					West Content
				</west>
			</borderlayout>
		</window>
		<window title="No Border" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<borderlayout>
				<center border="none">
					Center Content
				</center>
				<north size="20%" border="none">
					North Content
				</north>
				<south size="20%" border="none">
					South Content
				</south>
				<east size="20%" border="none">
					East Content
				</east>
				<west size="20%" border="none">
					West Content
				</west>
			</borderlayout>
		</window>
	</hbox>
	<separator />
	<hbox>
		<window title="Auto Scroll" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<borderlayout>
				<center autoscroll="true">
					<vbox>
						<label value="Center" />
						<label value="Content" />
						<label value="is" />
						<label value="very" />
						<label value="very" />
						<label value="very" />
						<label value="very" />
						<label value="very" />
						<label value="long" />
						<label value="long" />
						<label value="long" />
					</vbox>
				</center>
				<north size="20%">
					North Content
				</north>
				<south size="20%">
					South Content
				</south>
				<east size="20%">
					East Content
				</east>
				<west size="20%">
					West Content
				</west>
			</borderlayout>
		</window>
		<window title="Margins: 10px" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<borderlayout>
				<center margins="10,10,10,10">
					Center Content
				</center>
				<north size="20%">
					North Content
				</north>
				<south size="20%">
					South Content
				</south>
				<east size="20%">
					East Content
				</east>
				<west size="20%">
					West Content
				</west>
			</borderlayout>
		</window>
		<window title="Cmargins: 10px" sclass="center-bg-win"
			border="normal" width="300px" height="300px">
			<borderlayout>
				<center>
					Center Content
				</center>
				<north size="20%">
					North Content
				</north>
				<south size="20%">
					South Content
				</south>
				<east title="East" size="20%" collapsible="true" cmargins="10,10,10,10">
					East Content
				</east>
				<west title="West" size="20%" collapsible="true" cmargins="10,10,10,10">
					West Content
				</west>
			</borderlayout>
		</window>
	</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}