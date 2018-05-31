package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B60-ZK-1070.zul")
class B60_ZK_1070Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk xmlns:w="client">
                    <div>
                      <zscript>
                        org.zkoss.zul.ListModelList list = new org.zkoss.zul.ListModelList();
list.add("A");
list.add("B");
list.add("C");
                      </zscript>
                      <label multiline="true">
                        [onSelect not fired if there is a listheader]
		1.Both listbox should select to B.
		2.select C on listbox 1, it should pop up a message 'onSelect .....' (will not if bug is not fixed)
		3.select C on listbox 2,  it should pop up a message 'onSelect .....'
                      </label>
                      <zscript>
                        void printLog(Component myself){
                          Clients.evalJavaScript("zk.log('server','onSelect :" + myself.id + ":" + myself.getSelectedItem().getLabel() + "');  ");
                        }
                      </zscript>
                      <window apply="org.zkoss.bind.BindComposer" title="a title" width="400px">
                        <listbox mold="select" width="100%" model="${list}" id="first" w:onSelect='zk.log("client","onSelect :"+this.id+":"+this.$n().value)' onSelect='printLog(self)' onCreate='list.addToSelection("B")'>
                          <listhead>
                            <listheader></listheader>
                          </listhead>
                          <template name="model">
                            <listitem>
                              <listcell label="${each}"></listcell>
                            </listitem>
                          </template>
                        </listbox>
                        <listbox mold="select" width="100%" model="${list}" id="second" w:onSelect='zk.log("client","onSelect :"+this.id+":"+this.$n().value)' onSelect='printLog(self)' onCreate='list.addToSelection("B")'>
                          <template name="model">
                            <listitem>
                              <listcell label="${each}"></listcell>
                            </listitem>
                          </template>
                        </listbox>
                        <listbox width="100%" model="${list}" id="third" w:onSelect='zk.log("client","onSelect :"+this.id+":"+jq(".z-listitem-selected",this.$n()).text())' onSelect='printLog(self)' onCreate='list.addToSelection("B")'>
                          <listhead>
                            <listheader></listheader>
                          </listhead>
                          <template name="model">
                            <listitem>
                              <listcell label="${each}"></listcell>
                            </listitem>
                          </template>
                        </listbox>
                      </window>
                    </div>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyEquals("Both listbox should select to B.", jq("option[selected]").text(), "BB")
        val sel0 = jq(".z-select:eq(0)")
        click(sel0)
        waitResponse()
        click(sel0.find(".z-option:contains(C)"))
        waitResponse()
        val result0 = "client, onSelect :first:Cserver, onSelect :first:C"
        verifyEquals("should pop up a message 'onSelect .....'", jq("#zk_log").`val`().replaceAll("\n", "").trim(), result0)

        val sel1 = jq(".z-select:eq(1)")
        click(sel1)
        waitResponse()
        click(sel1.find(".z-option:contains(B)"))
        waitResponse()
        click(sel1.find(".z-option:contains(C)"))
        waitResponse()
        val result1 = "client, onSelect :first:Cserver, onSelect :first:Cclient, onSelect :second:Bserver, onSelect :second:Bclient, onSelect :second:Cserver, onSelect :second:C"
        verifyEquals("should pop up a message 'onSelect .....'", jq("#zk_log").`val`().replaceAll("\n", "").trim(), result1)
      })

  }
}
