package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2148.zul")
class B70_ZK_2148Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">
		1. Select "option 1" in the selectbox. 
		2. Click "clear" button.
		3. Open and close the selectbox should not see NullPotinerException showed.
	</label>
	<div>
		<selectbox id="selbox"
			onSelect='System.out.println(self.getSelectedIndex())' />
		<button id="btn" label="clear" onClick="clear()" />
		<zscript><![CDATA[
	ListModelList lml = new ListModelList();
	lml.add("option 1");
	lml.add("option 2");
	lml.add("option 3");
	lml.add("option 4");
	lml.add("option 5");
	selbox.setModel(lml);
	void clear() {
		selbox.setModel(null);
	}
]]></zscript>
	</div>
</zk>"""
    runZTL(zscript,
      () => {
        val sel = jq(".z-selectbox")
        click(sel)
        waitResponse()
        click(sel.find("option:contains(1)"))
        waitResponse()
        click(jq(".z-button"))
        waitResponse()

        click(sel)
        waitResponse()
        verifyFalse("should not see NullPotinerException showed.", jq(".z-window-modal").exists());

        click(sel)
        waitResponse()
        verifyFalse("should not see NullPotinerException showed.", jq(".z-window-modal").exists());
      })

  }
}