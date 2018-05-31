package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1711.zul")
class B65_ZK_1711Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">
	1. Click "invalidate" button.
	2. If drop-down list of "Chosenbox" and "Selectbox" is empty, it is a bug. 
	</label>
	<window id="win" width="100%">
		<zscript>
			ListModelList model = new ListModelList();
			model.add("test1");
			model.add("test2");
		</zscript>
		Chosen Box: <chosenbox id="chosenbox" width="100px" model="${model}" />
		Select Box: <selectbox model="${model}" />
		<button label="invalidate" onClick="win.invalidate()" />
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(invalidate)"))
        waitResponse()

        click(jq(".z-chosenbox"))
        waitResponse()
        verifyTrue("the drop-down list of 'Chosenbox' and 'Selectbox' should not be empty ",
          jq(".z-chosenbox-option").length() == 2 && jq("option").length() == 2)
      })

  }
}