package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-1807.zul")
class B70_ZK_1807Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?page title="Bandbox Style Change" contentType="text/html;charset=UTF-8"?>
<zk>
	<window title="Bandbox Style Change" border="normal">
		<label>
		Click "test", each component width won't change.
		</label>
		<vbox width="500px">
			<bandbox hflex="1" id="bandbox"/>
			<datebox hflex="min" id="datebox"/>
			<spinner id="spinner"/>
			<combobox width="300px" id="combobox">
				<comboitem label="value"/>
			</combobox>
			<button label="test" onClick="doClick()"/>
			<zscript>
				void doClick() {
					bandbox.setStyle("background-color:yellow;");
					datebox.setStyle("background-color:yellow;");
					spinner.setStyle("background-color:yellow;");
					combobox.setStyle("background-color:yellow;");
				}
			</zscript>
		</vbox>
	</window>
</zk>
"""
    runZTL(zscript,
      () => {

        val w1 = jq(".z-bandbox").width()
        val w2 = jq(".z-datebox").width()
        val w3 = jq(".z-spinner").width()
        val w4 = jq(".z-combobox").width()
        click(jq(".z-button"))
        waitResponse()

        verifyTrue("each component width won't change.", jq(".z-bandbox").width() == w1 && jq(".z-datebox").width() == w2
          && jq(".z-spinner").width() == w3 && jq(".z-combobox").width() == w4)
      })

  }
}