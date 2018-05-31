/* B30_1823357Test.java

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
import org.zkoss.ztl.Widget


class B30_1823357Test extends ZTL4ScalaTestCase {
  @Test
  def testColspan() = {
    var zscript =
      """
				<zk>
				<html><![CDATA[
				[ 1823357 ] auxHeader(IE)- Can not change rowspan dynamically</br>
				]]></html>
					<tree id="tree2" width="240px">
						<treecols>
							<treecol label="A" />
							<treecol label="B" />
							<treecol label="C" />
						</treecols>
						<auxhead>
							<auxheader id="Phi" label="Phi"  colspan="2" />
						</auxhead>
					</tree>
					<button label="test" onClick="Phi.setColspan(3)" />
				</zk>
			 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree2 = ztl$engine.$f("tree2")
    val Phi = ztl$engine.$f("Phi")
    runZTL(zscript, () => {
      click(jq(".z-button"))
      waitResponse()
      //System.out.println("colspan: " + jq(Phi).attr("colspan"))
      verifyEquals("3", jq(Phi).attr("colspan"))
    })
  }
}



