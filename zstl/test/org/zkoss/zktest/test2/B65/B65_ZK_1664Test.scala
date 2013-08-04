package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1664.zul")
class B65_ZK_1664Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
<zscript><![CDATA[
import java.util.ArrayList;
import org.zkoss.zul.*;
ArrayList list = new ArrayList();
for (int i = 0; i < 10; i++) {
	list.add("row " + i);
}
ListSubModel model = ListModels.toListSubModel(new ListModelList(list));
]]></zscript>
	<label multiline="true">
	1. Type 'r' in the input chosenbox, and select any one from drop down list.
	2. Type 'r' again, if you don't see the drop down list, it is a bug.
	</label>
    <chosenbox id="lbxThree" width="300px" model="${model}"
    	emptyMessage=" Please select some items." 
    	noResultsText=" No such item - {0} - and it is already in the model."
    	createMessage=" No such item -{0} - but it is not in model either, you can try to create it.">
    </chosenbox>
</zk>
    """

    runZTL(zscript,
      () => {
        val chosenbox = jq(".z-chosenbox-input")
        
        click(chosenbox)
        waitResponse()
        
        sendKeys(chosenbox, "r")
        waitResponse()
        
        sleep(2000)

        click(jq(".z-chosenbox-option:contains(row 4)"))
        waitResponse()
        
        sendKeys(chosenbox, "r")
        waitResponse()
        
        sleep(2000)

        verifyTrue("you should see the drop down list", jq(".z-chosenbox-option:contains(row 6)").exists())
      })

  }
}
