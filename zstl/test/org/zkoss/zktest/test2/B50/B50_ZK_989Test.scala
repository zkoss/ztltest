package org.zkoss.zktest.test2.B50

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B50-ZK-989.zul ")
class B50_ZK_989Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <div>1. Select item 3.</div>
                    <div>2. Click 'Disabled' Button.</div>
                    <div>3. Select item 4, and click 'Get Selected' Button. You should see "4" next to the button.</div>
                    <div>4. Select item 3, and click 'Get Selected' Button. You should see "3".</div>
                    <listbox id="listbox" mold="select">
                      <listitem id="item${each}" value="${each}" label="${each}" forEach="1,2,3,4"/>
                    </listbox>
                    <button label="Disable" onClick="item2.visible=false;"/>
                    <button label="Get Selected" onClick="selectedValue.value=listbox.getSelectedItem().getValue();"/>
                    <label value="" id="selectedValue"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        val sel = jq(".z-select")
        click(sel)
        waitResponse()
        click(sel.find(".z-option:contains(3)"))
        waitResponse()
        
        click(jq(".z-button:contains(Disable)"))
        waitResponse()
        
        click(sel)
        waitResponse()
        click(sel.find(".z-option:contains(4)"))
        waitResponse()
        
        click(jq(".z-button:contains(Get Selected)"))
        waitResponse()

        verifyTrue("should see '4' next to the button.", jq(".z-label:contains(4)").exists())
        
        click(sel)
        waitResponse()
        click(sel.find(".z-option:contains(3)"))
        waitResponse()
        
        click(jq(".z-button:contains(Get Selected)"))
        waitResponse()

        verifyTrue("should see '3'", jq(".z-label:contains(3)").exists())
      })

  }
}
