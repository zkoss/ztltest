/* F30_1843802Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class F30_1843802Test extends ZTL4ScalaTestCase {
  @Test
  def testTest() = {
    var zscript =
      """
			
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:h2>[ 1843802 ] Comboitem supports the disabled property</n:h2>
				<n:ol>
					<n:li>You should not select the disabled item.</n:li>
					<n:li>Even you key the value of disabled item, you still can not selected on it, try typing "Simple and Rich" and you will get a error.</n:li>
				</n:ol>
				<button label="show selected" onClick='lb.value = cb1.selectedIndex' />
				<combobox id="cb" constraint="strict">
					<comboitem label="item1" disabled="true"/>
					<comboitem label="item2"/>
					<comboitem label="item3" disabled="true"/>
					<comboitem label="item4" />
				</combobox>
				<label id="lb" />
			</zk>
		"""
    val ztl$engine = engine()
    val cb = ztl$engine.$f("cb")
    val lb = ztl$engine.$f("lb")
    runZTL(zscript, () => {
      verifyFalse(jq(jq(".z-combobox").toWidget().$n("pp")).isVisible())
      click(cb.$n("btn"))
      waitResponse()
      verifyTrue(jq(jq(".z-combobox").toWidget().$n("pp")).isVisible())
      click(jq("@comboitem").get(0)); // disabled comboitem, shall do nothing
      verifyEquals("", cb.$n("real").attr("value"))
      verifyTrue(jq(jq(".z-combobox").toWidget().$n("pp")).isVisible()); // popup shall still be open
      click(jq("@comboitem").get(1))
      verifyEquals("item2", cb.$n("real").attr("value"))
      verifyFalse(jq(jq(".z-combobox").toWidget().$n("pp")).isVisible())
      typeKeys(cb.$n("real"), "item1")
      blur(cb.$n("real"))
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



