package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZK

@Tags(tags = "B65-ZK-1661.zul")
class B65_ZK_1661Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
<zscript><![CDATA[
import java.util.*;
import org.zkoss.zul.*;
List listShop = new ArrayList();
for (int i = 0; i < 100; i++)
	listShop.add("SHOP - " + i);

ListModelList model = new ListModelList(listShop);
]]></zscript>
	<window title="Chosen Box" border="normal">
		<label multiline="true">
			1. Type 'S' in the input text.
			2. Drop-down list should scroll by using keyboard.
		</label>
		<chosenbox id="cb" model="${model}" width="400px" noResultsText="No such item - {0}" />
	</window>
</zk>
    """

    runZTL(zscript,
      () => {
        val chosenbox = jq(".z-chosenbox-inp")
        sendKeys(chosenbox, "S")
        waitResponse()
        val pp = jq(".z-chosenbox-pp")

        for (i <- 1 to 30)
          sendKeys(pp, Keys.DOWN)
        waitResponse()

        verifyTrue("Drop-down list should scroll by using keyboard.", pp.scrollTop() != 0)
      })

  }
}
