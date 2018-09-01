/* B30_1869062Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1869062Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
					<n:p>Please type the "c" word into combobox and then press the ENTER on the keyboard, it should not be shown any error.</n:p>
					<window title="Combobox demo" border="normal">
						Combobox:
						<combobox autodrop="true">
							<attribute name="onChange">
							    if(self.getSelectedItem()!=null){
							     msg.value = self.getSelectedItem().getLabel();
							    }
							</attribute>
							<comboitem label="Simple and Rich" />
							<comboitem label="Cool!" />
							<comboitem label="Thumbs Up!" />
						</combobox>
						<label id="msg" />
					</window>
				</zk>
			 """
    val ztl$engine = engine()
    val msg = ztl$engine.$f("msg")
    runZTL(zscript, () => {
      var combobox = jq(jq(".z-combobox").toWidget().$n("real"))
      typeKeys(combobox, "C")
      waitResponse()
      //2010/10/22 TonyQ:the comboitem should appear in window.
      verifyTrue(jq(jq(".z-combobox").toWidget().$n("pp")).exists())
      click(jq(".z-comboitem:eq(1)"))
      waitResponse()
      verifyEquals("Cool!", jq("$msg").text())
    })
  }
}



