/* B50_2990657Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2990657Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
				<div>Set Combobox autocomplete="false" doesn't work, still has autocomplete</div>
				<div>Type in the combobox "ab" and press enter, the text in the combobox should be "ab", not "abacus"</div>
				
				<combobox id="combo" autodrop="true" autocomplete="false"/>
				<zscript>
				String[] _dict = { 
					"abacus", "accuracy", "acuity", "adage", "afar", "after", "apple",
					"jump", "jungle", "jungle fever"
				};
				 ListModel dictModel= new SimpleListModel(_dict);
				 combo.setModel(dictModel);
				</zscript>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val combo = ztl$engine.$f("combo")
    runZTL(zscript, () => {
      focus(combo.$n("real"))
      sendKeys(combo.$n("real"), "ab", Keys.ENTER)
      verifyEquals("ab", jq(jq(".z-combobox").toWidget().$n("real")).`val`());
    })
  }
}



