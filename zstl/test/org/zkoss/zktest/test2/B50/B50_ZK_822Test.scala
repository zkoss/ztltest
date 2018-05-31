package org.zkoss.zktest.test2.B50

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B50-ZK-822.zul")
class B50_ZK_822Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <zscript>
                      EventQueue que = EventQueues.lookup("iframe", "group", true);
	void publish(){
                        String text = tbx.getValue();
                        que.publish(new Event("onGroupTest", null, text));
                      }
                    </zscript>
                    <vlayout>
                      <div>
                        Please type some words into the textbox and press ENTER.
			Then, if there is no exception, it is correct.
                        <textbox id="tbx" onChange="publish()" onOK="publish()"/>
                      </div>
                      <iframe width="400px" height="600px" src="test2/B50-ZK-822-iframe.zul"/>
                    </vlayout>
                  </zk>"""

    runZTL(zscript,
      () => {
        val textbox = jq(".z-textbox:eq(0)")
        sendKeys(textbox, "123" + Keys.ENTER)
        waitResponse()
        blur(textbox)
        waitResponse()
        verifyFalse("no exception", jq(".z-window-modal").exists());
      })

  }
}
