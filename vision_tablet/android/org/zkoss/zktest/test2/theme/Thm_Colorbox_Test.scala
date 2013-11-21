package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

@Tags(tags = "Android,VisionTest")
class Thm_Colorbox_Test extends ZTL4ScalaTestCase {
	@Test
	def testClick() = {
		val zscript = """
<hbox>
    <window title="Colorbox" sclass="center-bg-win"
    	border="normal" width="300px" height="300px" >
    	<colorbox />
    </window>
    <window title="Colorbox inside menu" sclass="center-bg-win"
    	border="normal" width="300px" height="300px">
    	<menubar id="menubar" width="100%">
    		<menu image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
    			<menupopup>
    				<menuitem label="Index" onClick="alert(self.label)" />
    				<menu label="Color Picker" content="#color=#184dc6"/>
    			</menupopup>
    		</menu>
    	</menubar>
    </window>
    <window title="colorbox in toolbar" sclass="center-bg-win"
    	border="normal" width="300px" height="300px" >
    	<hbox height="100%" align="stretch">
    		<toolbar orient="vertical" width="38px" height="100%">
    			<colorbox width="30px" height="20px" color="#FFFFFF">
    			</colorbox>
    		</toolbar>
    	</hbox>
    </window>
</hbox>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				singleTap(jq("@colorbox:eq(0)"));
				sleep(500);
				verifyImage();
				
				singleTap(jq(".z-colorbox-popup[style*=block] .z-colorbox-paletteicon"));
				sleep(500);
				
				singleTap(jq("@menu:eq(0)"));
				sleep(500);
				singleTap(jq("@menu:eq(1)"));
				sleep(500);
				verifyImage();
				
				singleTap(jq(".z-colorbox-popup[style*=block] .z-colorbox-paletteicon"));
				sleep(500);
				
				singleTap(jq("@colorbox:eq(1)"));
				sleep(500);
				verifyImage();
			});
	}
}