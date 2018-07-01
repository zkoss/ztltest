
package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1418.zul")
class B65_ZK_1418Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
                    <zscript><![CDATA[
		import org.zkoss.zul.ListModelList;
		String[] userNamesA = { "Tony", "Ryan", "SELECT ME", "Wing", "Sam" };
		ListModelList modelA = new ListModelList(userNamesA);
		String[] userNamesB = { "Peter", "Paul" };
		ListModelList modelB = new ListModelList(userNamesB);
		void b1Click() {
			sel1.setModel(modelB);
			modelB.addToSelection(modelB.getElementAt(1));
		}
	]]></zscript>
                    <label multiline="true">
                      1. Select "SELECT ME" in the selectbox.
	2. Click "Change Model" button, if you see a error messagebox, it is a bug.
                    </label>
                    <selectbox id="sel1" model="${modelA}">
                      <template name="modelA">Name is ${ each }</template>
                    </selectbox>
                    <button label="Change Model" onClick="b1Click()"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        select(jq("select"), "SELECT ME")
        click(jq("@button"))
        waitResponse()

        verifyTrue("error messagebox should not show", !jq(".z-errorbox").exists())

      })

  }
}