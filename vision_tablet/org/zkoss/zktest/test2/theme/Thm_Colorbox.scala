package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Colorbox extends ZTL4ScalaTestCase {
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
    			<colorbox width="22px" height="12px" color="#FFFFFF">
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
				
				singleTap(jq(".z-colorbox-pp[style*=\"display: block\"] .z-colorpalette-ok-btn"));
				sleep(500);
				
				singleTap(jq("@menu:eq(0)"));
				sleep(500);
				singleTap(jq("@menu:eq(1)"));
				sleep(500);
				verifyImage();
				
				singleTap(jq(".z-colorpalette[style*=\"display: block\"] .z-colorpalette-ok-btn:eq(1)"));
				sleep(500);
				
				singleTap(jq("@colorbox:eq(1)"));
				sleep(500);
				verifyImage();
			});
	}
}