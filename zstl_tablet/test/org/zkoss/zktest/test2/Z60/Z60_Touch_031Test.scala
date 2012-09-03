package org.zkoss.zktest.test2.Z60
import org.openqa.selenium.By
import org.openqa.selenium.Rotatable
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.ScreenOrientation

@Tags(tags = "Touch,Android")
class Z60_Touch_031Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = {
<zk xmlns:n="native">
	<n:h3>iPad/Android only</n:h3>
	<div>
		1. Change tablet's orientation.<separator />
		2. The height and width of the tabbox should changed.<separator />
		3. Height should be larger than width when orientation is portrait.
	</div>
	<tabbox id="tbx" height="400px" width="600px">
		<attribute name="onClientInfo"><![CDATA[
			ClientInfoEvent oe = (ClientInfoEvent) event;
			String orient = oe.getOrientation();
			lbl.setValue(orient);
			lbl2.setValue("" + oe.getDevicePixelRatio());
			if (orient.equals("portrait")) {
				tbx.setHeight("600px");
				tbx.setWidth("400px");
			} else {
				tbx.setHeight("400px");
				tbx.setWidth("600px");
			}
		]]></attribute>
		<tabs>
			<tab label="tab 1" />
		</tabs>
		<tabpanels>
			<tabpanel>
				Current Orientation: <label id="lbl"/><separator />
				Current Device Pixel Ratio: <label id="lbl2"/>
			</tabpanel>
		</tabpanels>
	</tabbox>
</zk>			
		};
		
		runZTL(zscript,
			() => {
				ensureLandscape();
				waitResponse(true);
				sleep(2000);
				
				var tabbox = jq(".z-tabbox");
				
				verifyEquals("landscape", getOrientation());
				verifyEquals(400, tabbox.height());
				verifyEquals(600, tabbox.width());

				rotate();
				waitResponse(true);
				sleep(2000);
				
				verifyEquals("portrait", getOrientation());
				verifyEquals(600, tabbox.height());
				verifyEquals(400, tabbox.width());
				
				ensureLandscape();
				waitResponse(true);
				sleep(2000);
			}
		);
	}
}
