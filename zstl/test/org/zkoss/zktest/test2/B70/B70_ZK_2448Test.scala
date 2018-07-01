package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2448.zul")
class B70_ZK_2448Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<zk>
	<label multiline="true">
	1. click the button
	2. you should see the listbox is filled without scroll bar
	</label>
	<button id="addListheaders" label="add list headers to cause JS error"/>
	<!-- whether "span" attribute is specified, hflex should work -->
	<listbox span="true" width="300px">
		<listhead fulfill="addListheaders.onClick">
			<listheader label="aaa" hflex="min"></listheader>
			<listheader label="bbb" hflex="min"></listheader>
			<listheader label="ccc" hflex="min"></listheader>
		</listhead>
		<listitem>
			<listcell>Long Content</listcell>
			<listcell>Shorter</listcell>
			<listcell>tiny</listcell>
		</listitem>
	</listbox>
</zk>

"""
    runZTL(zscript,
      () => {
        click(jq(".z-button"));
        waitResponse();
        var error = jq(".z-error");
        verifyTrue(error.length() == 0);
      })

  }
}