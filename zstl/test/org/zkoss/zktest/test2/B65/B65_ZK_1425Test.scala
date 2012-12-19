package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1425.zul")
class B65_ZK_1425Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk>
                    <listbox id="box" width="400px">
                      <listhead sizable="true">
                        <listheader id="name" label="name" sort="auto"/>
                        <listheader label="gender" sort="auto"/>
                        <listheader label="age" sort="auto"/>
                      </listhead>
                      <listitem>
                        <listcell label="Mary"/>
                        <listcell label="FEMALE"/>
                        <listcell label="23"/>
                      </listitem>
                      <listitem>
                        <listcell label="John"/>
                        <listcell label="MALE"/>
                        <listcell label="12"/>
                      </listitem>
                      <listitem>
                        <listcell label="Jane"/>
                        <listcell label="FEMALE"/>
                        <listcell label="33"/>
                      </listitem>
                      <listitem>
                        <listcell label="Henry"/>
                        <listcell label="MALE"/>
                        <listcell label="44"/>
                      </listitem>
                      <listfoot>
                        <listfooter span="2">
                          <label value="This is footer1"/>
                        </listfooter>
                        <listfooter>
                          <label value="This is footer2"/>
                        </listfooter>
                      </listfoot>
                    </listbox>
                    <button label="hide/show name column" onClick='name.setVisible(!name.isVisible())'/>
                  </zk>

    runZTL(zscript,
      () => {
        click(jq("@button"))
        waitResponse()
        verifyEquals(jq(".z-listheader:contains(name)").css("display"), "none")
        
        click(jq("@button"))
        waitResponse()
        verifyEquals(jq(".z-listheader:contains(name)").css("display"), "table-cell")
      })

  }
}
