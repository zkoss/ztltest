package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B50-ZK-804.zul")
class B50_ZK_804Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <div>
                      1. Click on the button. You should NOT see javascript Exception.
                    </div>
                    <button label="Go">
                      <attribute name="onClick"><![CDATA[
			Tabpanels tps = new Tabpanels();
			tps.parent = tabbox;
			Tabpanel tp = new Tabpanel();
			tp.parent = tps;
			tp.appendChild(new Label("Tabpanel Content"));
		]]></attribute>
                    </button>
                    <tabbox id="tabbox">
                      <tabs>
                        <tab label="Tab"/>
                      </tabs>
                    </tabbox>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(Go)"))
        waitResponse()
        verifyFalse("should see no javascript Exception", jq(".z-error").exists())
      })

  }
}
