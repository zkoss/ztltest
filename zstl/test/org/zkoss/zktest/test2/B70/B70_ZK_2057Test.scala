package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2057.zul")
class B70_ZK_2057Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?page title="checkbox setChecked" contentType="text/html;charset=UTF-8"?>
<zk>
	<label multiline="true">
		1. Click 'checked',then the checkbox will be checked;
		2. Click 'unChecked',then the checkbox will be unchecked;
		3  Click 'checked',then the checkbox will be checked;
	</label>
	<window title="checkbox setChecked" border="normal">
		<checkbox id="testBox"></checkbox>
		<button label="checked" id="trueBtn" onClick="checkTrueClick()"/>
		<button label="unChecked" id="fasleBtn" onClick="checkFalseClick()"/>
		<zscript><![CDATA[
			void checkTrueClick() {
				testBox.setChecked(true);
			}
			void checkFalseClick() {
				testBox.setChecked(false);
			}
		]]></zscript>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        val ckecked = jq(".z-button:contains(checked)")
        val unckecked = jq(".z-button:contains(unChecked)")
        val cb = jq(".z-checkbox").toWidget().$n("real")
        click(ckecked)
        waitResponse()
        verifyTrue("the checkbox will be checked", cb.get("checked") == "true")

        click(unckecked)
        waitResponse()

        verifyTrue("the checkbox will be unchecked", cb.get("checked") != "true")

        click(ckecked)
        waitResponse()
        verifyTrue("the checkbox will be checked", cb.get("checked") == "true")
      })

  }
}