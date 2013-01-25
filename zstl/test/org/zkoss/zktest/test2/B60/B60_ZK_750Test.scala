package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-750.zul")
class B60_ZK_750Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
        1. Please scroll down to the end of the listbox.
        <separator/>
        2. Please scroll up to the top of the listbox.
        <separator/>
        3. Please scroll down to the end of the listbox.
        <separator/>
        4. If you see the content of the listbox is blank, that is a bug.
        <zscript>
          <![CDATA[
		List Items = new ArrayList();
		for (int i = 0; i < 1000; i++) {
			Items.add("data "+i);
		}
		ListModelList model = new ListModelList(Items);
	]]>
        </zscript>
        <listbox height="150px" model="${model}"/>
      </zk>"""

    runZTL(zscript,
      () => {
        jq(".z-listbox-body").toElement().set("scrollTop", 30000)
        waitResponse()
        jq(".z-listbox-body").toElement().set("scrollTop", 0)
        waitResponse()
        jq(".z-listbox-body").toElement().set("scrollTop", 30000)
        waitResponse()
        verifyTrue("should not see the content of the listbox is blank", jq(".z-listitem:contains(999)").exists())
      })

  }
}
