/* B50_2936095Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2936095Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
    Please click dropdown button, and then the listitem displays well.
    <combobox id='cb' onOpen='if(self.getItems().size()==0) if
(event.isOpen()) GetTableNames()'/>
    <zscript>
        <![CDATA[
            public void GetTableNames ()
{
for (int i=1; i<=100; i++)
{
Comboitem ci = new Comboitem ("TableName" + i);
cb.appendChild (ci);
}
}
        ]]>
    </zscript>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      //Strange. throw exception in next statement. Then, how can we test if exist?
      //verifyFalse(jq(jq(".z-combobox").toWidget().$n("pp")).exists())
      click(jq("$cb").toWidget().$n("btn"))
      waitResponse()
      verifyTrue(jq(jq(".z-combobox").toWidget().$n("pp")).exists())
    })
  }
}



