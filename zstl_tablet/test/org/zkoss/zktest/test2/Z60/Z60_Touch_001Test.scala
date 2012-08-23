package org.zkoss.zktest.test2.Z60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.openqa.selenium.android.AndroidDriver
import org.zkoss.ztl.JQuery
import org.openqa.selenium.TouchScreen
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestCase

@Tags(tags = "Touch")
class Z60_Touch_001Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = {
<zk>
	<zscript>
	<![CDATA[
		java.util.Date date = new java.util.Date();
		String[] languages = { 
			"Ada", "Basic", "C", "C++", "CSS", "Cobol", "Forth",
			"Fortran", "Go", "Groovy", "Haskell", "HTML", "Java", "JavaScript",
			"Lisp", "Python", "Ruby", "Scala", "Scheme" 
		};
	]]>
	</zscript>
	<vlayout>
		<hlayout>
			1. Focus on date should show small calendar button 
			<datebox value="${date}" mold="default" inplace="true" />
		</hlayout>
		<hlayout>
			2. type any integer <intbox onChange='lbl1.setValue("onChange fired")'/>, you should see red message. 
			<label id="lbl1" style="color:red" />
		</hlayout>
		<hlayout>
			3. type any text <textbox id="tbx1" onChange='lbl2.setValue("onChange fired")' />, you should see red message. 
			<label id="lbl2" style="color:red" />
		</hlayout>
		<hlayout>
			4. type any number <decimalbox onChange='lbl3.setValue("onChange fired")' />, you should see red message. 
			<label id="lbl3" style="color:red" />
		</hlayout>
		<hlayout>
			5. Select any item should show alert message:
			<listbox id="box" mold="select" onSelect='alert("item selected")'>
				<listitem>
					<listcell label="Philip Hensher" />
				</listitem>
				<listitem>
					<listcell label="The Fit" />
				</listitem>
				<listitem>
					<listcell label="HarperPerennial (April 4, 2005)" />
				</listitem>
				<listitem>
					<listcell label="240 pages" />
				</listitem>
			</listbox>
		</hlayout>
		<hlayout>
			6. Click on scrollbar, it should work correctly
			<tabbox width="200px" height="300px">
			    <tabs>
			        <tab label="Tab 1" />
			        <tab label="Tab 2" />
			        <tab label="Tab 3" />
			        <tab label="Tab 4" />
			        <tab label="Tab 5" />
			        <tab label="Tab 6" />
			        <tab label="Tab 7" />
			        <tab label="Tab 8" />
			    </tabs>
			    <tabpanels>
			        <tabpanel style="color:#336699;">Panel 1</tabpanel>
			        <tabpanel style="color:#333399;">Panel 2</tabpanel>
			        <tabpanel style="color:#663366;">Panel 3</tabpanel>
			        <tabpanel style="color:#CC0033;">Panel 4</tabpanel>
			        <tabpanel style="color:#CC3300;">Panel 5</tabpanel>
			        <tabpanel style="color:#FF9900;">Panel 6</tabpanel>
			        <tabpanel style="color:#ABEA14;">Panel 7</tabpanel>
			        <tabpanel style="color:#008DB7;">Panel 8</tabpanel>
			    </tabpanels>
			</tabbox>
		</hlayout>
		<hlayout>
			7. Click on search icon button, it should open a listbox
			<bandbox id="bd" mold="rounded" autodrop="true">
				<bandpopup>
					<listbox height="250px" width="300px" mold="paging" autopaging="true" onSelect="bd.value=self.selectedItem.label; bd.close();">
						<listhead>
							<listheader label="Programming Languages" />
						</listhead>
						<listitem label="${each}" forEach="${languages}" />
					</listbox>
				</bandpopup>
			</bandbox>
		</hlayout>
	</vlayout>
</zk>
		};
		
		runZTL(zscript,
			() => {
				// 1. Focus on date should show small calendar button
				var dt : JQuery = jq("@datebox");
				click(dt);
				waitResponse();
				verifyTrue(jq(".z-datebox-btn").isVisible());
				
				// 2. Type any integer into intbox, you should see a red message
				var ibx  : JQuery = jq("@intbox");
				focus(ibx);
				sendKeys(ibx, "100");
				//	blur does not seem to work on Android
				click(dt);
				waitResponse();
				verifyEquals("onChange fired", engine.$f("lbl1").get("value"));
				
				// 3. Type any text into textbox, you sould see a red message
				var tbx  : JQuery = jq("@textbox");
				focus(tbx);
				sendKeys(tbx, "any text");
				//	blur does not seem to work on Android
				click(dt);
				waitResponse();
				verifyEquals("onChange fired", engine.$f("lbl2").get("value"));

				// 4. Type any number into decimalbox, you should see a red message
				var dbx  : JQuery = jq("@decimalbox");
				focus(dbx);
				sendKeys(dbx, "123.45");
				//	blur does not seem to work on Android
				click(dt);
				waitResponse();
				verifyEquals("onChange fired", engine.$f("lbl3").get("value"));

				// 5. Select any item from the listbox, you should see an alert message:
				click(jq(".z-select"));
				click(jq(".z-option").eq(2));
				waitResponse();
				verifyEquals("item selected", jq(".z-messagebox .z-label").text());
				click(jq(".z-messagebox-btn"));

				// 6. Click on left/right arrows of tabbox, it should scroll left/right correctly
				var right_scroll : JQuery = jq(".z-tabs-right-scroll");
				var tabcontent   : JQuery = jq(".z-tabs-cnt");
				var left_before  : Int    = tabcontent.offsetLeft();
				var left_after   : Int    = left_before;
				click(right_scroll);
				click(right_scroll);
				left_after = tabcontent.offsetLeft();
				waitResponse();
				verifyTrue(left_after < left_before);
				
				var left_scroll : JQuery = jq(".z-tabs-left-scroll");
				left_before = left_after;
				click(left_scroll);
				click(left_scroll);
				left_after = tabcontent.offsetLeft();
				waitResponse();
				verifyTrue(left_after > left_before);
				
				// 7. Click on search icon button of the bandbox, a listbox should open
				click(jq(".z-bandbox-btn"));
				waitResponse();
				verifyTrue(jq(".z-bandpopup").isVisible());
				
				driver().close();
			}
		)
	}
}