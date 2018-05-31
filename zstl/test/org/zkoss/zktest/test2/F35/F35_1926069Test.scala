/* F35_1926069Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class F35_1926069Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<vbox>

<hbox>onChange:<label id='inf1'/></hbox>
<hbox>onOpen:<label id='inf2'/></hbox>

1. Type "abc" in bandbox and then click the dropdown button.
You shall see "abc,,true" shown after onOpen.

	<bandbox onChange="inf1.value=self.value;"
	 onOpen='inf2.value = event.value + "," + self.value + "," + event.open'/>

1. Type "xyz" in combox and then click the dropdown button.
You shall see "xyz,,true" shown after onOpen.

	<combobox onChange="inf1.value=self.value;"
	 onOpen='inf2.value = event.value + "," + self.value + "," + event.open'>
		<comboitem label="Simple and Rich"/>
		<comboitem label="Cool!"/>
		<comboitem label="Thumbs Up!"/>
	</combobox>
</vbox>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val inf1 = ztl$engine.$f("inf1")
    val inf2 = ztl$engine.$f("inf2")
    runZTL(zscript, () => {
      typeKeys(jq("@bandbox").toWidget().$n("real"), "abc")
      waitResponse()
      click(jq(".z-bandbox").toWidget().$n("btn"))
      waitResponse()
      verifyEquals("abc,abc,true", jq(inf2).text())
      typeKeys(jq("@combobox").toWidget().$n("real"), "xyz")
      waitResponse()
      click(jq(".z-combobox").toWidget().$n("btn"))
      waitResponse()
      verifyEquals("xyz,xyz,true", jq(inf2).text())
    })
  }
}



