
package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1428.zul")
class B65_ZK_1428Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <window title="Hello World!!" border="normal">
                      <label multiline="true">
                        Click the three "remove" button, should not see any error message.
                      </label>
                      <zscript><![CDATA[
		import org.zkoss.zul.*;
		import java.util.*;
		List items = new ArrayList();
		for (int i = 0; i<5; i++)
			items.add("Item " + i);
		ListModelList model1 = new ListModelList(items);
		ListModelList model2 = new ListModelList(items);
		ListModelList model3 = new ListModelList(items);
		model1.setMultiple(true);
		model2.setMultiple(true);
		model3.setMultiple(true);
		int size = model1.getSize();
		model1.setSelection(items.subList(size - 2, size));
		model2.setSelection(items.subList(size - 2, size));
		model3.setSelection(items.subList(size - 2, size));
		]]></zscript>
                      <listbox id="buggyremove1" multiple="true" model="${model1}"/>
                      <button label="remove">
                        <attribute name="onClick"><![CDATA[
			ListModel m = buggyremove1.getModel();
			m.remove(size - 1);
			self.setDisabled(true);
			]]></attribute>
                      </button>
                      <separator spacing="30px"/>
                      <listbox id="buggyremove2" multiple="true" model="${model2}"/>
                      <button label="remove">
                        <attribute name="onClick"><![CDATA[
			ListModel m = buggyremove2.getModel();
			for (Iterator it = m.iterator(); it.hasNext();) {
				String s = it.next();
				if (!s.equals("Item 0"))
					it.remove();
			}
			self.setDisabled(true);
			]]></attribute>
                      </button>
                      <separator spacing="30px"/>
                      <listbox id="buggyremove3" multiple="true" model="${model3}"/>
                      <button label="remove">
                        <attribute name="onClick"><![CDATA[
			ListModel m = buggyremove3.getModel();
			for (Iterator it = m.listIterator(); it.hasNext();) {
				String s = it.next();
				if (!s.equals("Item 0"))
					it.remove();
			}
			self.setDisabled(true);
			]]></attribute>
                      </button>
                    </window>
                  </zk>
"""
    runZTL(zscript,
      () => {
        click(jq("@button:eq(0)"))
        waitResponse()
        click(jq("@button:eq(1)"))
        waitResponse()
        click(jq("@button:eq(2)"))
        waitResponse()
        verifyTrue("should not see any error message.", !jq(".z-errorbox").exists())
      })

  }
}