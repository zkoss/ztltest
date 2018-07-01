
package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1438.zul")
class B65_ZK_1438Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <label multiline="true">
                      1.when clicking send event, you should see only one message shows in listbox
	2.then use reload1 or reload 2 to reload the window, then clicking send event, you should see only one message shows in listbox1 and one in listbox2
	3.then, detach the window then clicking send event, you should see no message shows in listbox1 and 2
                    </label>
                    <window id="win">
                      <zscript>
                        int count = 0;
                      </zscript>
                      <vlayout id="container">
                        <window>
                          <include id="inc" src="/test2/B65-ZK-1438-inner.zul" mode="instant"/>
                        </window>
                      </vlayout>
                      <hlayout>
                        <button label="reload 1" onClick='container.firstChild.firstChild.invalidate()'/>
                        <button label="reload 2" onClick='container.firstChild.firstChild.src = "/test2/B65-ZK-1438-inner.zul?ts="+count++'/>
                        <button label="sendEvent" onClick="sendEvent()"/>
                      </hlayout>
                      <hlayout>
                        <button label="test clone" onClick='doClone()'/>
                      </hlayout>
                      <zscript><![CDATA[
			void sendEvent(){
				listbox1.getItems().clear();
				listbox2.getItems().clear();
				org.zkoss.zk.ui.event.EventQueues.lookup("myqueue").publish(new org.zkoss.zk.ui.event.Event("onMyEvent"));
			}
			
			void doClone(){
				org.zkoss.zk.ui.Component p2 = container.firstChild.clone();
				p2.title = p2.title +" "+count++; 
				container.appendChild(p2);
			}
			
			
	]]></zscript>
                      <vlayout>
                        <listbox width="600px" id="listbox1"></listbox>
                        <listbox width="600px" id="listbox2"></listbox>
                      </vlayout>
                    </window>
                  </zk>
"""
    runZTL(zscript,
      () => {
        click(jq("@button:contains(sendEvent)"))
        waitResponse()

        verifyEquals("should see only one message shows in listbox", jq("@listbox:eq(0) .z-listcell").length(), 1)
        verifyEquals("should see only one message shows in listbox", jq("@listbox:eq(1) .z-listcell").length(), 1)

        click(jq("@button:contains(reload 1)"))
        waitResponse()
        click(jq("@button:contains(sendEvent)"))
        waitResponse()
        verifyEquals("should see only one message shows in listbox1 and one in listbox2", jq("@listbox:eq(0) .z-listcell").length(), 1)
        verifyEquals("should see only one message shows in listbox1 and one in listbox2", jq("@listbox:eq(1) .z-listcell").length(), 1)

        click(jq("@button:contains(detach)"))
        waitResponse()
        click(jq("@button:contains(sendEvent)"))
        waitResponse()
        verifyEquals("should see no message shows in listbox1 and 2", jq("@listbox:eq(0) .z-listcell").length(), 0)
        verifyEquals("should see no message shows in listbox1 and 2", jq("@listbox:eq(1) .z-listcell").length(), 0)

      })

  }
}