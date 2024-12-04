package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1900.zul")
class B65_ZK_1900Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
         <style>.z-comboitem {height: 150px;}</style>
	<zscript><![CDATA[
		class ItemComparator implements Comparator {
			public int compare(Object text, Object label) {
			    String val = text.toString().toLowerCase();
		
			    if (val.isEmpty()) return 0;
			    return label.toString().toLowerCase().startsWith(val)? 0: -1;
			}
		}
		
		List list = new ArrayList();
		list.add("01");
		list.add("02");
		list.add("03");
		ListModel model = ListModels.toListSubModel(
				new ListModelList(list), new ItemComparator(), 10);
	]]></zscript>
	When scroll combobox to the bottom and type "01", the dropdown should apears above it and have no blank. 
	<div height="900px"></div>
	<combobox model="${model}" 
		autodrop="true" autocomplete="false">
	</combobox>
</zk>"""
    runZTL(zscript,
      () => {
        jq("body").toElement().set("scrollTop", 1000);
        val cb = jq(".z-combobox").toWidget()
        sendKeys(cb.$n("real"), "01")
        waitResponse()

        val $pp = jq(cb.$n("pp"))
        verifyTrue("the dropdown should apears above it",
          $pp.offsetTop() + $pp.height() <= jq(cb).offsetTop())
        verifyTrue("the dropdown should have no blank",
          $pp.find(".z-comboitem:contains(01)").isVisible())

      })

  }
}