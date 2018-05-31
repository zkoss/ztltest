/* B35_2386650Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B35_2386650Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
<tabbox id='tbStats'>
</tabbox>
<button label="Click me once if no error, that is correct" onClick="InitTabbox(); self.disabled = true"/>
<zscript>
public void InitTabbox ()
{
Tabs tabs = new Tabs ();
Tabpanels tps = new Tabpanels ();
Tab t = new Tab ("Tab1");
t.setAttribute ("code","ShenZhen");
t.setAttribute ("name", "new Tab");
tabs.appendChild (t);
tbStats.appendChild (tabs);
}
//InitTabbox ();
</zscript>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tbStats = ztl$engine.$f("tbStats")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      //NullPointerException
      verifyFalse(jq("@window").exists())
    })
  }
}



