package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2645.zul")
class B70_ZK_2645Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
    <zscript><![CDATA[
    ListModelList model = new ListModelList();
    for (int j = 1; j < 201; ++j) {
        model.add("" + j);
    }
    void reset() {
        model.clear();
        for (int j = 1; j < 201; ++j) {
            model.add("" + j);
        }
    }
    ]]></zscript>
    <label multiline="true">
    1. Scroll the listbox to most bottom.
    2. Click "Reset" button.
    The listbox scroll position go back to top most but the data didn't show.
    This issue only happened when ROD enabled.
    </label>
    <window>
        <button label="Reset" onClick="reset()" />
        <listbox width="100%" height="400px" model="${model}">
            <custom-attributes org.zkoss.zul.listbox.rod="true" />
            <listhead>
                <listheader label="A" />
            </listhead>
        </listbox>
    </window>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      var listbox = jq("@listbox");
      
      verScroll(listbox, 1);
      waitResponse();
      click(jq("@button"));
      waitResponse();
      var body = jq(".z-listbox-body");
      verifyEquals(body.children().first().css("display"), "none");
    })
    
  }
}