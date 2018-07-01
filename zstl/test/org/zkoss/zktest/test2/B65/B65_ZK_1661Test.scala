package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1661.zul")
class B65_ZK_1661Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
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
        val chosenbox = jq(".z-chosenbox-input")
        sendKeys(chosenbox, "S")
        waitResponse()
        val pp = jq(".z-chosenbox-popup")
        val from = pp.scrollTop()

        for (i <- 1 to 30)
          sendKeys(pp, Keys.DOWN)
        waitResponse()

        verifyNotEquals("Drop-down list should scroll by using keyboard.", from, pp.scrollTop())
      })

  }
}
