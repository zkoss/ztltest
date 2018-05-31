package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1483.zul")
class B65_ZK_1483Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<html>
		Testing instructions:
		<ol>
			<li>Click 'Select All' button.</li>
			<li>Scroll the listbox up and down a few times.</li>
		</ol>
		
		Expected results:
		<ul>
			<li>The scrollbar position should not vibrate when released.</li>
		</ul>
	</html>
	<window apply="org.zkoss.zktest.test2.B65_ZK_1483">
		<listbox id="listbox" width="100%" rows="10">
			<listhead>
				<listheader	label="Label" sort="auto" />
			</listhead>
		</listbox>
		
		<button	id="btnSelectAll" label="Select All" />
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(Select All)"))
        waitResponse()
        val listboxBody = jq(".z-listbox-body")
        listboxBody.toElement().set("scrollTop", 360)
        listboxBody.toElement().set("scrollTop", 720)

        sleep(500)
        verifyTrue("The scrollbar position should not vibrate when released.", listboxBody.scrollTop() == 720)
      })

  }
}