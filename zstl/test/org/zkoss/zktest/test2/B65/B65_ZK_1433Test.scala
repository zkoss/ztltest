
package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1433.zul")
class B65_ZK_1433Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<?component name="testwindow" macroURI="B65-ZK-1433-1.zul" ?>
                  <zk>
                    <window title="Test Case" width="100%" height="100%" mode="embedded" closable="false" onCreate="test(60,180)">
                      <label multiline="true">
                        1. Click "Test" button.
		2. Should see combobox width in third window is equal to other window.
                      </label>
                      <button label="Test" onClick="test(60,280)"/>
                    </window>
                    <testwindow title="created by zul code" posx="60px" posy="80px"/>
                    <zscript><![CDATA[
	import org.zkoss.zk.ui.HtmlMacroComponent;
	import org.zkoss.zul.Combobox;
	private void test(int posx, int posy) {
		try {
			HtmlMacroComponent comp = (HtmlMacroComponent) page.getComponentDefinition("testwindow", false).newInstance(page, null);
			comp.setParent(page.getFirstRoot());
			comp.applyProperties();
			comp.setDynamicProperty("title", "created by java code");
			comp.setDynamicProperty("posx", posx + "px");
			comp.setDynamicProperty("posy", posy + "px");
			comp.afterCompose();
		} catch( Exception ex ) {
			alert(ex.getLocalizedMessage());
			ex.printStackTrace();
		}
	}
]]></zscript>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq("@button"))
        waitResponse()
        sleep(1000)
        val window0 = jq(".z-window-overlapped:eq(0)")
        val window1 = jq(".z-window-overlapped:eq(1)")
        val window2 = jq(".z-window-overlapped:eq(2)")
        val window0Combobox0 = window0.find(".z-combobox-input:eq(0)")
        val window0Combobox1 = window0.find(".z-combobox-input:eq(1)")
        val window1Combobox0 = window1.find(".z-combobox-input:eq(0)")
        val window1Combobox1 = window1.find(".z-combobox-input:eq(1)")
        val window2Combobox0 = window2.find(".z-combobox-input:eq(0)")
        val window2Combobox1 = window2.find(".z-combobox-input:eq(1)")
        verifyTrue("window should be there", window2.exists())

        verifyEquals("combobox width in third window is equal to other window.", window2Combobox0.width(), window0Combobox0.width())
        verifyEquals("combobox width in third window is equal to other window.", window2Combobox0.width(), window1Combobox0.width())
        verifyEquals("combobox width in third window is equal to other window.", window2Combobox1.width(), window0Combobox1.width())
        verifyEquals("combobox width in third window is equal to other window.", window2Combobox1.width(), window1Combobox1.width())
      })

  }
}