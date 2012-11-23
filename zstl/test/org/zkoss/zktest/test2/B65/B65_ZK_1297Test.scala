package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1297.zul")
class B65_ZK_1297Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk>
                    <window border="normal" vflex="1" hflex="1">
                      The height of Listbox should be smaller than Tabbox
                      <listbox id="listBoxAccounts" rows="5" emptyMessage="The content is Empty">
                        <auxhead>
                          <auxheader colspan="2" label="Auxheader"/>
                        </auxhead>
                        <listhead>
                          <listheader label="Listheader 1"/>
                          <listheader label="Listheader 2"/>
                        </listhead>
                      </listbox>
                      <tabbox vflex="1">
                        <tabs>
                          <tab label="tab 1" closable="false"/>
                        </tabs>
                        <tabpanels>
                          <tabpanel>tabpanel 1</tabpanel>
                        </tabpanels>
                      </tabbox>
                    </window>
                  </zk>

    runZTL(zscript,
      () => {
        waitResponse(1000)
        verifyTrue("The height of Listbox should be smaller than Tabbox", jq(".z-listbox-body").height() < jq(".z-tabpanels").height())
      })

  }
}
