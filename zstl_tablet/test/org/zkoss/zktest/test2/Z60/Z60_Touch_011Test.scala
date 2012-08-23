package org.zkoss.zktest.test2.Z60
import org.openqa.selenium.interactions.internal.Coordinates
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.By
import org.openqa.selenium.HasTouchScreen
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Point
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.touch.FlickAction

@Tags(tags = "Touch")
class Z60_Touch_011Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = {
<zk>
	<vlayout width="100%" height="100%">
		1. Should see scroll bar on inside Listbox and Grid components.<separator spacing="0"/>
		2. Scroll down on Listbox and Grid, should see more items under option 50 and won't jump back.
		<zscript><![CDATA[
			org.zkoss.zul.ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(300);
		]]></zscript>
		<hlayout hflex="1" vflex="1">
			<listbox hflex="1" vflex="1" model="${strset}">
				<custom-attributes org.zkoss.zul.listbox.rod="true"/>
				<listhead>
					<listheader label="Listbox" />
				</listhead>
			</listbox>
			<grid hflex="1" vflex="1" model="${strset}">
				<custom-attributes org.zkoss.zul.grid.rod="true"/>
				<columns>
					<column label="Grid" />
				</columns>
			</grid>
		</hlayout>
	</vlayout>
</zk>			
		};
		
		runZTL(zscript,
			() => {
				var driver = this.driver();
				var touch  = driver.asInstanceOf[HasTouchScreen].getTouch();
				var coords   : Coordinates = null;
				var location : Point       = null;
				
				var scroll_outer : WebElement = null;
				var scroll_bar   : WebElement = null;
				
				// Check existence of scroll bar for listbox
				var listbody    = findElement(By.className("z-listbox-body"));
				
				scroll_outer = findElement(By.cssSelector(".z-listbox-body > div:last-child"));
				scroll_bar   = scroll_outer.findElement(By.cssSelector("div"));
				verifyEquals("0", scroll_outer.getCssValue("opacity"));

				// Scroll down on listbox
				coords   = listbody.asInstanceOf[Locatable].getCoordinates();
				location = coords.getLocationOnScreen();

				touch.scroll(coords, 0, -500);
				waitResponse(true);
				pause(2000);
				
				// should see item after 50
				touch.down(location.getX() + 10, location.getY() + 10);
				waitResponse(1000, true);
				
				var selected_item = 
					listbody.findElement(jq(".z-listitem-seld .z-listcell-cnt")).getText().substring(7).toInt;
				println(selected_item);
				
				verifyTrue(selected_item > 50);
				
				// Scroll down on grid
				var gridbody = findElement(By.cssSelector(".z-grid-body > table"));
				
				scroll_outer = findElement(By.cssSelector(".z-grid-body > div:last-child"));
				scroll_bar   = scroll_outer.findElement(By.cssSelector("div"));
				verifyEquals("0", scroll_outer.getCssValue("opacity"));
				
				coords   = gridbody.asInstanceOf[Locatable].getCoordinates();
				location = coords.getLocationOnScreen();
				
				println(location.getX(), location.getY());
				
				touch.flick(coords, 0, -600, FlickAction.SPEED_NORMAL);
				waitResponse(2000, true);
				
				touch.down(location.getX() + 10, location.getY() + 10);
				waitResponse(true);
				
				selected_item  
					= gridbody.findElement(By.cssSelector(".z-row-over .z-label"))
					          .getText().substring(7).toInt;
				println(selected_item);
				verifyTrue(selected_item > 50);
				
				driver.close();
			}
		);
	}
}