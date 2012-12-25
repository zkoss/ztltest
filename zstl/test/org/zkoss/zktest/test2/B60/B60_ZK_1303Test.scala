package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1303.zul")
class B60_ZK_1303Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <div>
                      Ste 1: Click "update"<separator/>
                      Step 2: Select first item in the lsitbox "test1"<separator/>
                      Step 3: Click "test"<separator/>
                      Message box should show "test1"
                    </div>
                    <window border="normal" title="hello" width="400px" height="400px">
                      <label value="test"/>
                      <listbox id="listbox" mold="select" rows="1" onSelect=""></listbox>
                      <button id="btn2" label="update" onClick="update();"/>
                      <button id="btn" label="test" onClick='Messagebox.show(listbox.getSelectedItem().getValue().toString());'/>
                      <zscript>
                        <![CDATA[
	listbox.getItems().clear();
	Listitem li = new Listitem("test3", "test3");
	li.setSelected(true);
	li.setParent(listbox);
	public void update() {
		listbox.getItems().clear();
		Listitem li = new Listitem("test1", "test1");
		li.setParent(listbox);
		li = new Listitem("test2", "test2");
		li.setParent(listbox);
		li = new Listitem("test3", "test3");
		li.setSelected(true);
		li.setParent(listbox);
	}
]]>
                      </zscript>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq("@button:contains(update)"))
        waitResponse()
        click(jq(".z-select"))
        waitResponse()
        click(jq(".z-option:contains(test1)"))
        waitResponse()
        click(jq("@button:contains(test)"))
        waitResponse()

        verifyEquals(jq(".z-messagebox-window .z-label").text(), "test1")
      })

  }
}
