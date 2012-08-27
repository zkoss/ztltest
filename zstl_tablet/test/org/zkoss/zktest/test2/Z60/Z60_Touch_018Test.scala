package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Touch")
class Z60_Touch_018Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = """
<?meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"?>
<window title="color window" border="normal" width="500px">
	<label multiline="true">
		<attribute name="value"><![CDATA[
		Colorbox of tablet.
		Dislike traditional Colorbox, it will appear from bottom.
		In palette mode, user must click "ok" button to confirm color user choose.
		In picker mode, layout changed. 
		]]></attribute>
	</label>
	<colorbox color="#FFFF00"/>
</window>""";
		
		runZTL(zscript,
			() => {
				var pageHeight = jq("body").innerHeight();
				
				// Click on colorbox button
				click(jq("@colorbox"));
				waitResponse();
				
				// Popup should appear at the bottom of the screen
				var color_pp = jq(".z-colorbox-pp").eq(0);
				verifyTrue(color_pp.isVisible());
				
				var pp_top = color_pp.css("top").replaceAll("px","").toInt;
				verifyTrue(pageHeight - pp_top < 10);
				
				var color_palette = color_pp.find(".z-colorpalette");
				verifyTrue(color_palette.isVisible());
				
				click(color_pp.find(".z-colorbox-picker-btn"));
				waitResponse();
				var color_picker = color_pp.find(".z-colorpicker");
				verifyTrue(color_picker.isVisible());
			}
		);
	}
}