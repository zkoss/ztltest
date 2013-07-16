package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.HasTouchScreen
import org.openqa.selenium.By
import org.openqa.selenium.internal.Locatable
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_019Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() {
		val zscript = """
<?meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0"?>
<zk>
	<zscript>Object[] o = new Object[10];</zscript>
	<borderlayout hflex="1" vflex="1">
		<west size="25%" title="West" collapsible="true" autoscroll="true">
			<div hflex="min" vflex="min" style="background: green">
				<vlayout hflex="1" vflex="1">
				<groupbox hflex="1" vflex="1">
					<caption label="Test1" />
					<div hflex="1" height="600px">Test1</div>
				</groupbox>
				<groupbox hflex="1" vflex="1">
					<caption label="Test2" />
					<div hflex="1" height="600px">Test2</div>
				</groupbox>
				</vlayout>
			</div>
		</west>
		<center autoscroll="true">
			<vlayout id="v">
				<label value="1.Try scroll down and right here" style="font-size:22px"/>
				<label value="2.Click 'add/remove' button and scroll again" style="font-size:22px"/>
				<hlayout>
					<button label="add">
						<attribute name="onClick"><![CDATA[
							Div d1 = new Div();
							d1.setId("add1");
							d1.setHeight("100px");
							d1.setWidth("300px");
							d1.setStyle("background: black;");
							Div d2 = new Div();
							d2.setId("add2");
							d2.setHeight("100px");
							d2.setWidth("300px");
							d2.setStyle("background: grey;");
							v.appendChild(d1);
							v.appendChild(d2);
						]]></attribute>
					</button>
					<button label="remove" onClick="v.removeChild(add1);v.removeChild(add2);" />
				</hlayout>
				<zk forEach="${o}">
					<div>
						<hlayout hflex="min">
							<zk forEach="${o}">
							<div height="200px" width="200px" style="background: gold; border: 1px solid black;">
								<label value="Div ${forEachStatus.previous.index * 10 + forEachStatus.index}" style="font-size:18px"/>
							</div>
							</zk>
						</hlayout>
					</div>
				</zk>
			</vlayout>
		</center>
	</borderlayout>
</zk>""";
		
		runZTL(zscript,
			() => {
				var center     = jq(".z-center");
				var scroll_hor = center.find("> div > div:nth-last-child(2)");
				var scroll_ver = center.find("> div > div:nth-last-child(1)");
				
				// Center region should have horizontal and verical scrollbars
				verifyTrue(1 == scroll_hor.length());
				verifyTrue(1 == scroll_ver.length());
				
				var hor_length = scroll_hor.find("> div").width();
				var ver_length = scroll_ver.find("> div").height();
				
				// Click on "add" button to insert content
				singleTap(center.find("@button").eq(0));
				waitResponse();
				
				// Vertical scrollbar should be shorter than before
				verifyTrue(hor_length == scroll_hor.find("> div").width());
				verifyTrue(ver_length >  scroll_ver.find("> div").height());
				
				// Click on "remove" button to delete content
				singleTap(center.find("@button").eq(1));
				waitResponse();
				
				// Scrollbar should have the original length
				verifyTrue(hor_length == scroll_hor.find("> div").width());
				verifyTrue(ver_length == scroll_ver.find("> div").height());
			}
		);
	}
}
