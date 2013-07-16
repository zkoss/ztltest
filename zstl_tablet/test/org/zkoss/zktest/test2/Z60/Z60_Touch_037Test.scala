package org.zkoss.zktest.test2.Z60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.Keys
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_037Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
        <div>
          Type 'a' in both combobox, should not see popup candidates.
        </div>
        <combobox id="combo1" autodrop="true"/>
        <div height="400px"></div>
        <combobox id="combo2" autodrop="true" buttonVisible="false"/>
        <zscript><![CDATA[
		String[] dictionary = {"abacus", "abase", "abate", "abbess", "abbey", "abbot",
				"connoisseur", "connotation", "connote", "connubial", "conquer", 
				"consanguineous", "conscience", "conscientious", "conscious",
				"conscript", "consecrate", "consecutive", "consensus", "conservatism"};
		org.zkoss.zul.ListModel dictModel= new org.zkoss.zul.SimpleListModel(dictionary);
		combo1.setModel(dictModel);
		combo2.setModel(dictModel);
	]]></zscript>
      </zk>"""

    runZTL(zscript,
      () => {
        val combobox0 = jq(".z-combobox:eq(0)").toWidget().$n("real")
        sendKeys(combobox0, "a")
        waitResponse()
        verifyEquals("should not see popup candidates.", jq(jq(".z-combobox:eq(0)").toWidget().$n("pp")).css("display"), "none")
        blur(combobox0)
        waitResponse()
        
        val combobox1 = jq(".z-combobox:eq(1)").toWidget().$n("real")
        sendKeys(combobox1, "a")
        waitResponse()
        verifyEquals("should not see popup candidates.",jq(jq(".z-combobox:eq(1)").toWidget().$n("pp")).css("display"), "none")

      })

  }
}
