package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-978.zul")
class B65_ZK_978Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk>
                    <zscript><![CDATA[
		String content = "Longer Content: ";
	]]></zscript>
                    <label>
                      Click "Add Item" button, should see the head width adapt to its content.
                    </label>
                    <grid id="grid">
                      <columns>
                        <column label="Col" hflex="min"/>
                      </columns>
                      <rows id="rows"/>
                    </grid>
                    <listbox id="listbox">
                      <listhead>
                        <listheader label="Col" hflex="min"/>
                      </listhead>
                    </listbox>
                    <tree id="tree">
                      <treecols>
                        <treecol label="Col" hflex="min"/>
                      </treecols>
                      <treechildren id="treechildren"/>
                    </tree>
                    <button label="Add Item">
                      <attribute name="onClick"><![CDATA[
			content += "AA";
			rows.appendChild(new Label(content).parent = new Row());
			listbox.appendChild(new Listitem(content));
			treechildren.appendChild(new Treeitem(content));
		]]></attribute>
                    </button>
                  </zk>

    runZTL(zscript,
      () => {        
        val rowHeight = jq(".z-rows").height()
        val listHeight = jq(".z-listbox-body").height()
        val treeHeight = jq(".z-treechildren").height()
        
        click(jq("@button"))
        waitResponse(1000)
        
        verifyNotEquals(jq(".z-rows").height(), rowHeight)
        verifyNotEquals(jq(".z-listbox-body").height(), listHeight)
        verifyNotEquals(jq(".z-treechildren").height(), treeHeight)
        
      })

  }
}
