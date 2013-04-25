package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1660.zul")
class B60_ZK_1660Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
<zscript><![CDATA[
import java.util.*;
import org.zkoss.zul.*;
public class Shop {
	private Integer id;
	private String nameShop;
	
	public Shop(Integer id, String nameShop) {
		this.id = id;
		this.nameShop = nameShop;
	}
	public Integer getId() {
		return id;
	}
	public String getNameShop() {
		return nameShop;
	}
	public String toString() {
		return nameShop;
	}
}
List listShop = new ArrayList();
for (int i = 0; i < 5; i++)
	listShop.add(new Shop(i, "SHOP - " + i));

ListModelList model = new ListModelList(listShop);
]]></zscript>
	<window title="Chosen Box" border="normal">
		<label multiline="true">
		1. Type "S" in the chosenbox and select "SHOP - 0".
		2. Click "test" button, should see "SHOP - 0" still remain in chosenbox.
		</label>
		<chosenbox id="cb" model="${model}" width="400px" noResultsText="No such item - {0}"></chosenbox>
		<button label="test" onClick="alert(cb.getSelectedObjects())" />
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        val chosenbox = jq(".z-chosenbox-inp")
        sendKeys(chosenbox, "S")
        waitResponse()
        blur(chosenbox)
        waitResponse()
        click(jq(".z-chosenbox-option:eq(0)"))
        waitResponse()

        click(jq(".z-button:contains(test)"))
        waitResponse()

        val win = jq(".z-messagebox-window")
        click(win.find(".z-button:eq(0)"))
        waitResponse()

        verifyTrue("should see 'SHOP - 0' still remain in chosenbox.", jq(".z-chosenbox-sel-item:contains(SHOP - 0)").exists)
      })

  }
}