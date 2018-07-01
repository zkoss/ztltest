package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-2004.zul")
class B65_ZK_2004Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<window title="Chosebox model replacement" border="normal" width="350px">
	<zscript><![CDATA[
        int i = 0;
        List list = Arrays.asList(new String[]{"AA", "BB", "CC", "DD", "EE"});
        ListModelList model = new ListModelList(list);
    ]]></zscript>
	<label multiline="true">
		1. Choose "DD", "BB", "EE" in the box.
		2. Click replace button.
		3. The chosenbox should not contain selected items.
	</label>
 	<chosenbox id="box" model="${model}" width="200px"></chosenbox>
 	<separator/>
    <button label="Replace">
    	<attribute name="onClick"><![CDATA[
			List list = Arrays.asList(new String[]{"AA", "BB", "CC", "DD", "EE", "New" + i});
			i ++;
			box.setModel(new ListModelList(list));
    	]]></attribute>
    </button>
</window>"""
    runZTL(zscript,
      () => {
        var wgt = jq(".z-chosenbox").toWidget()
        var itemList = List("DD", "BB", "EE")
        for (item <- itemList) {
          click(wgt)
          waitResponse()
          click(jq(wgt.$n("pp")).find(".z-chosenbox-option:contains(" + item + ")"))
          waitResponse()
        }
        click(jq(".z-button"))
        waitResponse()
        verifyTrue("The chosenbox should not contain selected items.", !jq(".z-chosenbox-item").exists)
      })

  }
}