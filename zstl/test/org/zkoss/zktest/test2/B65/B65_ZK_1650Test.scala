package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1650.zul")
class B65_ZK_1650Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	1. Should see no extra space above green Textbox.
	2. Click 'show/hide' button, should see space between two Textboxes.
	3. Click 'show/hide' button again, should see no extra space above green Textbox.
	</label>
	<separator />
	<vlayout style="background-color: orange">
		<textbox id="v1" visible="false" value="Text" style="background-color: cyan" />
		<label visible="false" />
		<grid visible="false" />
		<label visible="false" />
		<grid visible="false" />
		<label visible="false" />
		<grid visible="false" />
		<textbox value="Text" style="background-color: green" />
	</vlayout>
	<button label="show/hide" onClick='v1.setVisible(!v1.isVisible())' />
</zk>
    """

    runZTL(zscript,
      () => {
        val vlayout = jq(".z-vlayout")
        val textbox0 = jq(".z-textbox[style*=green]").parent()
        verifyTrue("Should see no extra space above green Textbox.", vlayout.height() == textbox0.height())

        click(jq(".z-button:contains(show/hide)"))
        waitResponse()

        val textbox1 = jq(".z-textbox[style*=rgb]").parent()
        verifyTrue("should see space between two Textboxes.", vlayout.height() > textbox0.height() + textbox1.height())

        click(jq(".z-button:contains(show/hide)"))
        waitResponse()

        verifyTrue("should see no extra space above green Textbox", jq(".z-vlayout").height() == textbox0.height())
      })

  }
}
