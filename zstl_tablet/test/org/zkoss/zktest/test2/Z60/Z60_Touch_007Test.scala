package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.By
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.interactions.HasTouchScreen

@Tags(tags = "Touch,Android")
class Z60_Touch_007Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = """
<zk>
	<n:h3 xmlns:n="native">iPad/Android Only</n:h3>
	<vlayout>
		You should be able to close errorbox just click one time.
		<separator/>
		<intbox value="0" id="ibox" constraint="no zero"/>
	</vlayout>
</zk>""";
		
		runZTL(zscript,
			() => {
				// Focus on intbox and then lose the focus to enter the default value of 0
				singleTap(jq("@intbox"));
				singleTap(jq("@label"));
				waitResponse();

				// Since the non-zero constraint is not met, an error box should show.
				var errbox = jq(".z-errbox");
				verifyTrue(errbox.isVisible());
				
				// Click once on 'X' should close the error box
				var errbox_close  = findElement(By.className("z-errbox-close"));
				var close_topleft = 
					errbox_close.asInstanceOf[Locatable].getCoordinates().getLocationOnScreen();
				var close_width   = errbox_close.getSize().getWidth();
				
				var close_x = close_topleft.getX() + close_width - 5;
				var close_y = close_topleft.getY() + 5;
				
				var touch = driver().asInstanceOf[HasTouchScreen].getTouch();
				touch.down(close_x, close_y);
				touch.up(close_x, close_y);
				waitResponse();
				
				verifyFalse(errbox.exists());
			}
		);
	}
}