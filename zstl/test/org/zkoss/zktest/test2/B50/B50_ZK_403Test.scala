/* B50_ZK_403Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_ZK_403Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<zscript><![CDATA[
					String[] dictionary = { "abacus", "abase", "barcarole", "barefaced", "cadence", "cadenza", "death's-head", "debacle", "endear", "endemic", "endue", "facial", "facile", "facilitate", "gaiety", "gaily", "gainsay", "writhe", "writing", "wry", };
					
					ListModel dictModel= new SimpleListModel(dictionary);
					]]>
				</zscript>
				<div>
					Please test the following steps 4~5 times and each time test you have to reload this case.
					<separator/>
					1. type 'a' in the inputbox and the dropdownlist shall show 2 items. (please focus into the inputbox and type rapidly)
					
				</div>
				<combobox id="cb" autodrop="true" >
					<attribute name="onOpen"><![CDATA[
					self.setModel(dictModel);
					]]></attribute>
				</combobox>
				<combobox id="cb2" autodrop="true" >
					<attribute name="onOpen"><![CDATA[
					self.setModel(dictModel);
					]]></attribute>
				</combobox>
				<combobox id="cb3" autodrop="true" >
					<attribute name="onOpen"><![CDATA[
					self.setModel(dictModel);
					]]></attribute>
				</combobox>
				<combobox id="cb4" autodrop="true" >
					<attribute name="onOpen"><![CDATA[
					self.setModel(dictModel);
					]]></attribute>
				</combobox>
				<combobox id="cb5" autodrop="true" >
					<attribute name="onOpen"><![CDATA[
					self.setModel(dictModel);
					]]></attribute>
				</combobox>
			</zk>

		"""
    val ztl$engine = engine()
    val cb = ztl$engine.$f("cb")
    val cb2 = ztl$engine.$f("cb2")
    val cb3 = ztl$engine.$f("cb3")
    val cb4 = ztl$engine.$f("cb4")
    val cb5 = ztl$engine.$f("cb5")
    runZTL(zscript, () => {
      var cbs = Array(cb, cb2, cb3, cb4, cb5)
      for (i <- 0 until cbs.length) {
        click(cbs(i).$n("real"))
        typeKeys(cbs(i).$n("real"), "a")
        sleep(2000)
        verifyTrue(jq(cbs(i).$n("cave")).children().length() == 2)
      }
    })
  }
}



