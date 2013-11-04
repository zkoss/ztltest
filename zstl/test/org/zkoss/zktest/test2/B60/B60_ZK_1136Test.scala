package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B60-ZK-1136.zul")
class B60_ZK_1136Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<vlayout>
		<label>1. Click "show notification" button</label>
		<label>2. Click "close me" button</label>
		<label>3. You should see two notification messages showed.</label>
	</vlayout>
	<window id="win_main" title="Hello Notification!!" border="normal" width="100%">
		<button label="show notification" autodisable="self">
			<attribute name="onClick"><![CDATA[
				Window win = (Window) Executions.getCurrent().createComponents("/test2/B60-ZK-1136-1.zul", null, null);
				win.addEventListener(Events.ON_CLOSE, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event event) throws Exception {
						Clients.showNotification("ok 1", Clients.NOTIFICATION_TYPE_INFO, win_main, "top_right", -1);
						Clients.showNotification("ok 2");
					}
				});
				win.doModal();
			]]></attribute>
		</button>
	</window>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button:contains(show)"))
      waitResponse()
      click(jq(".z-button:contains(Close)"))
      waitResponse()
      verifyTrue("You should see two notification messages showed.", 
          jq(".z-notification").length() == 2)
    })
    
  }
}