package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B50-ZK-873.zul")
class B50_ZK_873Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <div height="20px"/>
                    <div>You should not see any selectall box in the list header</div>
                    <div height="20px"/>
                    <listbox multiple="true" checkmark="true" mold="paging" pageSize="5">
                      <custom-attributes org.zkoss.zul.listbox.rod="true"/>
                      <listhead>
                        <listheader label="Name1"/>
                        <listheader label="Address"/>
                      </listhead>
                      <zk forEach="1,2,3,4,5,6,7,8,9">
                        <listitem>
                          <listcell label="Name ${each}"></listcell>
                          <listcell label="Address ${each}"></listcell>
                        </listitem>
                      </zk>
                    </listbox>
                    <listbox multiple="true" checkmark="true" mold="paging" pageSize="10">
                      <custom-attributes org.zkoss.zul.listbox.rod="true"/>
                      <listhead>
                        <listheader label="Name2"/>
                        <listheader label="Address2"/>
                      </listhead>
                      <zk forEach="1,2,3,4,5,6,7,8,9">
                        <listitem>
                          <listcell label="Name ${each}"></listcell>
                          <listcell label="Address ${each}"></listcell>
                        </listitem>
                      </zk>
                    </listbox>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyTrue("should not see any selectall box in the list header", !jq(".z-listheader:contains(Name1) .z-listheader-img").exists())
        verifyTrue("should not see any selectall box in the list header", !jq(".z-listheader:contains(Name2) .z-listheader-img").exists())
      })

  }
}
