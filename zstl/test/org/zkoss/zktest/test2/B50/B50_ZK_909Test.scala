package org.zkoss.zktest.test2.B50

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.By
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.Keys
import org.zkoss.ztl.util.Scripts
import org.junit.Test
import org.zkoss.ztl.ZK

@Tags(tags = "B50-ZK-909.zul")
class B50_ZK_909Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8" ?>
                  <zk>
                    <div>step 1: click on save button without entering any data (you should see errorbox message)</div>
                    <div>step 2: close errorbox1 and then errorbox2 (if you reverse the closing sequence then it will not cause this issue)</div>
                    <div>step 3: enter some text into first textbox</div>
                    <div>step 4: click on save again, the value of first textbox should not be cleared.</div>
                    <vlayout>
                      <hlayout>
                        <label value="First textbox"></label>
                        <textbox id="periodValue"></textbox>
                      </hlayout>
                      <hlayout>
                        <label value="Second textbox"></label>
                        <textbox id="periodValue1"></textbox>
                      </hlayout>
                      <button id="b" label="save">
                        <attribute name="onClick"><![CDATA[
				import java.util.ArrayList;
				
				import org.zkoss.lang.Strings;
				import org.zkoss.zk.ui.WrongValueException;
				import org.zkoss.zk.ui.WrongValuesException;
				
				ArrayList wve = new ArrayList();
				if(Strings.isEmpty(periodValue.getValue())) {
					wve.add(new WrongValueException(periodValue, "Empty not allowed 1"));
				}
				if(Strings.isEmpty(periodValue1.getValue())) {
					wve.add(new WrongValueException(periodValue1, "Empty not allowed 2"));
				}
				if (wve.size() > 0) {
					WrongValueException[] wvea = new WrongValueException[wve.size()];
					for (int i = 0; i < wve.size(); i++) {
						wvea[i] = (WrongValueException) wve.get(i);
					}
					throw new WrongValuesException(wvea);
				}			
			  ]]></attribute>
                      </button>
                    </vlayout>
                  </zk>"""

    runZTL(zscript,
      () => {
        val savebtn = jq(".z-button:contains(save)")
        click(savebtn)
        waitResponse()
        verifyTrue("should see errorbox message", jq(".z-errorbox").exists())

        click(jq(".z-errorbox").toWidget().$n("cls"))
        waitResponse()
        sleep(500)
        click(jq(".z-errorbox").toWidget().$n("cls"))
        waitResponse()
        sleep(500)
        if(!ZK.is("ff") && !ZK.is("safari")) // selenium
        	verifyTrue("should not see errorbox message", !jq(".z-errorbox").exists())
        
        
        val textbox = jq(".z-textbox:eq(0)")
        sendKeys(textbox, "1111")
        waitResponse()
        blur(textbox)
        waitResponse()
        
        click(savebtn)
        waitResponse()
        verifyTrue("the value of first textbox should not be cleared.", textbox.`val`().length() != 0)

      })

  }
}
