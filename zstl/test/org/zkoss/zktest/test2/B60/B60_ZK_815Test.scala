package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.Keys
import org.junit.Test

@Tags(tags = "B60-ZK-815.zul")
class B60_ZK_815Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
        <zscript><![CDATA[
		import org.zkoss.zul.*;
		String[] strs = new String[500];
		for (int i = 0; i < 500; i++)
			strs[i] = "Item " + i;
		ListModel model1 = new ListModelList(strs);
		ListModel model2 = new ListModelList(strs);
		model1.multiple = true;
		public void log(Listbox box, String name) {
			ListModel m = box.model;
			String msg = "onSelect: " + name + ": " + 
				(m == null ? box.selectedItems : box.model.selection);
			box.nextSibling.value = msg;
		}
	]]></zscript>
        <div>
          1. For each of the Listbox, select one Listitem and press PageUp/PageDown. You should see onSelect event fired.
        </div>
        <div>
          2. For each of the Listbox, when you press Up/Down which goes across to another page, an onSelect event should be fired.
        </div>
        <separator/>
        <hlayout>
          <vlayout id="v1" hflex="1">
            Listbox 1: Model 1 (Selectable, Multiple)
            <listbox id="listbox1" hflex="1" model="${model1}" checkmark="true" mold="paging" pageSize="12" onSelect='log(self, "Listbox 1")'/>
            <label/>
          </vlayout>
          <vlayout id="v2" hflex="1">
            Listbox 2: Model 2 (Selectable, Single)
            <listbox id="listbox2" hflex="1" model="${model2}" mold="paging" pageSize="12" onSelect='log(self, "Listbox 2")'/>
            <label/>
          </vlayout>
          <vlayout id="v3" hflex="1">
            Listbox 3: No Model
            <listbox id="listbox3" hflex="1" mold="paging" pageSize="12" multiple="true" checkmark="true" onSelect='log(self, "Listbox 3")'>
              <listitem label="${each}" forEach="${strs}"/>
            </listbox>
            <label/>
          </vlayout>
        </hlayout>
      </zk>"""

    runZTL(zscript,
      () => {
        0 to 2 foreach { index =>
          val listbox = jq(".z-listbox:eq(" + index + ")")
          val item = listbox.find(".z-listitem:contains(Item 0)")
          click(item)
          waitResponse()
          sendKeys(item, Keys.PAGE_DOWN)
          waitResponse()
          val msg = jq(".z-vlayout:eq(" + index + ") .z-label:contains(onSelect)")
          if (index != 2)
            verifyEquals(msg.text(), "onSelect: Listbox " + (index + 1) + ": [Item 12]")
          else
            verifyTrue(msg.exists())
          val txt = msg.text()
          1 to 12 foreach { i =>
            val seld = listbox.find(".z-listitem-seld")
            sendKeys(seld, Keys.DOWN)
          }
          waitResponse()

          if (index != 2)
            verifyEquals(msg.text(), "onSelect: Listbox " + (index + 1) + ": [Item 24]")
          else
            verifyTrue(msg != txt)
        }

      })
  }
}
