/* B50_2925493Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2925493Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
				Please check the combobox will fire onChange event after select an item and focus out of combobox
					<vbox>
						Auto-complete Combobox:
						<combobox id="combo" autodrop="true"
							onChange='alert(self.getValue()); if(self.getSelectedItem()!=null)msg.value=self.getSelectedItem().getLabel()'
							constraint="no empty" />
						<label value="select:" />
						<label id="msg" />
						<hbox>
							<checkbox checked="true"
								onCheck="combo.autodrop = self.checked"
								label="auto drop popup when typing" />
							<checkbox checked="true"
								onCheck="combo.buttonVisible = self.checked" label="button visible" />
						</hbox>
					</vbox>
					<zscript>
					String[] _dict = { "abacus", "accuracy", "acuity", "adage", "afar",
							"after", "apple", "bible", "bird", "bingle", "blog", "cabane",
							"cape", "cease", "cedar", "dacron", "defacto", "definable",
							"deluxe", "each", "eager", "effect", "efficacy", "far", "far from",
							"girl", "gigantean", "giant", "home", "honest", "huge",
							"information", "inner", "jump", "jungle", "jungle fever", "kaka",
							"kale", "kame", "lamella", "lane", "lemma", "master", "maxima",
							"music", "nerve", "new", "number", "omega", "opera", "pea",
							"peace", "peaceful", "rock", "RIA", "sound", "spread", "student",
							"super", "tea", "teacher", "unit", "universe", "vector", "victory",
							"wake", "wee", "weak", "web2.0", "xeme", "yea", "yellow", "zebra",
							"zk",
				
					};
					ListModel dictModel = new SimpleListModel(_dict);
					combo.setModel(dictModel);
				</zscript>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val combo = ztl$engine.$f("combo")
    val msg = ztl$engine.$f("msg")
    runZTL(zscript, () => {
      var inp = jq(".z-combobox").toWidget().$n("real")
      focus(jq(inp))
      sendKeys(jq(inp), "a")
      waitResponse(true)
      verifyNotEquals("A", jq(inp).`val`())
      waitResponse(true)
      verifyTrue(isVisible(jq(".z-comboitem")))
      click(jq(".z-comboitem:eq(0)"))
      waitResponse()
      click(jq(".z-window-highlighted @button"))
      waitResponse()
      verifyEquals("abacus", jq(msg).text())
    })
  }
}



