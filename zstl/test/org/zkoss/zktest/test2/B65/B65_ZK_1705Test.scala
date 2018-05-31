package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1705.zul")
class B65_ZK_1705Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<vbox>
	<zscript><![CDATA[
	    String[] data = new String[3];
	    data[0] = "c3";
	    data[1] = "a1";
	    data[2] = "b2";
		ListModelList listModel = new ListModelList(data);
	]]>
	</zscript>

	<div>Sort the list by clicking either of the buttons. No NullPointerException should appear</div>
	<button label="Sort Values (asc)" onClick="listModel.sort(null, true)" />
	<button label="Sort Values (desc)" onClick="listModel.sort(Collections.reverseOrder(), false)" />

	<listbox id="grid" model="${listModel}">
		<template name="model">
			<listitem>
				<listcell>
					<label value="${each}" />
				</listcell>
			</listitem>
		</template>
	</listbox>
</vbox>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(asc)"))
        waitResponse()
        verifyFalse("no exception", jq(".z-window-modal").exists());

        click(jq(".z-button:contains(desc)"))
        waitResponse()
        verifyFalse("no exception", jq(".z-window-modal").exists());
      })

  }
}