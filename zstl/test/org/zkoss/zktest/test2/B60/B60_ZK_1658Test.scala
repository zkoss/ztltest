package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1658.zul")
class B60_ZK_1658Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<zscript><![CDATA[
	import java.util.*;
	import org.zkoss.zul.*;
	List listShop = new ArrayList();
	for (int i = 0; i < 100; i++)
		listShop.add("SHOP - " + i);
	ListModelList model = new ListModelList(listShop);
	ListSubModel submodel = (ListSubModel) ListModels.toListSubModel(model);
	]]></zscript>
	<window title="Chosen Box" border="normal">
		<label multiline="true">
		1. Type "S" in the input, and select one item.
		2. If you see the component disappeared, it is a bug.
		</label>
		<chosenbox id="cb" model="${submodel}" width="400px" noResultsText="No such item - {0}" />
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        val chosenbox = jq(".z-chosenbox-input")
        sendKeys(chosenbox, "S")
        waitResponse()
        blur(chosenbox)
        waitResponse()
        click(jq(".z-chosenbox-option:eq(0)"))
        waitResponse()

        verifyTrue("the component should not disappear", chosenbox.exists)
      })

  }
}