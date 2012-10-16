package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Progressmeter_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk xmlns:w="http://www.zkoss.org/2005/zk/client">
	<hbox>
		<window title="Progressmeter" border="normal" width="300px" height="300px">
			<vbox>
				Progressmeter:
				<progressmeter value="50" width="200px" />
			</vbox>
		</window>
		<window title="Progressmeter" border="normal" width="300px" height="300px">
			<vbox>
				Progressmeter: (You can try different value)
				<hbox spacing="0">
					<separator orient="vertical" spacing="7px" />
					<progressmeter id="pm" value="50" width="200px" />
					<separator orient="vertical" spacing="3px" />
					<label id="lb" value="50" />/100
				</hbox>
				<slider curpos="50">
					<attribute w:name="onScroll"><![CDATA[
						var pos = this.getCurpos();
						this.$f("pm").setValue(pos); 
						this.$f("lb").setValue(pos);
					]]></attribute>
				</slider>
			</vbox>
		</window>
	</hbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}