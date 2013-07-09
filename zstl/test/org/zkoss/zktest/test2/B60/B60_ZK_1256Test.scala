package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.Keys

@Tags(tags = "B60-ZK-1256.zul")
class B60_ZK_1256Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <window width="100%">
                      1. clear the combobox value by pressing "backspace", then click outside combobox.<separator/>
                      2. should see red "onSelect event triggered" message showed.<separator/>
                      <combobox id="testCb" width="100px">
                        <attribute name="onCreate"><![CDATA[
				List list2 = new ArrayList();
				list2.add("David");
				list2.add("Thomas");
				list2.add("Steven");
				ListModelList lm2 = new ListModelList(list2);
				lm2.addSelection(lm2.get(0));
				testCb.setModel(lm2);
			]]></attribute>
                        <attribute name="onSelect">
                          lbl.setValue("onSelect event triggered");
                        </attribute>
                      </combobox>
                      <label id="lbl" style="color: red"/>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        sendKeys(jq(jq(".z-combobox").toWidget().$n("real")), Keys.END + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "")
        waitResponse()
        click(jq(".z-label:eq(0)"))
        waitResponse()

        verifyTrue(jq(".z-label:contains(onSelect event triggered)").exists())

      })

  }
}
