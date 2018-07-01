package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-750.zul")
class B60_ZK_750Test extends ZTL4ScalaTestCase {

  @Test
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
        val listbox = jq(".z-listbox")
        verScroll(listbox, 1)
        waitResponse()
        verScroll(listbox, 0)
        waitResponse()
        verScroll(listbox, 1)
        waitResponse()
        verifyTrue("should not see the content of the listbox is blank", jq(".z-listitem:contains(999)").exists())
      })

  }
}
