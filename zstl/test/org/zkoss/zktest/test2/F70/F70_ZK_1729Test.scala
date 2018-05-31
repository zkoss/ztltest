package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "F70-ZK-1729.zul")
class F70_ZK_1729Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<window apply="org.zkoss.zktest.test2.F70_ZK_1729">
	<div>
	click the 'click me' button and should not throw an exception 
	</div>
	<button id="btn" label="click me"></button><label id="lbl" value="the label will be 'Name Gender Age'" />
	<listbox id="box" multiple="true" checkmark="true">
		<listhead id="head">
			<listheader label="Name" />
			<listheader label="Gender" />
			<listheader label="Age" />
		</listhead>
		<listitem>
			<listcell label="Mary" />
			<listcell label="FEMALE" />
			<listcell label="18" />
		</listitem>
		<listitem>
			<listcell label="John" />
			<listcell label="MALE" />
			<listcell label="20" />
		</listitem>
		<listitem>
			<listcell label="Jane" />
			<listcell label="FEMALE" />
			<listcell label="32" />
		</listitem>
		<listitem>
			<listcell label="Henry" />
			<listcell label="MALE" />
			<listcell label="29" />
		</listitem>
		<listitem>
			<listcell label="Mark" />
			<listcell label="MALE" />
			<listcell label="15" />
		</listitem>
		<listitem>
			<listcell label="Jeffery" />
			<listcell label="MALE" />
			<listcell label="17" />
		</listitem>
		<listitem>
			<listcell label="Rebecca" />
			<listcell label="FEMALE" />
			<listcell label="21" />
		</listitem>
	</listbox>
</window>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button"))
        waitResponse()
        verifyFalse("no exception", jq(".z-window-modal").exists());

        verifyTrue("the label will be 'Name Gender Age'", jq(".z-label:contains(Name Gender Age)").exists)
      })

  }
}