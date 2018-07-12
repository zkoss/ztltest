package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-940.zul")
class B60_ZK_940Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
        <div>
          Select Listitem/Treeitem 1. You should NOT see any of other Listitems/Treeitems selected. Otherwise this is a bug.
        </div>
        <div>
          When you hover Listitem/Treeitem 1, the checkmark of other Listitems/Treeitems should NOT reflect hover state (blue color).
        </div>
        <div>
          Note that due to CSS limitation, we are skipping the fix for IE 6. (We can fix it by adding CSS class, but probably not worth it.)
        </div>
        <listbox multiple="true" checkmark="true">
          <listitem>
            <listcell>
              Listitem 1
              <listbox multiple="true" checkmark="true">
                <listitem label="Listitem 2"/>
                <listitem label="Listitem 3"/>
              </listbox>
              <listbox checkmark="true">
                <listitem label="Listitem 4"/>
                <listitem label="Listitem 5"/>
              </listbox>
            </listcell>
          </listitem>
        </listbox>
        <tree multiple="true" checkmark="true">
          <treechildren>
            <treeitem>
              <treerow>
                <treecell>
                  Treeitem 1
                  <tree multiple="true" checkmark="true">
                    <treechildren>
                      <treeitem label="Treeitem 2"/>
                      <treeitem label="Treeitem 3"/>
                    </treechildren>
                  </tree>
                  <tree checkmark="true">
                    <treechildren>
                      <treeitem label="Treeitem 4"/>
                      <treeitem label="Treeitem 5"/>
                    </treechildren>
                  </tree>
                </treecell>
              </treerow>
            </treeitem>
          </treechildren>
        </tree>
      </zk>"""

    runZTL(zscript,
      () => {
        checkSelection("z-listitem", "Listitem 1")
        checkSelection("z-treerow", "Treeitem 1")
        def checkSelection(cls: String, label: String)=  {
          val seltr = "." + cls
          val item1 = jq(seltr + ":contains(" + label + ")")
          click(item1)
          waitResponse()
          val items = jq(seltr + " " + seltr)
          verifyTrue("should NOT see any of other Listitems/Treeitems selected.", !items.hasClass(cls + "-seld"))
          mouseOver(item1)
          waitResponse()
          verifyTrue("the checkmark of other Listitems/Treeitems should NOT reflect hover state (blue color).", !items.hasClass(cls + "-over"))
        }
      })
  }
}
