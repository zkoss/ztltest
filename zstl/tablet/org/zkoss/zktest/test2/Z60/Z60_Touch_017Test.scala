package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_017Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() {
		val zscript = """
<zk>
	<zscript><![CDATA[
		Object[] o = new Object[20];
	]]></zscript>
	1. Press the drop-down button, should see drop-down options shows from bottom of the screen<separator/>
	2. You should be able to scrolling the options<separator/>
	<combobox id="cbox" width="200px" onSelect='lbl.setValue(self.getSelectedItem().getLabel())'>
		<zk forEach="${o}">
			<comboitem label="option ${forEachStatus.index + 1}"></comboitem>
		</zk>
	</combobox><label id="lbl" /><separator/>
	<combobox width="200px">
		<comboitem label="Simple and Rich"
			image="/img/Centigrade-Widget-Icons/GoldBar-32x32.gif"
			description="The simplest way to make Web applications rich" />
		<comboitem label="Simple and Rich"
			image="/img/Centigrade-Widget-Icons/GoldBar-32x32.gif"
			description="The simplest way to make Web applications rich" />
		<comboitem label="Cool!"
			image="/img/Centigrade-Widget-Icons/CogwheelEye-32x32.gif"
			description="The coolest technology" />
		<comboitem label="Ajax and RIA"
			image="/img/Centigrade-Widget-Icons/WindowGlobe-32x32.gif"
			description="Rich Internet Application by Ajax" />
		<comboitem label="Ajax and RIA"
			image="/img/Centigrade-Widget-Icons/WindowGlobe-32x32.gif"
			description="Rich Internet Application by Ajax" />
	</combobox>
</zk>""";
		
		runZTL(zscript,
			() => {
				var bodyHeight = jq("body").innerHeight();
				
				// Click on the first drop-down button
				singleTap(jq(".z-combobox").toWidget().$n("btn"));
				waitResponse();
				
				// Should see drop-down options at the bottom of the screen
				var pp = jq(jq(".z-combobox").toWidget().$n("pp"));
				verifyTrue(pp.isVisible());
				var pp_top = pp.css("top").replaceAll("px","").toInt;
				verifyTrue(bodyHeight - pp_top < 10);
				
				// Drop-down options should have scrollbar
				var scroll_outer = pp.find("> div > div:last-child");
				verifyEquals(1, scroll_outer.length());
				
				// Click on the second drop-down button
				singleTap(jq(".z-combobox:eq(1)").toWidget().$n("btn"));
				waitResponse();
				
				// Should see drop-down options at the bottom of the screen
				pp = jq(jq(".z-combobox:eq(1)").toWidget().$n("pp"));
				verifyTrue(pp.isVisible());
				pp_top = pp.css("top").replaceAll("px","").toInt;
				verifyTrue(bodyHeight - pp_top < 10);
			}
		);
	}
}