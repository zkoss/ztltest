package org.zkoss.zktest.test2.Z60
import org.openqa.selenium.By
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Touch,Android")
class Z60_Touch_030Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = {
<zk xmlns:n="native" xmlns:a="client/attribute">
	<n:h3>iPad/Android only</n:h3>
	<div>
	1. Swipe left/right/up/down inside the tabpanel <separator />
	2. Should see Swipe information showed
	</div>
	<tabbox height="300px" width="300px" a:data-swipeable="true">
		<tabs>
			<tab label="tab 1" />
		</tabs>
		<tabpanels>
			<tabpanel>
				<attribute name="onSwipe"><![CDATA[
					SwipeEvent se = (SwipeEvent) event;
					lbl1.setValue("Horizontal: " + se.getSwipeX() + "px");
					lbl2.setValue("Vertical: " + se.getSwipeY() + "px");
					lbl3.setValue("Duration: " + se.getSwipeDuration() + " milliseconds");
					lbl4.setValue("Direction: " + se.getSwipeDirection());
				]]></attribute>
				<vlayout>
					Swipe information
					<label id="lbl1"/>
					<label id="lbl2"/>
					<label id="lbl3"/>
					<label id="lbl4"/>
				</vlayout>
			</tabpanel>
		</tabpanels>
	</tabbox>
</zk>
		};
		
		runZTL(zscript,
			() => {
				var tabpanel = jq(".z-tabpanel");
				val SWIPE_DISTANCE = 50;
				
				// ----------------------------------------------------------------------
				swipeLeft(tabpanel, SWIPE_DISTANCE);
				waitResponse(true);
				
				var horizontal = jq("$lbl1").text()
									.replaceFirst("Horizontal: ", "")
									.replaceFirst("px", "").toInt;
				var vertical   = jq("$lbl2").text()
									.replaceFirst("Vertical: ", "")
									.replaceFirst("px", "").toInt;
				var direction  = jq("$lbl4").text()
									.replaceFirst("Direction: ", "");
				
				verifyEquals(SWIPE_DISTANCE, horizontal);
				verifyEquals(0, vertical);
				verifyEquals("left", direction);

				// ----------------------------------------------------------------------
				swipeRight(tabpanel, SWIPE_DISTANCE);
				waitResponse(true);
				
				horizontal = jq("$lbl1").text()
								.replaceFirst("Horizontal: ", "")
								.replaceFirst("px", "").toInt;
				vertical   = jq("$lbl2").text()
								.replaceFirst("Vertical: ", "")
								.replaceFirst("px", "").toInt;
				direction  = jq("$lbl4").text()
								.replaceFirst("Direction: ", "");
				
				verifyEquals(SWIPE_DISTANCE, horizontal);
				verifyEquals(0, vertical);
				verifyEquals("right", direction);

				// ----------------------------------------------------------------------
				swipeUp(tabpanel, 50);
				waitResponse(true);

				horizontal = jq("$lbl1").text()
								.replaceFirst("Horizontal: ", "")
								.replaceFirst("px", "").toInt;
				vertical   = jq("$lbl2").text()
								.replaceFirst("Vertical: ", "")
								.replaceFirst("px", "").toInt;
				direction  = jq("$lbl4").text()
								.replaceFirst("Direction: ", "");
				
				verifyEquals(0, horizontal);
				verifyEquals(SWIPE_DISTANCE, vertical);
				verifyEquals("up", direction);

				// ----------------------------------------------------------------------
				swipeDown(tabpanel, 50);
				waitResponse(true);

				horizontal = jq("$lbl1").text()
								.replaceFirst("Horizontal: ", "")
								.replaceFirst("px", "").toInt;
				vertical   = jq("$lbl2").text()
								.replaceFirst("Vertical: ", "")
								.replaceFirst("px", "").toInt;
				direction  = jq("$lbl4").text()
								.replaceFirst("Direction: ", "");
				
				verifyEquals(0, horizontal);
				verifyEquals(SWIPE_DISTANCE, vertical);
				verifyEquals("down", direction);
			}
		);
	}
}