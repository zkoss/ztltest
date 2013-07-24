package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B60-ZK-1222.zul")
class B60_ZK_1222Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?page title="B60-ZK-1222" contentType="text/html;charset=UTF-8"?>
                  <zk>
                    <style>
                      <![CDATA[
    .p-data { 
    	padding-top:5px;
    }
  ]]>
                    </style>
                    <panel title="Instruction" width="500px" border="normal">
                      <panelchildren>
                        <div>The listbox below has a header row, and two data rows.</div>
                        <separator/>
                        <div>
                          When mousing over the first data row, you should see a tooltip loading for about 2 seconds.
      Then, the tooltip should keep displaying until the mouse cursor is moved outside the first data row.
                        </div>
                        <separator/>
                        <div>If you see the tooltip appearing and disappearing several times while it is loading, it is an error.</div>
                      </panelchildren>
                    </panel>
                    <separator/>
                    <label tooltip="msg" value="Hover here to see the real label"/>
                    <separator/>
                    <separator/>
                    <listbox width="500px">
                      <listhead>
                        <listheader label="Operation" width="200px"/>
                        <listheader label="Contacts" sort="auto"/>
                      </listhead>
                      <listitem tooltip="msg">
                        <listcell label=" Mouse hover - tooltip "/>
                        <listcell>
                          <vlayout class="p-data">
                            <label value="Male"/>
                            <label value="Male@hotmail.com"/>
                          </vlayout>
                        </listcell>
                      </listitem>
                      <listitem popup="msg">
                        <listcell label="Click - popup"/>
                        <listcell>
                          <vlayout class="p-data">
                            <label value="Female"/>
                            <label value="Female@hotmail.com"/>
                          </vlayout>
                        </listcell>
                      </listitem>
                    </listbox>
                    <popup id="msg" width="300px">
                      <vlayout>
                        This user is online now !
                        <toolbarbutton label="Mail him/her"/>
                      </vlayout>
                    </popup>
                    <zscript>
                      <![CDATA[
    msg.addEventListener("onOpen", new EventListener() {
    	  public void onEvent(Event e) {
    		  if (((OpenEvent) e).isOpen()) {
    			  Thread.sleep(2000);
    			}
    		}
    });
  ]]>
                    </zscript>
                  </zk>"""

    runZTL(zscript,
      () => {
        mouseOver(jq(".z-listitem:contains(Mouse hover - tooltip)"))
        sleep(1000)
        verifyTrue("should see a tooltip loading for about 2 seconds.", jq(".z-popup").exists())
        verifyTrue("should see a tooltip loading for about 2 seconds.", jq(".z-apply-mask").exists())
        sleep(500)
        verifyTrue("If you see the tooltip appearing and disappearing several times while it is loading, it is an error.", jq(".z-popup").exists())
        sleep(1500)
        verifyTrue(!jq(".z-apply-mask").exists())
        waitResponse()
        mouseMove(jq(".z-listitem:contains(Click - popup)"))
        waitResponse()
        click(jq(".z-listitem:contains(Click - popup)"))
        sleep(2000)
        verifyEquals("Then, the tooltip should keep displaying until the mouse cursor is click outside the second data row.", isVisible(jq(".z-popup")))
        mouseMove(jq(".z-listhead"))
        waitResponse()
        click(jq(".z-listhead"))
        waitResponse()
        sleep(2000)
        verifyNotEquals("Then, the tooltip should keep displaying until the mouse cursor is click outside the second data row.", isVisible(jq(".z-popup")))
      })

  }
}
