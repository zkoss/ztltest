package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Touch,Android")
class Z60_Touch_013Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = {
<zk>
	<vlayout>
		Support HTML5 input type:<separator spacing="0" />
		<hlayout>1. number: intbox <intbox /></hlayout>
		<hlayout>2. number: doublebox <doublebox /></hlayout>
		<hlayout>3. tel: textbox <textbox type="tel" /></hlayout>
		<hlayout>4. email: textbox <textbox type="email" /></hlayout>
		<hlayout>5. url: textbox <textbox type="url" /></hlayout>
	</vlayout>
</zk>			
		};
		
		runZTL(zscript,
			() => {
				// Verify the HTML5 input types are supported
				verifyTrue(jq("input.z-intbox[type=\"number\"]").isVisible());
				verifyTrue(jq("input.z-doublebox[type=\"number\"]").isVisible());
				verifyTrue(jq("input.z-textbox[type=\"tel\"]").isVisible());
				verifyTrue(jq("input.z-textbox[type=\"email\"]").isVisible());
				verifyTrue(jq("input.z-textbox[type=\"url\"]").isVisible());
			}
		);
	}
}