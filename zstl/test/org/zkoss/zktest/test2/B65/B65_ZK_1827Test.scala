package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1827.zul")
class B65_ZK_1827Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk xmlns:n="native">
	Click "test" button, should not see JS Error showed.
	<tabbox id="tabbox">
		<attribute name="onEcho"><![CDATA[
			tabbox.invalidate();
		]]></attribute>
		<tabs id="tabs">
			<tab id="tab1" label="Tab 1" />
			<tab id="tab2" label="Tab 2" />
		</tabs>
		<tabpanels id="tabpanels">
			<tabpanel id="panel1">
				<attribute name="onCreate"><![CDATA[
					HtmlNativeComponent table = new HtmlNativeComponent("table", "<tbody>", "</tbody>");
					HtmlNativeComponent tr = new HtmlNativeComponent("tr");
					HtmlNativeComponent td = new HtmlNativeComponent("td");
					Window win = new Window();
					win.setTitle("window inside native");
					win.setVflex("true");
					win.setHflex("true");
					td.appendChild(win);
					tr.appendChild(td);
					table.appendChild(tr);
					panel1.appendChild(table);
				]]></attribute>
				<button label="test">
					<attribute name="onClick"><![CDATA[
						tab2.setSelected(true);
						tabbox.invalidate();
						Events.echoEvent("onEcho", tabbox, null);
					]]></attribute>
				</button>
			</tabpanel>
			<tabpanel>test</tabpanel>
		</tabpanels>
	</tabbox>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(test)"))
        waitResponse()
        verifyFalse("should see no javascript error", jq(".z-error").exists())
      })

  }
}