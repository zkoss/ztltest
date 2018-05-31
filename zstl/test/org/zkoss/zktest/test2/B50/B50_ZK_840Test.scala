package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B50-ZK-840.zul")
class B50_ZK_840Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
                    <div>
                      1. There should be no javascript error on loading
                    </div>
                    <div>
                      2. Open the Treeitem in the last Tree. You should see no javascript error
                    </div>
                    <grid hflex="min">
                      <rows>
                        <row>Row 1</row>
                      </rows>
                      <foot>
                        <footer label="Footer 1"/>
                      </foot>
                    </grid>
                    <listbox hflex="min">
                      <listitem label="Item 1"/>
                      <listfoot>
                        <listfooter label="Footer 1"/>
                      </listfoot>
                    </listbox>
                    <tree hflex="min">
                      <treechildren>
                        <treeitem label="Item 1"/>
                      </treechildren>
                      <treefoot>
                        <treefooter label="Footer 1"/>
                      </treefoot>
                    </tree>
                    <tree width="300px" height="300px">
                      <treecols>
                        <treecol label="Header 1"/>
                      </treecols>
                      <treechildren>
                        <treeitem label="Item 1" open="false">
                          <treechildren>
                            <treeitem label="Item 2"/>
                          </treechildren>
                        </treeitem>
                      </treechildren>
                      <treefoot>
                        <treefooter label="Footer 1"/>
                      </treefoot>
                    </tree>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyFalse("should see no javascript error", jq(".z-error").exists())
        click(jq(".z-tree:contains(Header) .z-treerow:contains(Item)").toWidget().$n("icon"))
        verifyFalse("should see no javascript error", jq(".z-error").exists())
      })

  }
}
