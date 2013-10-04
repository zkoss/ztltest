package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B60-ZK-1124.zul")
class B60_ZK_1124Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
                    <window border="normal" title="hello">
                      <div>
                        1. Click the button below to open the menu.<separator spacing="0px"/>
                        2. Click away from the menu to close it, you should see a message box showed.
                      </div>
                      <button id="btn" label="Click me to popup dynamic menu">
                        <attribute name="onClick"><![CDATA[
				Menupopup contextMenu = new Menupopup();
				contextMenu.addEventListener("onOpen", new EventListener() {
					public void onEvent(Event evt) {
						OpenEvent e = (OpenEvent) evt;
						if (!e.isOpen()) {
							Messagebox.show("Menu Closed...");
							evt.getTarget().detach();
						}
					}
				});
				Menu reportMenu = new Menu("MyMenu");
				contextMenu.appendChild(reportMenu);
				contextMenu.setPage(event.getTarget().getPage());
				contextMenu.open(20,20);
			]]></attribute>
                      </button>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(Click)"))
        waitResponse()
        click(jq(".z-window-embedded"))
        waitResponse()
        
        verifyEquals("should see a message box showed.", jq(".z-messagebox-window .z-label").text(), "Menu Closed...")
        
      })

  }
}
