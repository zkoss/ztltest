package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1601.zul")
class B60_ZK_1601Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
	Click "clear" button, should not see paging navigation bar on Listbox/Grid.
	<zscript><![CDATA[
		org.zkoss.zul.ListModel dataModel = new org.zkoss.zktest.test2.grid.FakeListModel(45);
	]]></zscript>
	<listbox id="listbox" mold="paging" model="${dataModel}" pageSize="10" activePage="4">
		<listhead>
			<listheader label="Listbox Data" />
		</listhead>
	</listbox>
	<grid id="grid" mold="paging" model="${dataModel}" pageSize="10" activePage="4">
		<columns>
			<column label="Grid Data" />
		</columns>
	</grid>
	<button label="Clear">
		<attribute name="onClick">
			listbox.setModel(new SimpleListModel(new ArrayList()));
			grid.setModel(new SimpleListModel(new ArrayList()));
		</attribute>
	</button>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(Clear)"))
        waitResponse()
        verifyEquals("should not see paging navigation bar on Listbox/Grid.", jq(".z-listbox .z-paging").css("display"), "none")
        verifyEquals("should not see paging navigation bar on Listbox/Grid.", jq(".z-grid .z-paging").css("display"), "none")
      })

  }
}