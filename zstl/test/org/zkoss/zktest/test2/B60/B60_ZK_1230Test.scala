package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1230.zul")
class B60_ZK_1230Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
                  <zk>
                    <button label="showPage">
                      <attribute name="onClick">
                        <![CDATA[
      drillList.getChildren().clear();
      for (int i = 0; i < 2; i++) {
        Listitem li = new Listitem();
        li.appendChild(new Listcell("trackName " + i));
        drillList.appendChild(li);
      }
      pages.setSelectedIndex(1);
    ]]>
                      </attribute>
                    </button>
                    <tabbox id="pages" hflex="1" vflex="1">
                      <tabs height="50px">
                        <tab label="instruction"/>
                        <tab label="result"/>
                      </tabs>
                      <tabpanels>
                        <tabpanel>
                          <html>
                            <ol>
                              <li>Click on 'showPage' button.</li>
                              <li>You should see in the 'result' tab, a list of 2 items: "trackName 0" and "trackName 1".</li>
                              <li>If not, that's an error.</li>
                            </ol>
                          </html>
                        </tabpanel>
                        <tabpanel>
                          <listbox id="drillList" height="500px"/>
                        </tabpanel>
                      </tabpanels>
                    </tabbox>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq("@button:contains(showPage)"))
        waitResponse()

        verifyTrue("should see in the 'result' tab", jq(".z-tab:contains(result)").hasClass("z-tab-seld"))
        verifyEquals("should see in the 'result' tab", jq(".z-tabpanel:eq(1)").css("display"), "block")
        verifyTrue("should see 'trackName 0'", jq(".z-listitem:contains(trackName 0)").exists())
        verifyTrue("should see 'trackName 1'", jq(".z-listitem:contains(trackName 1)").exists())
      })

  }
}
