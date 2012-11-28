package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1297.zul")
class B65_ZK_1297Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk>
                    <window border="normal" vflex="1" hflex="1">
                      <vlayout>
                        1. The height of Listbox should be smaller than Tabbox.<separator spacing="0"/>
                        2. Click "Add" button, the height of listbox should not change a lot.
                        <button label="Add">
                          <attribute name="onClick">
                            Listitem item = new Listitem();
			new Listcell("cell 1").setParent(item);
			new Listcell("cell 1").setParent(item);
			listBoxAccounts.appendChild(item);
                          </attribute>
                        </button>
                      </vlayout>
                      <listbox id="listBoxAccounts" rows="5" emptyMessage="The content is Empty">
                        <auxhead>
                          <auxheader colspan="2" label="Auxheader"/>
                        </auxhead>
                        <listhead>
                          <listheader label="Listheader 1"/>
                          <listheader label="Listheader 2"/>
                        </listhead>
                        <listfoot>
                          <listfooter span="2">Footer</listfooter>
                        </listfoot>
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
        // 1. The height of Listbox should be smaller than Tabbox.
        val height = jq("@listbox").height()
        verifyTrue("The height of Listbox should be smaller than Tabbox", jq("@listbox").height() < jq("@tabbox").height())

        //2. Click "Add" button, the height of listbox should not change a lot.
        click(jq("@button"))
        waitResponse
        
        val limit = 10
        val newHeight = jq("@listbox").height()
        val isbound = newHeight <= height + limit && newHeight >= height - limit
        verifyTrue("the height of listbox should not change a lot.", isbound)

      })

  }
}
