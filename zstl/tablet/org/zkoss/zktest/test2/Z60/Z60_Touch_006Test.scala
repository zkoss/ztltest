package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.openqa.selenium.interactions.TouchScreen
import org.openqa.selenium.interactions.HasTouchScreen
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.internal.Locatable
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_006Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() {
		val zscript = """
<zk>
<n:h3 xmlns:n="native">
Android Only
</n:h3>
1. Please test each popup of combo widgets that cannot directly focus to the textbox, which is behind the popup.
<separator/>
For example, if you click the datepicker, and then choose a day, which is upon the textbox "info@zkoss.org", and then the focus cannot jump to that textbox.
<separator/>
2. Please press your finger (long touch) upon the label "Move mouse Over Me", you should see a context-menu appeared.
<separator/>
<datebox />
	<combobox>
		<comboitem label="item 1" />
		<comboitem label="item 2" />
		<comboitem label="item 3" />
		<comboitem label="item 4" />
	</combobox>
	<bandbox>
		<bandpopup>
			<datebox />
		</bandpopup>
	</bandbox>
	<separator/>
	
	ZK Mail Composer
	<grid width="450px">
		<rows>
			<row>
				<textbox width="150px" value="info@zkoss.org"
						constraint="/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*([,;]\s*\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)*/: Please enter real e-mail address" />
				<hbox>
					<textbox width="150px" value="info@zkoss.org"
						constraint="/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*([,;]\s*\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)*/: Please enter real e-mail address" />
					<hbox>
						<image src="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png" tooltip="mail"
							style="cursor: help" />
						<label value="Move mouse Over Me!"
							context="mail" />
					</hbox>
				</hbox>
			</row>
			<row>
				Subject :
				<hbox>
					<textbox value="I love ZK" width="150px" />
					<hbox>
						<image src="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png" popup="title"
							style="cursor:pointer" />
						<label value="Click Me!" popup="title" />
					</hbox>
				</hbox>
			</row>

			<row>
				Introduction:
				<hbox>
					<textbox id="intro" rows="3" width="250px"
						context="editPopup">
						<attribute name="value">Right Click On Me ! </attribute>
					</textbox>
				</hbox>
			</row>
		</rows>
	</grid>
	<menupopup id="editPopup">
		<menuitem label="ClearAll" onClick="intro.value=null" />
		<menu label="QuickText">
			<menupopup>
				<menuitem label="Everything is OK!"
					onClick="intro.value=intro.value + self.label" />
				<menuitem label="Thank you very much!"
					onClick="intro.value=intro.value + self.label" />
				<menuitem label="I'm on a business trip!"
					onClick="intro.value=intro.value + self.label" />
				<menuitem label="I'm busy now!"
					onClick="intro.value=intro.value + self.label" />
			</menupopup>
		</menu>
	</menupopup>
	<popup id="title" width="400px">
		<html>Input the subject of this letter. Problem report :</html>
		<toolbarbutton label="ZK Forum" target="zksandbox"
			href="http://www.zkoss.org/forum" />
	</popup>
	<popup id="mail" width="300px">
		<html>
			Please enter real email address. &lt;br /&gt; The validator
			allow multiple email addresses separated by semi-colons
			(&lt;font color="red"&gt;;&lt;/font&gt;).&lt;br /&gt; For
			Example:&lt;u&gt;zk@zkoss.org&lt;/u&gt;;&lt;u&gt;info@zkoss.org&lt;/u&gt;
		</html>
	</popup>
</zk>			
		};
		
		runZTL(zscript,
			() => {
				// 1. ???
				
				// 2. Please long touch upon the label "Move mouse Over Me"
				//    a context-menu should appear
				
				var driver = this.driver();
				var touch  = driver.asInstanceOf[HasTouchScreen].getTouch();
				var labels = driver.findElements(By.className("z-label"));
				
				// find the label "Move mouse Over Me!"
				var msg : WebElement = null;
				for (i <- 0 to labels.size()-1 if msg == null) {
					msg = labels.get(i);
					if (!msg.getText().equals("Move mouse Over Me!")) {
						msg = null;
					}
				}
				
				var coords = msg.asInstanceOf[Locatable].getCoordinates();
				var location = coords.onPage()

				// Needs to long press at a slightly offset position for this to work
				touch.down(location.getX()+2, location.getY()+2);
				pause(1000);
				
				// touch.longPress(coords);
				waitResponse(true);
				
				verifyTrue(jq(".z-popup").isVisible());
			}
		);
	}
}
