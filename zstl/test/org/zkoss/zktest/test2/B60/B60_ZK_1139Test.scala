package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1139.zul")
class B60_ZK_1139Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk xmlns:n="native">
                    <n:h5>Testing step:</n:h5>
                    <n:ol>
                      <n:li> make the checkbox in caption become unchecked </n:li>
                      <n:li> change the value of "name" textbox</n:li>
                      <n:li> click "change name" button</n:li>
                      <n:li> the value of name should not changed</n:li>
                    </n:ol>
                    <window id="myWin" title="binder loadComponent loadinit false" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.basic.CompositeVM')">
                      <caption>
                        <checkbox id="liChk" label="load Init" checked="true"/>
                      </caption>
                      <grid>
                        <rows>
                          <row>
                            <textbox id="nameTexb" value="@load(vm.name)"></textbox>
                            <button id="changeNameBtn" label="change name">
                              <attribute name="onClick"><![CDATA[
						myWin$composer.getViewModel().setName(nameTexb.getValue());
						myWin$composer.getBinder().loadComponent(myWin, liChk.isChecked());
					]]></attribute>
                            </button>
                          </row>
                          <row>name (init binding): <label id="nameLbl" value="@init(vm.name)"/></row>
                          <row>title: <label value="@bind(vm.title)"/> </row>
                          <row>value: <label value="@bind(vm.value)"/> </row>
                        </rows>
                      </grid>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq("input[type*=checkbox]"))
        waitResponse()
        sendKeys(jq(".z-textbox"), "aaaaa")
        waitResponse()
        click(jq(".z-button:contains(change name)"))
        waitResponse()
        verifyEquals("should not changed", jq(".z-row:eq(1) .z-label:eq(1)").text(), "Dennis")
      })

  }
}
