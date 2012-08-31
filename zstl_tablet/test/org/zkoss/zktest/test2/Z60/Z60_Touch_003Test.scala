package org.zkoss.zktest.test2.Z60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.JQuery
import org.openqa.selenium.TouchScreen
import org.openqa.selenium.HasTouchScreen
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.interactions.internal.Coordinates
import org.openqa.selenium.Point
import org.zkoss.ztl.Tags

@Tags(tags = "Touch,Android")
class Z60_Touch_003Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = {
<zk>
	<vlayout>
		<hlayout>
			1. Click on group button; the rows underneath should be collapsed.
			<grid id="grid1" hflex="min">
				<columns sizable="true">
					<column label="Brand" />
					<column label="Processor Type" width="150px" />
					<column label="Memory (RAM)" width="120px" />
					<column label="Price" width="100px" />
					<column label="Hard Drive Capacity" width="150px" />
				</columns>
				<rows>
					<group label="Dell" />
					<row height="20px">
						<label style="padding-left:15px" value="Dell E4500 2.2GHz" />
						<label value="Intel Core 2 Duo" />
						<label value="2GB RAM" />
						<label value="$261.00" style="color:green" />
						<label value="500GB" />
					</row>
					<row height="20px">
						<label style="padding-left:15px" value="XP-Pro Slim Dell-Inspiron-530-s" />
						<label value="Intel Core 2 Duo" />
						<label value="2GB RAM" />
						<label value="$498.93" style="color:green" />
						<label value="500GB" />
					</row>
					<row height="20px">
						<label style="padding-left:15px" value="Dell P4 3.2 GHz" />
						<label value="Intel Pentium 4" />
						<label value="4GB RAM" />
						<label value="$377.99" style="color:green" />
						<label value="500GB" />
					</row>
				</rows>
			</grid>
		</hlayout>
		<hlayout>
			2. Click on ColorPicker; a color palette should be opened.
			<window id="win2" border="normal" title="Color Picker" height="180px" width="200px">
				<colorbox width="30px" height="25px" color="#029BCB">
					<attribute name="onChange"><![CDATA[
						win2.setContentStyle("background-color:" + self.getColor());
					]]></attribute>
				</colorbox>
			</window>
		</hlayout>
		<hlayout>
			<style dynamic="true">
			<![CDATA[
				.focus .z-label { color: #029CCC; }
			]]>
			</style>
			<zscript><![CDATA[
				void changeStyle(org.zkoss.zul.Hbox h) {
					h.setSclass("focus".equals(h.getSclass()) ? "" : "focus");
				}
			]]></zscript>
			3. Focus on the two textboxes; the labels' text color should change.
			<vlayout>
				<hbox id="h1">
					<label id="t1" value="Text1: " />
					<textbox id="text1" onBlur="changeStyle(h1)" onFocus="changeStyle(h1)" />
				</hbox>
				<hbox id="h2">
					<label id="t2" value="Text2: " />
					<textbox id="text2" onBlur="changeStyle(h2)" onFocus="changeStyle(h2)" />
				</hbox>
			</vlayout>
		</hlayout>
		<hlayout>
			4. Focus on the textboxes; description text should appear.
			<grid width="400px" xmlns:c="client">
				<rows>
					<row height="20px">
						<label value="text1: " />
						<textbox c:onFocus="jq(this.$f('help1')).fadeIn()" c:onBlur="jq(this.$f('help1')).fadeOut()" />
						<label id="help1" visible="false" value="This is help for text1." />
					</row>
					<row height="20px">
						<label value="text2: " />
						<textbox c:onFocus="jq(this.$f('help2')).fadeIn()" c:onBlur="jq(this.$f('help2')).fadeOut()" />
						<label id="help2" visible="false" value="This is help for text2." />
					</row>
				</rows>
			</grid>
		</hlayout>
		<hlayout>
			5. Keep scrolling down; you should see more items under option 50.
			<style>
			<![CDATA[
				div.z-listbox-body .z-listcell { padding: 2px 5px; }
			]]>
			</style>
			<zscript><![CDATA[
				org.zkoss.zul.ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(250000);
			]]></zscript>
			<listbox id="list" width="200px" rows="10" model="${strset}">
				<listhead>
					<listheader label="Load On Demand" sort="auto" />
				</listhead>
			</listbox>
		</hlayout>
	</vlayout>
</zk>			
		};
		
		runZTL(zscript, 
			() => {
				// 1. Click on group button, the grouped rows should collapse.
				click(jq(".z-group-img-open"));
				waitResponse(true);
				
				var group_rows : JQuery = jq("#grid1 .z-row");
				for (i <- 0 to group_rows.length()-1) {
					verifyFalse(group_rows.eq(i).isVisible());
				}
				
				// 2. Click on ColorPicker, it should be opened.
				click(jq("@colorbox"));
				waitResponse(true);
				
				verifyTrue(jq(".z-colorpalette").isVisible());
				
				// retract color palette
				click(jq("@colorbox"));
				waitResponse(true);
				
				// 3. Focus on the two textboxes, the label text color should change.
				var label1 : JQuery = jq("$h1 @label");
				var style1 : String = label1.css("color");
				var label2 : JQuery = jq("$h2 @label");
				var style2 : String = label2.css("color");
				
				click(jq("$h1 @textbox"));
				waitResponse();
				
				verifyTrue(!label1.css("color").equals(style1) && 
						    label2.css("color").equals(style2));
				
				click(jq("$h2 @textbox"));
				waitResponse();
				
				verifyTrue( label1.css("color").equals(style1) && 
						   !label2.css("color").equals(style2));
			
				// 4. Focus on textbox inside grid, description text should be shown.
				var grid_tbx : JQuery = jq("@grid @row @textbox"); 
				click(grid_tbx.eq(0));
				waitResponse(true);
				
				var help1 : JQuery = jq("$help1");
				var help2 : JQuery = jq("$help2");
				verifyTrue(help1.isVisible() && !help2.isVisible());
				
				click(grid_tbx.eq(1));
				waitResponse(true);

				verifyTrue(!help1.isVisible() && help2.isVisible());

				// 5. keep scrolling down, you should see more items after option 50.
				var listbody : WebElement = findElement(By.className("z-listbox-body"));
				var touch    : TouchScreen = this.driver().asInstanceOf[HasTouchScreen].getTouch();
				var coords   : Coordinates = listbody.asInstanceOf[Locatable].getCoordinates();
				var location : Point = coords.getLocationOnScreen();
				
				// scroll down
				touch.scroll(coords, 0, -400);
				waitResponse();
				sleep(10000);
				
				// select an listitem
				touch.down(location.getX() + 10, location.getY() + 10);
				waitResponse(true);
				
				var selected_item : Int 
					= listbody.findElement(jq(".z-listitem-seld .z-listcell-cnt"))
					          .getText().substring(7).toInt;
				println(selected_item);
				verifyTrue(selected_item > 50);
			}
		);
	}
}